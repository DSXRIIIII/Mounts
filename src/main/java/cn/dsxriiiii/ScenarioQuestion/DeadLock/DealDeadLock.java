package cn.dsxriiiii.ScenarioQuestion.DeadLock;

import cn.hutool.core.date.DateUtil;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.DeadLock
 * @Date 2024/8/21 16:39
 * @Description: 死锁的场景
 * 线程1拿到资源1 和 资源2 并且不会保持 此时线程2会等待线程1执行完毕才会继续执行
 */
public class DealDeadLock {
    private static final Object resource_1 = new Object();
    private static final Object resource_2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("当前时间为："+ DateUtil.now());
            }
        }).start();
        new Thread(()->{
            synchronized (resource_1){
                System.out.println(Thread.currentThread().getName() + "拿到了资源1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "等待资源2");
                synchronized (resource_2){
                    System.out.println(Thread.currentThread().getName() + "拿到了资源2");
                }
            }
        },"Thread1").start();

//        new Thread(()->{
//            synchronized (resource_2){
//                System.out.println(Thread.currentThread().getName() + "拿到了资源2");
//            }
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(Thread.currentThread().getName() + "等待资源1");
//            synchronized (resource_1){
//                System.out.println(Thread.currentThread().getName() + "拿到了资源1");
//            }
//        },"Thread2").start();

        // 解决措施2
        new Thread(() -> {
            synchronized (resource_1) {
                System.out.println(Thread.currentThread() + "获取资源1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "等待资源2");

                synchronized (resource_2) {
                    System.out.println(Thread.currentThread() + "获取资源2");
                }
            }
        }, "线程 2").start();
    }


}
