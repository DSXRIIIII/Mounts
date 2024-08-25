package cn.dsxriiiii.ScenarioQuestion.ThreadPrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ThreadPrinterABC
 * @Date 2024/8/21 15:06
 * @Description: 三个线程交替打印ABC
 * 三个condition抢一把锁
 * A：0->'A'  B：1->'B'  C：1->'C'
 * 每一个condition满足上面的条件才会打印 否则只会wait等待
 * 当打印完毕后会notify通知下一个condition获取锁 当锁释放时 condition_next会尝试获取锁并且执行
 */
public class PrinterABC {
    private final int max;
    private int turn = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition_a = reentrantLock.newCondition(); //创建与锁相关联的条件对象
    private final Condition condition_b = reentrantLock.newCondition();
    private final Condition condition_c = reentrantLock.newCondition();
    public PrinterABC(int max){
        this.max = max;
    }
    public void printA(){
        print("A",condition_a,condition_b);
    }
    public void printB(){
        print("B",condition_b,condition_c);
    }
    public void printC(){
        print("C",condition_c,condition_a);
    }

    private void print(String name, Condition condition, Condition condition_to) {
        for (int i = 0; i < max; i++) {
            reentrantLock.lock();
            try{
                while(!((turn == 0 && name.charAt(0) == 'A') || (turn == 1 && name.charAt(0) == 'B') || (turn == 2 && name.charAt(0) == 'C')) ){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + name);
                turn = (turn+1)%3;
                condition_to.signal();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrinterABC printerABC = new PrinterABC(10);
        Thread t1 = new Thread(printerABC::printA,"A");
        Thread t2 = new Thread(printerABC::printB,"B");
        Thread t3 = new Thread(printerABC::printC,"C");
        t1.start();
        t2.start();
        t3.start();
    }
}
