package cn.dsxriiiii.LeetCode.LC150.structure;

/**
 * @ProjectName: Mounts
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/4 12:48
 * @Email: lihh53453@hundsun.com
 */
public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node(){}
    public Node(int val){
        this.val = val;
        next = null;
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}
