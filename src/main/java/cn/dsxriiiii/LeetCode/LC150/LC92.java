package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 14:59
 * @Email: lihh53453@hundsun.com
 * @Description:
 * 1 2 3 4 5
 * 2->4
 */
public class LC92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1,head);
        ListNode start = dummy;
        for(int i = 0;i<left - 1;i++){
            start = start.next;
        }
        ListNode pre = null;
        ListNode cur = start.next;
        for(int i = 0;i < right - left;i++){// 2-4  -> 0-2 -> 2 循环两次
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next.next = cur;
        start.next = pre;
        return dummy.next;
    }
}
