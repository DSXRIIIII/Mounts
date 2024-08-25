package cn.dsxriiiii.ScenarioQuestion.DeadLock;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.DeadLock
 * @Date 2024/8/21 16:53
 * @Description: 死锁的场景
 * 循环等待
 * 请求与保持
 * 不可剥夺
 * 互斥
 */
public class DeadLock {
    private static final Object resource_1 = new Object();
    private static final Object resource_2 = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (resource_1){
                System.out.println(Thread.currentThread().getName() + "拿到了资源1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "等待资源2");
                synchronized (resource_2){
                    System.out.println(Thread.currentThread().getName() + "拿到了资源2");
                }
            }
        },"Thread1").start();

        new Thread(()->{
            synchronized (resource_2){
                System.out.println(Thread.currentThread().getName() + "拿到了资源2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "等待资源1");
                synchronized (resource_1){
                    System.out.println(Thread.currentThread().getName() + "拿到了资源1");
                }
            }
        },"Thread2").start();
    }
}
