package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 16:51
 * @Email: lihh53453@hundsun.com
 * @Description:
 * 剪枝 假如 n = 4  k = 15  temp.size() == 1 此时已经有了一个数 再选n - temp.size()个数
 * 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n  ->  13 + 3 - 1 = 15
 * 最小上界为 13 -> 13 14 15
 * 最小上界为 k - n - (k - path.size()) + 1
 *
 */
public class LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();
        dfs(temp,res,1,n,k);
        return res;
    }

    private void dfs(Deque<Integer> temp, List<List<Integer>> res, int begin, int n, int k) {
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
        }else{
            //优化剪枝
            //for(int i = begin;i <= n;i++){
            for(int i = begin;i <= k - n - (k - temp.size()) + 1;i++){
                temp.addLast(i);
                dfs(temp, res, i + 1, n, k);
                temp.removeLast();
            }
        }
    }
}
