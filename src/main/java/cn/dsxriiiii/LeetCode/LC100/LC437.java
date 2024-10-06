package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 11:29
 * @Description:
 **/
public class LC437 {
    private static Map<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,0,targetSum);
    }

    private int dfs(TreeNode root, long cur, int targetSum) {
        if(root == null){
            return 0;
        }
        int res = 0;
        cur += root.val;
        res = map.getOrDefault(cur - targetSum, 0);
        map.put(cur,map.getOrDefault(cur,0) + 1);
        res += dfs(root.left,cur,targetSum);
        res += dfs(root.right,cur,targetSum);
        map.put(cur,map.getOrDefault(cur,0) - 1);
        return res;
    }
}
