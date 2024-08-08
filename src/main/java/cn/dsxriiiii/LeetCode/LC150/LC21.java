package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.Node;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 13:32
 * @Email: lihh53453@hundsun.com
 * @Description: 合并两个有序链表
 * list1 = list1.next; 保证节点能在l1上继续走
 * list2 = list2.next; 保证节点能在l2上继续走
 * 将两个值进行比较 决定下一个扩展的节点是哪一个
 * 最后必定有一个值剩余 将节点指向最后一个有值的节点即可
 */
public class LC21 {
    public Node mergeTwoLists(Node list1, Node list2) {
        Node temp = new Node();
        Node cur = temp;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }else {
            cur.next = list1;
        }
        return temp.next;
    }
}
