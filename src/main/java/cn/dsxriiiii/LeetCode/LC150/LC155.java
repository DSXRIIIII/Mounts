package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 17:07
 * @Email: lihh53453@hundsun.com
 */
public class LC155 {
    Node root;
    public LC155() {
        this.root = new Node();
    }

    public void push(int val) {
        //当前节点保存root之前的状态 例如next和min 相当于备份
        Node node = new Node(val,root.next);
        node.min = root.min;
        root.min = Math.min(root.min,val);
        root.next = node;
    }

    public void pop() {
        Node cur = root.next;
        if (cur.val == root.min) {
            root.min = cur.min;
            //cur节点保证进来之前root的min值
        }
        root.next = cur.next;
        cur.next = null;

    }

    public int top() {
        return root.next.val;
    }

    public int getMin() {
        return root.min;
    }

    public static void main(String[] args) {
        LC155 minStack = new LC155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        minStack.top();      //--> 返回 0.
        minStack.getMin();   //--> 返回 -2.
    }
}

class Node{
    Node next;
    int min;
    int val;
    public Node(Node next){
        this.next = next;
    }
    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
    public Node(){
        this.min = Integer.MAX_VALUE;
    }
}
