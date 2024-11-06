package cn.dsxriiiii.LeetCode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/31 11:24
 * @Description:
 **/
public class LC433 {
    //dfs + set
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> cnt = new HashSet<>(Arrays.asList(bank));
        if(!cnt.contains(endGene)) return -1;
        if(startGene.equals(endGene)) return 0;
        int step = 0;
        char[] keys = {'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        return dfs(startGene,endGene,cnt,step,keys,visited);
    }

    private int dfs(String startGene, String endGene, Set<String> cnt, int step, char[] keys, Set<String> visited) {
        if (startGene.equals(endGene)) {
            return step;
        }
        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < startGene.length(); i++) {
            for (char key : keys) {
                if(key != startGene.charAt(i)){
                    StringBuilder sb = new StringBuilder(startGene);
                    sb.setCharAt(i, key);
                    String next = sb.toString();
                    if(!visited.contains(next) && cnt.contains(next)){
                        visited.add(next);
                        int temp = dfs(next, endGene, cnt, step + 1, keys, visited);
                        if (temp!= -1) {
                            minSteps = Math.min(temp, minSteps);
                        }
                        visited.remove(next);
                    }
                }
            }
        }
        return minSteps == Integer.MAX_VALUE? -1 : minSteps;
    }
}
