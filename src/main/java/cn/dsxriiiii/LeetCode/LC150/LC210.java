package cn.dsxriiiii.LeetCode.LC150;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/8 14:44
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC210 {
    List<List<Integer>> keys; //每一个课程对应一个链表
    boolean flag = true; // 是否满足有向无环图
    int[] result; //模拟栈
    int[] visited; //当前坐标位置访问标记
    int index; //栈的位置坐标
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        keys = new ArrayList<>();
        result = new int[numCourses];
        visited = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            keys.add(new ArrayList<>());
        }
        for(int[] arr:prerequisites){
            keys.get(arr[0]).add(arr[1]); //注意这里的先后顺序 [0,1] 先走arr[0] 才能走arr[1];
        }
        for (int i = 0; i < numCourses && flag; i++) {
            if(visited[i] == 0){
                dfs(i);
            }
        }
        if (!flag) {
            return new int[0];
        }
        return result;
    }
    public void dfs(int num){
        visited[num] = 1;
        for(int val:keys.get(num)){
            if(visited[val] == 0){
                dfs(val);
                if(!flag) return;
            }else if(visited[val] == 1){
                flag = false;
                return;
            }
        }
        visited[num] = 2;
        result[index--] = num;
    }
}
