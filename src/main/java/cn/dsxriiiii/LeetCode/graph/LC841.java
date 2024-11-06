package cn.dsxriiiii.LeetCode.graph;

import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/29 15:43
 * @Description: LC841
 **/
public class LC841 {
    private static int res;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        res = 0;
        dfs(rooms,visit,0);
        return res == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visit,int start) {
        res++;
        visit[start] = true;
        for(int index : rooms.get(start)){
            if(!visit[index]){
                dfs(rooms, visit, index);
            }
        }
    }
}
