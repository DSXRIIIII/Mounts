package cn.dsxriiiii.coding.c4399;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.c4399
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/26 17:40
 * @Description:
 **/

class Order {
    int restaurant_id;
    int start_time;
    int priority;
    int delivery_time;
    int index;

    public Order(int restaurant_id, int start_time, int priority, int delivery_time, int index) {
        this.restaurant_id = restaurant_id;
        this.start_time = start_time;
        this.priority = priority;
        this.delivery_time = delivery_time;
        this.index = index;
    }
}

class CompareOrder implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        if (o1.priority!= o2.priority) {
            return o1.priority < o2.priority? -1 : 1;
        }
        if (o1.delivery_time!= o2.delivery_time) {
            return o1.delivery_time > o2.delivery_time? -1 : 1;
        }
        return o1.restaurant_id > o2.restaurant_id? -1 : 1;
    }
}

class CompareDeliveryTime implements Comparator<Integer> {

    @Override
    public int compare(Integer t1, Integer t2) {
        return t1 > t2? -1 : 1;
    }
}
public class coding081203 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int P = scanner.nextInt();

        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            int restaurant_id = scanner.nextInt();
            int start_time = scanner.nextInt();
            int priority = scanner.nextInt();
            int delivery_time = scanner.nextInt();
            orders.add(new Order(restaurant_id, start_time, priority, delivery_time, i));
        }

        // 按产生时间排序
        orders.sort((a, b) -> a.start_time - b.start_time);

        PriorityQueue<Order> orderQueue = new PriorityQueue<>(new CompareOrder());
        PriorityQueue<Integer> freeDeliverers = new PriorityQueue<>(new CompareDeliveryTime());

        // 所有外卖员初始都是空闲的
        for (int i = 0; i < M; i++) {
            freeDeliverers.add(0);
        }

        int i = 0;

        while (i < orders.size() ||!orderQueue.isEmpty()) {
            // 将所有在当前时间点或之前产生的订单加入优先级队列
            while (i < orders.size() && orders.get(i).start_time <= freeDeliverers.peek()) {
                orderQueue.add(orders.get(i));
                i++;
            }

            if (!orderQueue.isEmpty()) {
                // 选择最优订单进行配送
                Order bestOrder = orderQueue.poll();

                // 外卖员取出队列中空闲最早的外卖员
                int availableTime = freeDeliverers.poll();

                // 计算送达时间
                int finishTime = Math.max(availableTime, bestOrder.start_time) + bestOrder.delivery_time;
                result.add(finishTime);

                // 更新该外卖员的空闲时间
                freeDeliverers.add(finishTime);
            } else {

                if (i < orders.size()) {
                    while (!freeDeliverers.isEmpty() && freeDeliverers.peek() < orders.get(i).start_time) {
                        freeDeliverers.poll();
                        freeDeliverers.add(orders.get(i).start_time);
                    }
                }
            }
        }

        for (int j = 0; j < result.size(); j++) {
            System.out.println(result.get(j));
        }
    }
}
