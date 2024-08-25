package cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE
 * @Date 2024/8/21 14:33
 * @Description: 两个线程打印奇数和偶数
 * 拿到锁->执行打印操作->notify通知
 * 奇数锁->奇数通知->偶数锁->偶数通知
 *
 */
public class ParityPrinter {
    private final int max;
    private int count = 1;
    private final Object lock = new Object();
    private ParityPrinter(int max){
        this.max = max;
    }
    private void printOdd(){ //偶数
        print(true);
    }

    private void printEven(){ //奇数
        print(false);
    }
    private void print(boolean isOdd){
        for (int i = 1; i <= max; i+=2) {
            synchronized (lock){
                while(isOdd == (count % 2 == 0)){ //
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName() + ":" + count++);
                lock.notify(); //唤醒等待线程
            }
        }
    }

    public static void main(String[] args) {
        ParityPrinter parityPrinter = new ParityPrinter(100);
        Thread t1 = new Thread(parityPrinter::printOdd,"Odd");
        Thread t2 = new Thread(parityPrinter::printEven,"Even");
        t1.start();
        t2.start();
    }
}
