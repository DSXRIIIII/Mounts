package cn.dsxriiiii.LeetCode.graph;

import com.sun.applet2.AppletParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/29 16:14
 * @Description:
 **/
public class LC1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            map.putIfAbsent(manager[i],new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(headID, informTime, map);
    }

    private int dfs(int headID, int[] informTime, Map<Integer, List<Integer>> map) {
        int res = 0;
        for (int neighbor: map.getOrDefault(headID,new ArrayList<>())) {
            res = Math.max(res,dfs(neighbor,informTime,map));
        }
        return res + informTime[headID];
    }
}
