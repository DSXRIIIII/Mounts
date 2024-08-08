package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.TreeNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/6 9:08
 * @Email: lihh53453@hundsun.com
 * @Description: 二叉树展开为链表
 * 逻辑：找到左子树的最右节点 将右子树的头节点衔接到左子树的最右节点
 * cur 当前节点root
 * next root的左子树头节点
 * pre 从左子树头节点开始依次遍历到左子树的最右节点
 * pre.right = cur.right; 连接操作
 * cur进入链表 进入下一节点 cur = cur.right
 */
public class LC114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode next = cur.left;
                TreeNode pre = next;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
