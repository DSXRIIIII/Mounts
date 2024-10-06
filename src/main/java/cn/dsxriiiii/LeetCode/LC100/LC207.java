package cn.dsxriiiii.LeetCode.LC100;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 14:34
 * @Description: LC207
 **/
public class LC207 {
    List<List<Integer>> keys;
    int[] visit;
    boolean judge = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        keys = new ArrayList<>();
        visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            keys.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites){
            keys.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visit[i] == 0){
                dfs(i);
            }
        }
        return judge;
    }

    private void dfs(int i) {
        visit[i] = 1;
        for(int value : keys.get(i)){
            if(visit[value] == 0){
                dfs(value);
                if(!judge){
                    break;
                }
            }else if (visit[value] == 1){
                judge = false;
                break;
            }
        }
        visit[i] = 2;
    }
}
