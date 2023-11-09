package org.example.practice.A1702;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*

直接让蚱蜢跳到空盘有点麻烦，因为有很多蚱蜢在跳，跳晕了。如果看成空盘跳到蚱蜢的
位置就简单多了，只有一个空盘在跳。
题目给的是一个圆圈，不好处理，此时祭出一个建模大法：“化圆为线”！ 把空盘看成0，
那么有9个数字{0,1,2,3,4,5,6,7,8}，一个圆圈上的9个数字，拉直成了一条线上的9个数字。
等等，这不就是八数码问题吗？八数码是经典的BFS问题。
八数码有9个数字{0,1,2,3,4,5,6,7,8}，它有9！=362880种排列。也不多，
本题的初始状态是“012345678”，终止状态是“087654321”。
从初始状态跳一次，有4种情况：


八位数问题，使用bfs广度优先算法
set用来查重，linkedList调用队列接口用来实现Node的加入
while不为空时不断弹出node节点进行操作




**/
public class Main {
    public static void main(String[] args) {
        bfs();
    }
    public static void bfs() {

        String start="012345678";//初始状态
        String stop="087654321";//目标状态
        node a=new node(start);
        Queue<node> q=new LinkedList<>();
        q.offer(a);
        Set<String> set=new LinkedHashSet<>();
        set.add(start);
        while (!q.isEmpty()) {
            node anew=q.poll();
            String s=anew.s;
            int num=anew.num;//层数
            if (s.equals(stop)) {
                System.out.println(num);
                break;
            }
            int x=check(s);//寻找'0'的下标
            int x1=(x+1)%9;
            String s1=judge(s,x,x1);//跳跃后的新状态
            if (set.add(s1)) {
                //判断这一状态是否有相同状态
                //无相同状态则往下走一步
                node a1 =new node(s1);
                a1.num=num+1;
                q.add(a1);
            }
            int x2=(x+2)%9;
            String s2=judge(s,x,x2);//跳跃后的新状态
            if (set.add(s2)) {
                node a1 =new node(s2);
                a1.num=num+1;
                q.add(a1);
            }
            int x3=(x-1+9)%9;
            String s3=judge(s,x,x3);//跳跃后的新状态
            if (set.add(s3)) {
                node a1 =new node(s3);
                a1.num=num+1;
                q.add(a1);
            }
            int x4=(x-2+9)%9;
            String s4=judge(s,x,x4);//跳跃后的新状态
            if (set.add(s4)) {
                node a1 =new node(s4);
                a1.num=num+1;
                q.add(a1);
            }

        }
    }
    public static int check(String s) {
        //求出0的位置
        int x=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='0') {
                x=i;
                break;
            }
        }
        return x;
    }
    public static String judge(String s,int x,int x1) {
        //交换形成新的状态
        char[] c=s.toCharArray();
        char a=c[x];
        c[x]=c[x1];
        c[x1]=a;
        return new String(c);
    }

}
class node{
    String s;//记录状态
    int num;//跳跃的步数，或者说记录层数
    public node(String s){
        this.s=s;
    }


}