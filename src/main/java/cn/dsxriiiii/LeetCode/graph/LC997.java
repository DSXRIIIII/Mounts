package cn.dsxriiiii.LeetCode.graph;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/03 22:18
 * @Description:
 **/
public class LC997 {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1];
        int[] out = new int[n + 1];
        for(int[] arr : trust){
            in[arr[1]]++;
            out[arr[0]]++;
        }
        for (int i = 1; i <= n ; i++) {
            if(in[i] == n - 1 && out[i] == 0){
                return i;
            }
        }
        return -1;
    }
}
