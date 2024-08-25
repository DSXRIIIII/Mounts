package cn.dsxriiiii.ScenarioQuestion.ThreadPrintNumber;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ThreadPrintNumber
 * @Date 2024/8/21 15:46
 * @Description: 三个线程分别打印1~99
 * 不满足条件时condition会进入await状态
 * 满足条件时 条件number%3 == 0会先拿到锁并且打印 打印完毕 释放锁 并且唤醒条件number%3 == 1 以此类推
 */
public class PrintNumber {
    private final int max;
    private int number = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition_a = lock.newCondition();
    private final Condition condition_b = lock.newCondition();
    private final Condition condition_c = lock.newCondition();
    public PrintNumber(int max){
        this.max = max;
    }
    public void print3n(){
        printNumber(()->number%3 == 0,condition_a,condition_b);
    }
    public void print3nPlus1(){
        printNumber(()->number%3 == 1,condition_b,condition_c);
    }
    public void print3nPlus2(){
        printNumber(()->number%3 == 2,condition_c,condition_a);
    }

    private void printNumber(Supplier<Boolean> shouldPrint, Condition cur, Condition next) {
        while(number < max - 1){
            lock.lock();
            try{
                while(!shouldPrint.get()){
                    cur.await();
                }
                System.out.println(Thread.currentThread().getName() + ":" + number++);
                next.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber(100);
        Thread t1 = new Thread(printNumber::print3nPlus1,"Thread_A");
        Thread t2 = new Thread(printNumber::print3nPlus2,"Thread_B");
        Thread t3 = new Thread(printNumber::print3n,"Thread_C");
        t1.start();
        t2.start();
        t3.start();
    }

}
