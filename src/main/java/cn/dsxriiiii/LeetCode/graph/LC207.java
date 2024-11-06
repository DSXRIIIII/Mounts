package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/05 19:18
 * @Description:
 **/
public class LC207 {
    private boolean flag;
    private int[] visit;
    private Map<Integer, List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        flag = true;
        visit = new int[numCourses];
        map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            map.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visit[i] == 0){
                dfs(i);
            }
        }
        return flag;
    }

    private void dfs(int i) {
        visit[i] = 1;
        for(int value : map.get(i)){
            if(visit[value] == 0){
                dfs(value);
                if(!flag) return;
            }else if(visit[value] == 1){
                flag = false;
                return;
            }
        }
        visit[i] = 2;
    }
}
