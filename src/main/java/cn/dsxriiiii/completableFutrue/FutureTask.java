package cn.dsxriiiii.completableFutrue;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @PackageName: cn.dsxriiiii.completableFutrue
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/23 16:05
 * @Description: future任务
 **/
public class FutureTask {
    public static void main(String[] args){
        try{
            CompletableFuture<Void> task1 = CompletableFuture.runAsync(()->System.out.println("hello! I am Task1 using runAsync"));
            task1.get(5, TimeUnit.SECONDS);//输出hello 会阻塞

            /*
             * 当我们获取到异步计算的结果之后，还可以对其进行进一步的处理，
             * 比较常用的方法有下面几个：
             * thenApply()
             * thenAccept()
             * thenRun()
             * whenComplete()
             */
            CompletableFuture<String> task2 = CompletableFuture.completedFuture("hello!")
                    .thenApply(s->s+"world!");
            //这次调用将被忽略。
            task2.thenApply(s -> s + "nice!");

            CompletableFuture<String> task3 = CompletableFuture.completedFuture("hello!")
            .thenApply(s->s+"world!").thenApply(s->s+"nice!");

            CompletableFuture<String> task4 = CompletableFuture.supplyAsync(() -> "hello!")
                    .whenComplete((res, ex) -> {
                        // res 代表返回的结果
                        // ex 的类型为 Throwable ，代表抛出的异常
                        System.out.println(res);
                        if(ex != null){
                            ex.printStackTrace();
                        }
                    });
            Random rand = new Random();
            CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000 + rand.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("future1 done...");
                }
                return "abc";
            });
            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000 + rand.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("future2 done...");
                }
                return "efg";
            });
            CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1,future2);
            voidCompletableFuture.join();
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


    }
}
