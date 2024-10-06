package cn.dsxriiiii.ScenarioQuestion.valate;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.valate
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 17:17
 * @Description: v
 **/
public class VolatileExample {
    private volatile boolean flag = false;
    private int counter = 0;

    public void startThreads() {
        // 线程1：不断检查 flag 并执行一些操作
        new Thread(() -> {
            while (!flag) {
                // 等待 flag 变为 true
            }
            synchronized (this) {
                counter++;
                System.out.println("Thread 1: Counter incremented. Current value: " + counter);
            }
        }).start();

        // 线程2：在某个时刻设置 flag 为 true
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                flag = true;
                System.out.println("Thread 2: Flag set to true.");
            }
        }).start();
    }
}
