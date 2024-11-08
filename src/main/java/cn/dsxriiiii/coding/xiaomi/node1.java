package cn.dsxriiiii.coding.xiaomi;

import cn.hutool.core.lang.hash.Hash;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.xiaomi
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/19 16:36
 * @Description:
 **/
public class node1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer,Set<Integer>> col_set;
        Map<Integer,Set<Integer>> row_set;
        Set<Integer> values;
        while(n-->0){
            int res = 0;
            col_set = new HashMap<>();
            row_set = new HashMap<>();
            values = new HashSet<>();
            values.add(1);values.add(2);values.add(3);values.add(4);values.add(5);values.add(6);values.add(7);values.add(8);values.add(9);
            int[][] arr = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[i][j] != 0){
                        Set<Integer> orDefault = row_set.getOrDefault(i, new HashSet<>());
                        orDefault.add(arr[i][j]);
                        row_set.put(i,orDefault);
                        Set<Integer> row_set2 = col_set.getOrDefault(j, new HashSet<>());
                        row_set2.add(arr[i][j]);
                        col_set.put(i,row_set2);
                        values.remove(arr[i][j]);
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[i][j] != 0) continue;
//                    for(int value : values){
//                        if(!row_set.get(i).contains(value - 1) || !row_set.get(i).contains(value + 1) || !col_set.get(j).contains(value - 1) || !col_set.get(j).contains(value + 1)){
//                            res++;
//                        }
//                        values.remove(value);
//                    }
                    for(int value : values){
                        if(value - 1 != arr[i - 1][j] || value - 1 != arr[i + 1][j] || value - 1 != arr[i][j - 1] || value - 1 != arr[i][j+1]){
                            res++;
//                            arr++;
                        }
                    }
                }
            }
            System.out.println(res);
//            System.out.println(Arrays.deepToString(arr));
        }
    }
}
