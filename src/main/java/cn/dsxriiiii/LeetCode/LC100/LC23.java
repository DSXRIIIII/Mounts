package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 14:35
 * @Description: LC23
 **/
public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }else if(left > right){
            return null;
        }else{
            int mid = (left + right) >> 1;
            return mergeTwoList(merge(lists,left,mid),merge(lists,mid + 1,right));
        }
    }

    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dummy.next;
    }
}
