package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.node.ListNode;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 16:21
 * @Email: lihh53453@hundsun.com
 * @Description: 旋转链表
 * 解题思路： 首先确定链表长度
 *          拼接链表为环状
 *          平移头节点位置
 *          返回新头节点
 */
public class LC61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null) return head;
        ListNode temp = head;
        int index = 1;
        while(temp.next != null){
            temp = temp.next;
            index++;
        }
        int add = index - k % index;//计算出需要平移多少位置
        if(index == add){
            return head;
        }
        temp.next = head;
        while(add-->0){
            temp = temp.next;
        }
        ListNode new_head = temp.next;
        temp.next = null;
        return new_head;
    }
}
