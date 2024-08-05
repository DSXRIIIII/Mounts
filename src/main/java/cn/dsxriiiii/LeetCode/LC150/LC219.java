package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Description: 存在重复元素 II
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/2 21:05
 * @Email: lihh53453@hundsun.com
 * 哈希表和滑动数组解决
 * 1.哈希表可以保存数据坐标值和数组值相互对应上
 * 2.看到固定距离就要想到滑动窗口 而滑动窗口要想到set集合 或者队列
 */
public class LC219 {
    public boolean containsNearbyDuplicate_byMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }

    /**
     * 假设为4 位置i = 3  5 - 4 - 1 只有比窗口大的时候才会有减的空间 因为i-k限定了
     * 0 1 2 3 4
     * 1 2 3 4 -> 3
     *   2 3 4 5
     * @param nums 初始数组
     * @param k 滑动窗口大小
     * @return boolean
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if(i > k){
                set.remove(nums[i - k - 1]);
            }
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
