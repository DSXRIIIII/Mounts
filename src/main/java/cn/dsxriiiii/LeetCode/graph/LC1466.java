package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/30 21:12
 * @Description:
 **/
public class LC1466 {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] x = new List[n];
        for (int i = 0; i < n; i++) {
            x[i] = new ArrayList<>();
        }
        for(int[] connect : connections){
            x[connect[0]].add(new int[]{connect[1],1});
            x[connect[1]].add(new int[]{connect[0],0});
        }
        return dfs(0,-1,x);
    }

    public int dfs(int x, int parent, List<int[]>[] e) {
        int res = 0;
        for (int[] edge : e[x]) {
            if(parent == edge[0]){
                continue;
            }
            res += dfs(edge[1],x,e);
        }
        return res;
    }
}
