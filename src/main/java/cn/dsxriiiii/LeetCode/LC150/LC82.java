package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 16:09
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class LC82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int val = p.next.val;
                while(p.next != null && p.next.val == val){//循环覆盖操作
                    p.next = p.next.next;//覆盖操作
                }
            }else{
                p = p.next;//跳过 不采取行动
            }
        }
        return dummy.next;
    }
}
