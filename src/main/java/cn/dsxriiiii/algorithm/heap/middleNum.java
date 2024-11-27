package cn.dsxriiiii.algorithm.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.algorithm.heap
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/09 20:42
 * @Description:
 **/
public class middleNum {
    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] s = scanner.nextLine().split(" ");
        for (String val : s){
            addNum(Integer.parseInt(val));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(findMiddle() + " ");
        }
    }
    public static int findMiddle(){
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.poll();
        }else if(minHeap.size() > maxHeap.size()){
            return minHeap.poll();
        }
        if (!maxHeap.isEmpty() & !minHeap.isEmpty()) {
            int minOfTwo = Math.min(maxHeap.peek(), minHeap.peek());
            if (minOfTwo == maxHeap.peek()) {
                maxHeap.poll();
            } else {
                minHeap.poll();
            }
            return minOfTwo;
        }
        return 0;
    }
    private static void addNum(int num){
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.offer(minHeap.poll());
        }
    }
}
