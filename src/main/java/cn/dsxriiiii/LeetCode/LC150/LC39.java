package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 15:08
 * @Email: lihh53453@hundsun.com
 * @Description: 组合总和
 * 思路：回溯+target-目标值+跳过节点
 */
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates,target,0,res,temp);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> temp) {
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(index == candidates.length){
            return;
        }
        dfs(candidates,target,index+1,res,temp);
        if(target - candidates[index] >= 0){
            temp.add(candidates[index]);
            dfs(candidates,target - candidates[index],index,res,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
