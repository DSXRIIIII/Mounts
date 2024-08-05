package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: 插入区间-LC57
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 14:41
 * @Email: lihh53453@hundsun.com
 * 这里选择最简单的插入然后排序的方法
 * 在排序的过程中也可以选择二分法将nlog(n) -> log(n)
 */
public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = Arrays.copyOf(intervals, intervals.length + 1);
        arr[arr.length - 1] = new int[2];
        arr[arr.length - 1][0] = newInterval[0];
        arr[arr.length - 1][1] = newInterval[1];
        //Arrays.sort(arr,(num1,num2)->num1[0] - num2[0]);
        Arrays.sort(arr, Comparator.comparingInt(num -> num[0]));
        List<int[]> res = new ArrayList<>();
        for(int[] array:arr){
            int left = array[0],right = array[1];
            if(res.isEmpty() || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left,right});
            }else {
                res.get(res.size() - 1)[1] = Math.max(right,res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = Arrays.copyOf(arr1, arr1.length + 1);
        System.out.println(Arrays.deepToString(arr2));
    }
}
