package cn.dsxriiiii.LeetCode.graph;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/02 16:49
 * @Description:
 **/
public class LC1306 {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visit = new boolean[n];
        return dfs(arr,start,n,visit);
    }

    private boolean dfs(int[] arr, int start, int n, boolean[] visit) {
        if(start < 0 || start >= n || visit[start]) return false;
        if(arr[start] == 0) return true;
        visit[start] = true;
        return dfs(arr, start + arr[start], n, visit) || dfs(arr, start - arr[start], n, visit);
    }
}
