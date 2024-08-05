package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: 合并区间-LC56
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 14:02
 * @Email: lihh53453@hundsun.com
 * 将新的加入结果集
 * 并且与容器内的数组进行比对
 */
public class LC56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] arr:intervals){
            int left = arr[0],right = arr[1];
            if(list.isEmpty() || list.get(list.size() - 1)[1] < left){
                list.add(new int[]{left,right});
            }else{
                list.get(list.size() - 1)[1] = Math.max(right,list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int [][] arr = {{1,2},{2,3}};
        List<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{1,2});
        arrayList.add(new int[]{2,3});
        /* 输出结果为
         * [[1, 2], [2, 3]]
         * [[I@3b07d329
         * [[1, 2], [2, 3]]
         */
        System.out.println(Arrays.deepToString(arr));
        System.out.println(arrayList.toArray(new int[arrayList.size()][]));
        System.out.println(Arrays.deepToString(arrayList.toArray(new int[arrayList.size()][])));
    }
}
