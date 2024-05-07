package cn.dsxriiiii.Algorithm.RollBack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);
    }
    //和為n 个数为k
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1,0);
        return res;
    }
    public static void backTracking(int targetSum,int k,int startIndex,int sum){
        if(sum > targetSum){
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i<= 9 - (k - path.size()) + 1;i++){
            path.add(i);
            sum+=i;
            backTracking(targetSum,k,i,sum);
            sum-=i;
            path.remove(path.size()-1);
        }
    }
}
