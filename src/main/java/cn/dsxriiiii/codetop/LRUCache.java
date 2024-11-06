package cn.dsxriiiii.codetop;

import java.util.Map;
import java.util.HashMap;

/**
 * @PackageName: cn.dsxriiiii.codetop
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/24 11:49
 * @Description:
 **/
public class LRUCache {
    private static Map<Integer,LinkNode> map;
    private int size;
    private int capacity;
    private LinkNode head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        LinkNode linkNode = map.get(key);
        if(linkNode == null){
            return -1;
        }
        moveToHead(linkNode);
        return linkNode.value;
    }

    private void moveToHead(LinkNode linkNode) {
        removeNode(linkNode);
        addToHead(linkNode);
    }

    private void addToHead(LinkNode linkNode) {
        LinkNode next = head.next;
        head.next = linkNode;
        linkNode.next = next;
        next.pre = linkNode;
        linkNode.pre = head;
    }

    private void removeNode(LinkNode node) {
        LinkNode pre = node.pre;
        pre.next = node.next;
        node.next.pre = pre;
    }

    public void put(int key, int value) {
        if(map.get(key) == null){
            LinkNode linkNode = new LinkNode(key, value);
            map.put(key,linkNode);
            addToHead(linkNode);
            ++size;
            if(size > capacity){
                LinkNode lastNode = removeLastNode();
                map.remove(lastNode.key);
                --size;
            }
        }else{
            map.get(key).value = value;
            moveToHead(map.get(key));
        }
    }

    private LinkNode removeLastNode() {
        LinkNode lastNode = tail.pre;
        removeNode(lastNode);
        return lastNode;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}

class LinkNode{
    LinkNode pre;
    LinkNode next;
    int value;
    int key;
    public LinkNode(){}
    public LinkNode(int key,int value){
        this.key = key;
        this.value = value;
    }
}
