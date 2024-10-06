package cn.dsxriiiii.LeetCode.LC100;

import java.net.InetSocketAddress;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 15:36
 * @Description: LC84
 **/
public class LC84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[i] < heights[stack.peek()]){
                int height = heights[stack.poll()];
                int wight = i - stack.peek() - 1;
                res = Math.max(res,height * wight);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int height = heights[stack.poll()];
            int wight = heights.length - stack.peek() - 1;
            res = Math.max(res,height * wight);
        }
        return res;
    }
}
