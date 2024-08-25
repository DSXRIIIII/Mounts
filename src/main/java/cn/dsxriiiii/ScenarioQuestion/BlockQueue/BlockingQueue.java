package cn.dsxriiiii.ScenarioQuestion.BlockQueue;

import com.sun.xml.internal.bind.v2.util.StackRecorder;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.BlockQueue
 * @Date 2024/8/22 14:22
 * @Description: 实现一个阻塞队列
 * 1.线程安全
 * 2.保证对阻塞的改造
 */
public class BlockingQueue {
    private int[] items;
    volatile private int head = 0;
    volatile private int tail = 0;
    volatile private int size = 0;
    public BlockingQueue(){
        this.items = new int[100];
    }
    public void put(int element) throws InterruptedException {
        synchronized (this){
            while (size >= items.length){
                this.wait();
            }
            //实现循环队列
            if(tail >= items.length){
                tail = 0;
            }
            items[tail] = element;
            tail++;
            size++;
            this.notify();
        }
    }
    public int take() throws InterruptedException {
        synchronized (this){
            while (size == 0){
                this.wait();
            }
            if(head >= items.length){
                head = 0;
            }
            int elem = items[head];
            head++;
            size--;
            this.notify();
            return elem;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        Thread product = new Thread(()->{
            int count = 0;
            while(true){
                try{
                    blockingQueue.put(count);
                    System.out.println("生产元素：>"+count);
                    count++;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(()->{
            int count = 0;
            while(true){
                try{
                    int elem = blockingQueue.take();
                    System.out.println("消费元素：>"+elem);
                    count++;
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        product.start();
        consumer.start();
    }
}
