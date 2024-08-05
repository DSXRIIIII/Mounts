package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.node.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 14:04
 * @Email: lihh53453@hundsun.com
 * @Description: 随机链表的复制
 * 用一个map来保存当前节点和传入节点的关系 将其关联上
 * 如果map存在这个节点直接将其返回即可
 * 如果不存在则选择创建一个新的节点 并且向下拓展
 */
public class LC138 {
    Map<Node,Node> cache = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(!cache.containsKey(head)){
            Node new_node = new Node(head.val);
            cache.put(head,new_node);
            new_node.next = copyRandomList(head.next);
            new_node.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }
}
