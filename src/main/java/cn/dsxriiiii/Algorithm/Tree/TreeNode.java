package cn.dsxriiiii.Algorithm.Tree;

class TreeNode<T> {
    public static Integer nullPoint = -1;
    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
