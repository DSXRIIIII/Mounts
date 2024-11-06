package cn.dsxriiiii.LeetCode.graph;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/05 19:56
 * @Description:
 **/
public class LC116 {
    private boolean[] visit;
    public int findCircleNum(int[][] isConnected) {
        int res = isConnected.length - 1;
        visit = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length && !visit[i]; i++) {
            dfs(i,isConnected);
            res--;
        }
        return res;
    }
    public void dfs(int value,int[][] isConnected){
        for (int i = 0; i < isConnected[0].length; i++) {
            if(isConnected[value][i] == 1 && !visit[i]){
                dfs(value,isConnected);
                visit[value] = true;
            }
        }
    }
}
