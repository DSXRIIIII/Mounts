package cn.dsxriiiii.LeetCode.LC100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 16:36
 * @Description: LC295
 **/
public class LC295 {
    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>((i,j) -> j - i);
            max = new PriorityQueue<>((i,j) -> i - j);
        }

        public void addNum(int num) {
            if(min.isEmpty() || num < min.peek()){
                min.add(num);
                if(min.size() - max.size() > 1){
                    max.add(min.poll());
                }
            }else{
                max.add(num);
                if(max.size() > min.size()){
                    min.add(max.peek());
                }
            }
        }

        public double findMedian() {
            if(min.size() > max.size()){
                return Double.valueOf(min.peek());
            }
            return (min.peek() + max.peek()) / 2.0;
        }
    }
}
