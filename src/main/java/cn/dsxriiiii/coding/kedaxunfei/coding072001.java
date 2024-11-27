package cn.dsxriiiii.coding.kedaxunfei;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/09 20:12
 * @Description:
 **/
public class coding072001 {

    private static PriorityQueue<Integer> small = new PriorityQueue<>(); // min heap
    private static PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> b - a); // max heap

    public static void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if (large.size() < small.size()) {
            large.offer(small.poll());
        }
    }

    public static int findMedian() {
        if (large.size() > small.size()) {
            return large.peek();
        } else if (large.size() < small.size()) {
            return small.peek();
        } else {
            return (large.peek() + small.peek()) / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int x : a) {
            addNum(x);
            result.add(findMedian());
        }
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
