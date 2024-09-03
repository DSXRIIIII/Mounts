package cn.dsxriiiii.lanQiao.tryfirst.A1702;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        bfs();
    }
    private static void bfs() {
        String start = "012345678";
        String stop = "087654321";
        Node a = new Node(start);
        Queue<Node> q = new LinkedList<>();
        q.offer(a);
        Set<String> set = new LinkedHashSet<>();
        set.add(start);
        while(!q.isEmpty()){
            Node newNode = q.poll();
            if (newNode.s.equals(stop)){
                System.out.println(newNode.num);
                break;
            }
            int x = check(newNode.s);
            int x1 = (x+1)%9;
            String s1 = swap(newNode.s,x,x1);
            if(set.add(s1)){
                Node node1 = new Node(s1);
                node1.num = newNode.num + 1;
                q.add(node1);
            }
            int x2 = (x+2)%9;
            String s2 = swap(newNode.s,x,x2);
            if(set.add(s2)){
                Node node2 = new Node(s2);
                node2.num = newNode.num + 1;
                q.add(node2);
            }
            int x3 = (x-1+9)%9;
            String s3 = swap(newNode.s,x,x3);
            if(set.add(s3)){
                Node node3 = new Node(s3);
                node3.num = newNode.num + 1;
                q.add(node3);
            }
            int x4 = (x-2+9)%9;
            String s4 = swap(newNode.s,x,x4);
            if(set.add(s4)){
                Node node4 = new Node(s4);
                node4.num = newNode.num + 1;
                q.add(node4);
            }

        }
    }

    private static String swap(String s,int a,int b) {
        char[] args = s.toCharArray();
        char temp = args[a];
        args[a] = args[b];
        args[b] = temp;
        return new String(args);
    }

    //查找‘0’所在位置
    private static int check(String x) {
        int a = 0;
        for (int i = 0; i <x.length(); i++) {
            if(x.charAt(i)=='0'){
                a = i;
                break;
            }
        }
        return a;
    }

}
class Node{
    String s;
    int num;
    public Node(String s){
        this.s = s;
    }
}