package cn.dsxriiiii.ScenarioQuestion.ThreadPrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.ThreadPrintABC
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/14 11:19
 * @Description:
 **/
public class PrintABCPractice {
    private final int max;
    private int index = 0;
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition_a = reentrantLock.newCondition();
    private final Condition condition_b = reentrantLock.newCondition();
    private final Condition condition_c = reentrantLock.newCondition();
    public PrintABCPractice(int max){
        this.max = max;
    }
    public void print_A(){
        print("A",condition_a,condition_b);
    }
    public void print_B(){
        print("B",condition_b,condition_c);
    }
    public void print_C(){
        print("C",condition_c,condition_a);
    }

    private void print(String name,Condition condition_from,Condition condition_to){
        for (int i = 0; i < max; i++) {
            reentrantLock.lock();
            try {
                while (!((name.charAt(0) != 'A' && index != 0) || (name.charAt(0) != 'B' && index != 1) || (name.charAt(0) != 'C' && index != 2))) {
                    condition_from.wait();
                }
                index = (index + 1) & 3;
                System.out.println(Thread.currentThread().getName() + "线程打印：" + name);
                condition_to.signal();
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                reentrantLock.unlock();
            }
        }
//        while(index++ <= max){
//            reentrantLock.lock();
//            try {
//                while (!((name.charAt(0) != 'A' && index != 0) || (name.charAt(0) != 'B' && index != 1) || (name.charAt(0) != 'C' && index != 2))) {
//                    condition_from.await();
//                }
//                index = (index + 1) & 3;
//                System.out.println(Thread.currentThread().getName() + "线程打印：" + name);
//                condition_to.signal();
//            }catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }finally {
//                reentrantLock.unlock();
//            }
//        }
    }

    public static void main(String[] args) {
        PrinterABC printerABC = new PrinterABC(10);
        Thread A = new Thread(printerABC::printA,"A");
        Thread B = new Thread(printerABC::printB,"B");
        Thread C = new Thread(printerABC::printC,"C");
        A.start();
        B.start();
        C.start();
    }

}
