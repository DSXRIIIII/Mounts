package cn.dsxriiiii.algorithm.RollBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 求子集
 */
public class LC78 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums){
        dfs(0,nums);
        return res;
    }

    public static void dfs(int i, int[] nums) {
        if(i == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(i+1,nums);
        temp.remove(temp.size() - 1);
        dfs(i + 1,nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
