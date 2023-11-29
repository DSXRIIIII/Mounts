/*
* LCR 106 判断二分图
* https://leetcode.cn/problems/vEAB3K/description/
* 相邻节点为同色，返回false
*  相邻节点不相同则不考虑放进队列，因为不同颜色的情况表示neighbor节点已经上过色
*  相邻节点未被染色，放入队列并且染色
*  染色原理：
*  传入值0，那么染色1-0 只有两种情况 1 和 0
*
* */
package cn.dsxriiiii.PowerPointOffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {
    public boolean isBipartite(int[][] graph){
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0; i < size; i++) {
            if(colors[i] == -1){
                if (!setColor(graph,colors,i,0)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean setColor(int[][] graph, int[] colors, int i, int color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = color;//这里要先将进来的数染色，否则会出现2，当该节点染色之后，相邻的neighbor节点就不会同色
        while(!queue.isEmpty()){
            int v = queue.remove();
            for(int neighbor: graph[v]){
                if(colors[neighbor] >= 0){
                    if(colors[neighbor] == colors[v]){
                        return false;
                    }
                }else{
                    queue.add(neighbor);
                    colors[neighbor] = 1 - colors[v];
                }

            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] testGraph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        GraphBipartite solution = new GraphBipartite();
        boolean bol_re = solution.isBipartite(testGraph);
        System.out.println(bol_re);

    }
}
