package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer
 * @Date 2024/8/22 14:13
 * @Description: 消费者
 */
public class Customer implements Runnable{
    private final BlockingQueue<Integer> queue;
    public Customer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try{
            while(true){
                consume();
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void consume() throws InterruptedException {
        synchronized (queue){
            while(queue.isEmpty()){
                System.out.println("缓冲区为空，消费者等待");
                 queue.wait();
            }
            int item = queue.take();
            System.out.println("消费者消费物品："+item);
            queue.notifyAll();
        }
    }
}
