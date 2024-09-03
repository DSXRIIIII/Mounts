package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 14:32
 * @Email: lihh53453@hundsun.com
 * @Description: 组合
 * 考虑 res添加时要创建新副本
 * 组合的逻辑：交换+回溯
 * 交换的起点为index 选中之后将不在选中
 */
public class LC46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int num : nums){
            temp.add(num);
        }
        int n = nums.length;
        dfs(res,temp,0,n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int index, int n) {
        if(index == n){
//            res.add(temp);
            //要拷贝一个新的副本 否则会直接引用原来的list集合
            res.add(new ArrayList<>(temp));
        }else{
//            for (int i = 0; i < n; i++) {
            // 如果i从0开始 dfs启动永远都只会是0坐标开始
            for (int i = index; i < n; i++) {
                Collections.swap(temp,index,i);
                dfs(res,temp,index+1,n);
                Collections.swap(temp,index,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        LC46 lc46 = new LC46();
        lc46.permute(a);
    }
}
