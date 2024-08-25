package cn.dsxriiiii.ScenarioQuestion.Executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.CAS
 * @Date 2024/8/21 16:15
 * @Description: 实现线程安全的计数器：100个线程，每个线程累加100次
 */
public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个线程池，核心线程数和最大线程数都为 100，无界队列，线程空闲 60 秒后销毁
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(100, 100,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());
        AtomicLong counter = new AtomicLong();
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()->{
                for (int j = 0; j < 100; j++) {
                    counter.incrementAndGet();
                }
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS); //设置超长时间
        System.out.println("final res:" + counter.get());
    }

}
