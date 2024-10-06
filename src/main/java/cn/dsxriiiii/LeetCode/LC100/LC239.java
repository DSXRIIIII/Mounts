package cn.dsxriiiii.LeetCode.LC100;

import java.util.PriorityQueue;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 0:26
 * @Description: LC239
 **/
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                //降序排列
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[len - k  + 1];
        assert pq.peek() != null;
        ans[0] = pq.peek()[0];
        //确保优先队列 pq 中存储的元素对应的索引不超过当前窗口的左边界。也就是说，当一个元素的索引小于等于 i - k 时，它已经不在当前的滑动窗口内了
        for(int i = k;i < len; i++){
            pq.offer(new int[]{nums[i],i});
            while(pq.peek()[1] <= i - k){
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        LC239 lc239 = new LC239();
        lc239.maxSlidingWindow(nums, 3);
    }
}
