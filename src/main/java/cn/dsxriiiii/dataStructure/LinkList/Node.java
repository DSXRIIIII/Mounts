package cn.dsxriiiii.dataStructure.LinkList;
public class Node<E> {
    public E data;
    public Node<E> next;
    public Node<E> pre;
    public Node(E data){
        this.data = data;
        this.next = null;
        this.pre = null;
    }
}
