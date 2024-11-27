package cn.dsxriiiii.LeetCode.codetop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.codetop
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/19 17:15
 * @Description:
 **/
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i - k){
                deque.pollFirst();
            }
            ans[i - k + 1] = deque.peekFirst();
        }
        return ans;
    }
}
