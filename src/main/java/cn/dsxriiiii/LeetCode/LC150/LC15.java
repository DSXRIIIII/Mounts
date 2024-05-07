package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：三数之和
 * 算法：暴力剪枝 -> O(n**3) -> O(n**2)
 * 优化思路：1.锁定a,b = a + 1,c = len - 1;避免三重循环
 *         2.遇到相同值continue
 */
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        //结果数组
        List<List<Integer>> res = new ArrayList<>();
        for(int a = 0; a < len;a++){
            int target = -nums[a];//确认目标值 锁定a;
            int c = len - 1;//每一次确定第三个值为末尾
            if(a > 0 && nums[a - 1] == nums[a]){
                //a相等去重
                continue;
            }
            for(int b = a + 1;b < len;b++){
                //b的起点为a的下一位
                if(b > a + 1 && nums[b - 1] == nums[b]){
                    //去重
                    continue;
                }
                while(b < c && nums[b] + nums[c] > target){
                    //如果比目标值大 c--使和减少
                    c--;
                }
                //当b追上c是此时没有结果值 退出当前循环
                if(b == c){
                    break;
                }
                //a b c找到结果值时添加进入列表
                if(nums[b] + nums[c] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
