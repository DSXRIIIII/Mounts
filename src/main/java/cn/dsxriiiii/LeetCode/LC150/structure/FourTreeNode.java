package cn.dsxriiiii.LeetCode.LC150.structure;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 9:14
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class FourTreeNode {
    public boolean val;
    public boolean isLeaf;
    public FourTreeNode topLeft;
    public FourTreeNode topRight;
    public FourTreeNode bottomLeft;
    public FourTreeNode bottomRight;


    public FourTreeNode() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public FourTreeNode(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public FourTreeNode(boolean val, boolean isLeaf, FourTreeNode topLeft, FourTreeNode topRight, FourTreeNode bottomLeft, FourTreeNode bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }


}
