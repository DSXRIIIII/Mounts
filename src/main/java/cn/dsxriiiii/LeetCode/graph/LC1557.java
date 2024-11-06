package cn.dsxriiiii.LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/03 22:25
 * @Description:
 **/
public class LC1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(List<Integer> next : edges){
            set.add(next.get(1));
        }
        for (int i = 0; i < n; i++) {
            if(!set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}
