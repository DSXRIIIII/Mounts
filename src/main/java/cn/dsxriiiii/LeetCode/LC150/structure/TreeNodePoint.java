package cn.dsxriiiii.LeetCode.LC150.structure;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/5 19:02
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class TreeNodePoint {
    public int val;
    public TreeNodePoint left;
    public TreeNodePoint right;
    public TreeNodePoint next;

    public TreeNodePoint() {}

    public TreeNodePoint(int _val) {
        val = _val;
    }

    public TreeNodePoint(int _val, TreeNodePoint _left, TreeNodePoint _right, TreeNodePoint _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
