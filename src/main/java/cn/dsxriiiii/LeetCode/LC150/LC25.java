package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 15:25
 * @Email: lihh53453@hundsun.com
 * @Description: K 个一组翻转链表
 */
public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int n = 0;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        ListNode p = dummy;
        ListNode pre = null;
        ListNode cur = dummy.next;
        for(;n>=k;n-=k){
            for(int i = 0;i < k ;i++){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode new_start = p.next;
            p.next.next = cur;
            p.next = pre;
            p = new_start;
        }
        return dummy.next;
    }
}
