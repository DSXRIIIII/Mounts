package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 17:05
 * @Description: LC45
 **/
public class LC45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int max_index = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            max_index = Math.max(max_index,nums[i] + i);
            if(end == i){
                end = max_index;
                step++;
            }
        }
        return step;
    }
}
