package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: LC150-用最少数量的箭引爆气球
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 15:04
 * @Email: lihh53453@hundsun.com
 * 这一题也可以为合并区间的一种写法 采用交集
 */
public class LC452 {
    public int[][] findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(i -> i[1]));//并交集不同之处 确保不比对的值为最小
        List<int[]> res = new ArrayList<>();
        for(int[] arr: points){
            int left = arr[0],right = arr[1];
            if(res.isEmpty() || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left,right});
            }else {
                res.get(res.size() - 1)[0] = Math.min(res.get(res.size() - 1)[0],left);//并交集不同之处
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Arrays.sort(arr, Comparator.comparingInt(i -> i[1]));
        System.out.println(Arrays.deepToString(arr));
        LC452 lc452 = new LC452();
        System.out.println(Arrays.deepToString(lc452.findMinArrowShots(arr)));
    }
}
