package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/11 18:05
 * @Email: lihh53453@hundsun.com
 * @Description: 排序链表
 * 分治算法(归并排序) 时间复杂度(nlog(n))
 * 1.拆解链表 使用快慢指针拆解链表 左链表头节点head 右链表头节点fast
 * 2.将链表排序 使用虚拟头节点指向min节点然后遍历 更新左右节点和当前节点
 */
public class LC148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; //确保头节点不为null
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //fast走到尾节点 slow走到中间节点
        fast = slow.next; //fast指向right链表的头节点
        slow.next = null; //断开左右链表
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;//cur的位置也需要改变
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }
}
