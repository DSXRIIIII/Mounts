package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/01 17:48
 * @Description: LC234
 **/
public class LC234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        boolean res = true;
        ListNode halfNode = findEnd(head);
        ListNode second = reverseListNode(halfNode.next);
        ListNode cur = second;
        ListNode cur_half = head;
        while(second != null && cur_half != null){
            if (cur_half.val != second.val) {
                res = false;
                break;
            }
            second = second.next;
            cur_half = cur_half.next;
        }
        halfNode.next = reverseListNode(second);
        return res;
    }
    public static ListNode reverseListNode(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    private static ListNode findEnd(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
