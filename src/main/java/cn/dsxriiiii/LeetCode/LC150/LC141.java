package cn.dsxriiiii.LeetCode.LC150;
import cn.dsxriiiii.LeetCode.LC150.node.Node;

/**
 * @ProjectName: Mounts
 * @Description: 环形链表
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 12:47
 * @Email: lihh53453@hundsun.com
 * 处理环形问题只需要考虑使用快慢指针 当相遇的时候一定有环
 * 但一定要注意循环的结束位置
 */
public class LC141 {
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

