package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/05 19:39
 * @Description:
 **/
public class LC210 {
    private int[] visit;
    private boolean flag;
    private Map<Integer, List<Integer>> map;
    private int[] res;
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        res = new int[numCourses];
        flag = true;
        index = numCourses - 1;
        map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            map.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visit[i] == 0){
                dfs(i);
            }
        }
        if(!flag) return new int[0];
        return res;
    }

    private void dfs(int i) {
        visit[i] = 1;
        for(int val : map.get(i)){
            if(visit[val] == 0){
                dfs(val);
                if(!flag) return;
            }else if(visit[val] == 1){
                flag = false;
                return;
            }
        }
        visit[i] = 2;
        res[index--] = i;
    }
}
