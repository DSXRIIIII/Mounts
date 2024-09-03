package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 17:55
 * @Email: lihh53453@hundsun.com
 * @Description: 将有序数组转换为二叉搜索树
 * 分治算法->归并排序
 */
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
//        return dfs(nums,0,nums.length);
        return dfs(nums,0,nums.length - 1);//注意边界位置
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid - 1);
        root.right = dfs(nums,mid + 1,right);
        return root;
    }
}
