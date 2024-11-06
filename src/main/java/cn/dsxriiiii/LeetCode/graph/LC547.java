package cn.dsxriiiii.LeetCode.graph;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/29 15:38
 * @Description: LC547
 **/
public class LC547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visit = new boolean[isConnected.length];
        int res = 0;
        for(int i = 0;i < isConnected.length;i++){
            if(!visit[i]){
                dfs(isConnected,i,visit);
                res++;
            }
        }
        return res;
    }
    public void dfs(int[][] isConnected,int index,boolean[] visit){

        for(int i = 0;i < isConnected.length;i++){
            if(!visit[i] && isConnected[index][i] == 1){
                visit[i] = true;
                dfs(isConnected,i,visit);
            }
        }
    }
}
