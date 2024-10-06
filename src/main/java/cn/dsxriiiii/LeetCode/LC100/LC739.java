package cn.dsxriiiii.LeetCode.LC100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 15:06
 * @Description: LC739
 **/
public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while(!stack.isEmpty() && t > temperatures[stack.peek()]){
                Integer index = stack.poll();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }
}
