package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Description: 两数之和
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/19 14:11
 * @Email: lihh53453@hundsun.com
 * 思路：哈希表
 *      1.把值和index绑定在hashmap中
 *      2.注意匹配 两数之和即 target - 其中一数
 */
public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
