package cn.dsxriiiii.algorithm.RollBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 */
public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        if(len == 0){
            return res;
        }
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res) {
        if(target < 0) return;
        if(target == 0) res.add(new ArrayList<>(path));
        for(int i = begin;i < len;i++){
            path.add(i);
            //dfs(candidates, begin, len, target, path, res);//[[2,2,3],[2,3,2],[3,2,2],[7]] 完全不会去重
            dfs(candidates, i, len, target, path, res);//[[2,2,3],[7]]  有重复的组合但是会去重
            //dfs(candidates, i+1, len, target, path, res);[[7]] 完全没有重复的组合
            path.remove(path.size() - 1);
        }
    }
}
