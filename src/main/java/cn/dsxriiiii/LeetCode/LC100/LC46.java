package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 15:49
 * @Description:
 **/
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        dfs(res,temp,0,nums.length);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int i, int n) {
        if(i == n){
            res.add(new ArrayList<>(temp));
        }else{
            for (int j = i; j < n ; j++) {
                Collections.swap(temp,i,j);
                dfs(res, temp, i + 1, n);
                Collections.swap(temp,i,j);
            }
        }
    }
}
