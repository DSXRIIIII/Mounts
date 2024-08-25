package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer;

import java.util.concurrent.BlockingQueue;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer
 * @Date 2024/8/22 14:06
 * @Description: 生产者
 */
public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private final int MAX_SIZE = 5;
    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try{
            for (int i = 0; i <= 10; i++) {
                producer(i);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    private void producer(int item) throws InterruptedException {
        synchronized (queue){
            while (queue.size() == MAX_SIZE){
                System.out.println("缓冲区已满");
                queue.wait();
            }
            queue.put(item);
            System.out.println("生产者生产产品：" + item);
            queue.notifyAll();//唤醒所有等待的线程
        }
    }
}
