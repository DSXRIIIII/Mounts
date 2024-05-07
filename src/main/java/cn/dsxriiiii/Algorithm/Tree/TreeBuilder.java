package cn.dsxriiiii.Algorithm.Tree;

//构建一棵树，root节点为 nums[0]
public class TreeBuilder<T> {
    public static <T> TreeNode<T> buildTreeFromArray(T[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructTree(nums, 0);
    }

    private static <T> TreeNode<T> constructTree(T[] nums, int index) {
        if (index >= nums.length || nums[index] == TreeNode.nullPoint) {
            return null;
        }
        TreeNode<T> root = new TreeNode<>(nums[index]);
        root.left = constructTree(nums, 2 * index + 1);
        root.right = constructTree(nums, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 1, 4, -1, -1, 3, 6}; // 这里使用null表示空节点
        TreeNode<Integer> root = buildTreeFromArray(nums);
        System.out.println(root.right.left.val);
    }
}
