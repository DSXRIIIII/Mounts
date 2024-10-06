package cn.dsxriiiii.LeetCode.LC100;

import cn.dsxriiiii.LeetCode.LC150.Temp;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/04 14:12
 * @Description:
 **/
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates,target,res,temp,0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int index) {
        if(index == candidates.length){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(candidates,target,res,temp,index + 1);
        if(target - candidates[index] > 0){
            temp.add(candidates[index]);
            dfs(candidates,target - candidates[index],res,temp,index + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
