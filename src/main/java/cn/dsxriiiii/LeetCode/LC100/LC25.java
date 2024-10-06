package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 13:28
 * @Description: LC25
 **/
public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        int n = 0;
        while(temp.next != null){
            n++;
            temp = temp.next;
        }
        ListNode start = dummy;
        ListNode pre = null;
        ListNode cur = dummy.next;
        for(;n>=k;n-=k){
            for (int i = 0; i < k; i++) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode new_start = start.next;
            start.next.next = cur;
            start.next = pre;
            start = new_start;
        }
        return dummy.next;
    }
}
