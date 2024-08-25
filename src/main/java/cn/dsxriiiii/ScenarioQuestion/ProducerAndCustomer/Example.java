package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.ProducerAndCustomer
 * @Date 2024/8/22 14:18
 * @Description: 生产消费案例
 */
public class Example {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Producer producer = new Producer(queue);
        Customer customer = new Customer(queue);
        Thread producerThread = new Thread(producer);
        Thread customerThread = new Thread(customer);
        producerThread.start();
        customerThread.start();
    }
}
