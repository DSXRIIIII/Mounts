package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/29 15:35
 * @Description: 802. 找到最终的安全状态
 * 构建反向图 找到出度为0的点 往前面的节点遍历
 **/
public class LC802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodeCount = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<List<Integer>>();
        int[] inDegree = new int[nodeCount];
        for(int i = 0;i < graph.length;i++){
            reversedGraph.add(new ArrayList<>());
        }
        for(int startNode = 0;startNode < graph.length;startNode++){
            for(int endNode:graph[startNode]){
                reversedGraph.get(endNode).add(startNode);
            }
            inDegree[startNode] = graph[startNode].length;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodeCount; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int adjacentNode : reversedGraph.get(node)) {
                if (--inDegree[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
