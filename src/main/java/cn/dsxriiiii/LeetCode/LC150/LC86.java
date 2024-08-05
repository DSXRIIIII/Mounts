package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.node.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 16:34
 * @Email: lihh53453@hundsun.com
 * @Description: 分隔链表
 * 将小于和大于该节点的节点保存在链表中 再将两个链表相连即可
 */
public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode small_head = small;
        ListNode biger = new ListNode(0);
        ListNode biger_head = biger;
        while(head != null){
            if(head.val < x){
                small_head.next = head;
                small_head = small_head.next;
            }else{
                biger_head.next = head;
                biger_head = biger_head.next;
            }
            head = head.next;
        }
        biger_head.next = null;
        small_head.next = biger.next;
        return small.next;
    }
}
