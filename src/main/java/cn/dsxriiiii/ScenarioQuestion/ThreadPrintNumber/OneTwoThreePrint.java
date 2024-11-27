package cn.dsxriiiii.ScenarioQuestion.ThreadPrintNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.ThreadPrintOE
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/14 11:37
 * @Description:
 **/
public class OneTwoThreePrint {
    private final int max;
    private int number;
    private OneTwoThreePrint(int max){
        this.max = max;
    }
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition_a = reentrantLock.newCondition();
    private final Condition condition_b = reentrantLock.newCondition();
    private final Condition condition_c = reentrantLock.newCondition();
    private void print_a(){
        print(()-> number % 3 == 0,condition_a,condition_b);
    }
    private void print_b(){
        print(()-> number % 3 == 1,condition_b,condition_c);
    }
    private void print_c(){
        print(()-> number % 3 == 2,condition_c,condition_a);
    }

    private void print(Supplier<Boolean> shouldP, Condition conditionFrom, Condition conditionTo) {
//        0~101
        for (int i = 0; i <= max && number < max - 1; i+=3) {
            reentrantLock.lock();
            try{
                while(!shouldP.get()){
                    conditionFrom.await();
                }
                System.out.println(Thread.currentThread().getName() + "打印："+ number++);
                conditionTo.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
//        while(number < max - 1){
//            reentrantLock.lock();
//            try{
//                while(!shouldP.get()){
//                    conditionFrom.await();
//                }
//                System.out.println(Thread.currentThread().getName() + "打印："+ number++);
//                conditionTo.signal();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                reentrantLock.unlock();
//            }
//        }
    }

    public static void main(String[] args) {
        OneTwoThreePrint oneTwoThreePrint = new OneTwoThreePrint(99);
        Thread A = new Thread(oneTwoThreePrint::print_a,"A");
        Thread B = new Thread(oneTwoThreePrint::print_b,"B");
        Thread C = new Thread(oneTwoThreePrint::print_c,"C");
        A.start();
        B.start();
        C.start();
    }
}
