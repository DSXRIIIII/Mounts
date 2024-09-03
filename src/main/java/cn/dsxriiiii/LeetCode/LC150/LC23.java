package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 9:43
 * @Email: lihh53453@hundsun.com
 * @Description: 合并k个升序链表
 * 分治 + 合并两个链表
 * 注意分治区间为[left,mid] 和 [mid+1,right] 否则会死循环
 * 分治逻辑 拆分两个链表
 * 1.坐标相同返回nodes[left]
 * 2.坐标left>right越界 返回null
 * 3.拿到两个链表 进行排序
 */
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        if(left > right) return null;
        int mid = (left + right) / 2;
        System.out.println("区间为：["+left+","+right+"]");
        //[1,2] (1+2)/2 = 1 下次一次区间还是[1,2] 死循环 栈溢出
        return mergeList(merge(lists,left,mid),merge(lists,mid+1,right));
        //return mergeList(merge(lists,left,mid-1),merge(lists,mid,right));
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        if(left == null || right == null){
            return left == null ? right : left;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy,temp_left = left,temp_right = right;
        while(temp_left != null && temp_right != null){
            if(temp_left.val <= temp_right.val){
                cur.next = temp_left;
                temp_left = temp_left.next;
            }else{
                cur.next = temp_right;
                temp_right = temp_right.next;
            }
            cur = cur.next;
        }
        cur.next = temp_left == null ? temp_right:temp_left;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        LC23 lc23 = new LC23();
        lc23.mergeKLists(nodes);
    }
}
