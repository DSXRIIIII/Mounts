package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.FourTreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 9:14
 * @Email: lihh53453@hundsun.com
 * @Description: 构建四叉树
 * 思路：分治(归并) + dfs
 * 记录(r0,c0) 到 (r1,c1)的判断是否为四叉树 两层循环遍历 boolean值记录
 * 如果为四叉树的叶子节点直接返回Node(true,true)
 * 否则则会继续dfs遍历 将四个叶子节点进行判断封装
 * dfs的起点(r0,c0)和(r1,c1) 即为左上角和右上角的坐标位置
 */
public class LC427 {
    public FourTreeNode construct(int[][] grid) {
        return dfs(grid,0,0,grid.length,grid.length);
    }

    private FourTreeNode dfs(int[][] grid, int r0, int c0, int r1, int c1) {
        boolean same = true;
        for (int i = r0; i < r1; i++) {
            for (int j = c0; j < c1; j++) {
                if (grid[i][j] != grid[r0][c0]) {
                    same = false;
                    break;
                }
            }
            if(!same) break;
        }
        if(same) return new FourTreeNode(grid[r0][c0] == 1, true);
        return new FourTreeNode(
                true,
                false,
                dfs(grid,r0,c0,(r0 + r1)/2,(c0 + c1)/2),
                dfs(grid,r0,(c0 + c1)/2,(r0 + r1)/2,c1),
                dfs(grid,(r0 + r1)/2,c0,r1,(c0 + c1)/2),
                dfs(grid,(r0 + r1)/2,(c0 + c1)/2,r1,c1)
        );
    }
}
