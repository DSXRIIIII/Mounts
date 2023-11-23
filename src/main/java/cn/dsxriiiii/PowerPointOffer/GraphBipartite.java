//LCR 106 判断二分图
/*存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。
给定一个二维数组 graph ，表示图，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于 graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
不存在自环（graph[u] 不包含 u）。
不存在平行边（graph[u] 不包含重复值）。
如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 */


/*
 相邻节点为同色，返回false
 相邻节点不相同则不考虑放进队列，因为不同颜色的情况表示neighbor节点已经上过色
 相邻节点未被染色，放入队列并且染色
 染色原理：
 传入值0，那么染色1-0 只有两种情况 1 和 0
 */
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
