package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/8 14:18
 * @Email: lihh53453@hundsun.com
 * @Description: 课程表
 * 这一题就是判断有没有环 如果在dfs的过程中走到了自己 说明不满足拓扑排序
 * 构造拓扑排序 每一个节点对应一个状态 0未开始 1真在找节点 2节点访问完毕
 * 停止条件即judge为false时 全部return
 */
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
        for (int[] arr:prerequisites){
            keys.get(arr[1]).add(arr[0]);
        }
        for (int i = 0; i < numCourses && judge; i++) {
            if(visit[i] == 0){
                dfs(i);
            }
        }
        return judge;
    }

    public void dfs(int num){
        visit[num] = 1;
        for (int v:keys.get(num)){
            if(visit[v] == 0){
                dfs(v);
                if(!judge){
                    return;
                }
            }else if(visit[v] == 1){
                judge = false;
                return;
            }
        }
        visit[num] = 2;
    }
}
