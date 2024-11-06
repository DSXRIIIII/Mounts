package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/30 21:37
 * @Description:
 **/
public class LC797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res,temp,graph,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[][] graph,int index) {
        if(index == graph.length - 1){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < graph[index].length;i++){
            temp.add(graph[index][i]);
            dfs(res, temp, graph, graph[index][i]);
            temp.remove(temp.size() - 1);
        }
    }
}
