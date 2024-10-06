package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 16:00
 * @Description: LC108
 **/
public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if(l > r){
            return null;
        }
        int mid = l + (r - l) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,l,mid - 1);
        root.right = helper(nums,mid + 1,r);
        return root;
    }
}
