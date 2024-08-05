package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.node.Node;

/**
 * @ProjectName: Mounts
 * @Description: 两数相加
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 12:59
 * @Email: lihh53453@hundsun.com
 * 注意要创建一个虚拟的头节点 并且两个指针指向这个节点
 * cur指针用来扩展值 更新链表
 * temp用来返回cur更新之后的链表
 * 对于余数的处理 需要使用 “/” 取1  “%” 实际存储值
 */
public class LC2 {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node temp = new Node();
        Node cur = temp;
        int sign = 0;
        while(l1 != null || l2 != null){
            int number1 = l1 == null ? 0 : l1.val;
            int number2 = l2 == null ? 0 : l2.val;
            int sum = number1 + number2 + sign;
            sign = sum / 10;
            sum = sum % 10;
            cur.next = new Node(sum);
            cur = cur.next; //更新temp值
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(sign == 1){
            cur.next = new Node(sign);
        }
        return temp.next;
    }
}
