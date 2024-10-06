package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 11:40
 * @Description: LC15
 **/
public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = - nums[first];
            int third = nums.length - 1;
            for(int second = first + 1;second < nums.length;second++){
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
