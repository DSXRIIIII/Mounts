package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 13:36
 * @Description:
 **/
public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> t = new ArrayList<Integer>();
        dfs(res,nums,0,t);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int i,List<Integer> t) {
        if(i == nums.length){
            res.add(new ArrayList<>(t));
        }
        t.add(nums[i]);
        dfs(res,nums,i+1,t);
        t.remove(t.size() - 1);
        dfs(res,nums,i+1,t);
    }
}
