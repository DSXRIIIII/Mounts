package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/02 14:44
 * @Description: LRUCache
 **/
public class LRUCache {
    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode <K,V>  {
        K key;
        V value;
        DLinkedNode<K,V> pre;
        DLinkedNode<K,V> next;
        public DLinkedNode() {}
        public DLinkedNode(K key,V value){
            this.key = key;
            this.value = value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode == null){
            return -1;
        }
        moveToFirst(dLinkedNode);
        return (int)dLinkedNode.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode new_node = new DLinkedNode(key,value);
            cache.put(key,new_node);
            addToHead(new_node);
            ++size;
            if(size > capacity){
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToFirst(node);
        }
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private void addToHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void moveToFirst(DLinkedNode dLinkedNode) {
        removeNode(dLinkedNode);
        addToHead(dLinkedNode);
    }
    private void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}
