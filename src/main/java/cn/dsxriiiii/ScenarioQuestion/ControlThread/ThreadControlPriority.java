package cn.dsxriiiii.ScenarioQuestion.ControlThread;

import cn.hutool.core.date.DateUtil;

import java.util.concurrent.CompletableFuture;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ControlThread
 * @Date 2024/8/21 16:31
 * @Description: 控制三个线程的执行顺序
 */
public class ThreadControlPriority {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> futureT1 = CompletableFuture.runAsync(()->{
            System.out.println("T1 is executing,CurrentTime:"+ DateUtil.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> futureT2 = futureT1.thenRunAsync(()->{
            System.out.println("T2 is executing after T1,CurrentTime:"+ DateUtil.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(1000);
        CompletableFuture<Void> futureT3 = futureT2.thenRunAsync(()->{
            System.out.println("T3 is executing after T2,CurrentTime:"+ DateUtil.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(3000);
    }
}
