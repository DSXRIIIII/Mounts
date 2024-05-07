package cn.dsxriiiii.LanQiao.answer.practice.C.A1707;

import java.util.Scanner;
/*
* ((xx|xxx)x|(x|xx))xx  输出6
* 没遇到一次（则进入一次dfs循环
* 在最内层的dfs循环中，此时nowLocation = 2，temp暂时保存内嵌括号X的最大值为0，dfsMaxNum最终目标返回结果也为0
* 每一次遇到X，temp的值就++，并且nowLocation的坐标位置也会发生改变，此时temp = 2，dfsMaxNum = 0
* 每一次遇到|,此时X的数值达到最大，并且保存在temp中，在dfsMaxNum和temp之中取最大值，此时temp = 0，dfsMaxNum = 2，nowLocation的坐标位置再次更新
* 每一次遇到)，此时X的数值也达到最大，并且保存在temp中，在dfsMaxNum和temp之中取最大值,此时本轮dfs结束，返回本次dfs的结果，依然在在dfsMaxNum和temp中取得最大值，坐标位置再一次更新
* 可以理解每一次的dfs的遍历过程之中都有一个单独的temp的值
* 其实在每一次返回return的时候（即是碰到'）'时），temp都有可能保存了值，就需要与此时的保存的最终值进行比较
*
* */

public class Main {
    static int nowLocation = 0;
    static String s;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         s = scanner.nextLine();
        scanner.close();
        System.out.println(dfs());
    }
    public static int dfs(){
        int dfsMaxNum = 0;
        int temp = 0;
        int len = s.length();
        while(nowLocation<len){
            if(s.charAt(nowLocation) == '('){
                nowLocation++;
                temp += dfs();
            } else if (s.charAt(nowLocation) == 'x'){
                temp++;
                nowLocation++;
            } else if(s.charAt(nowLocation) == '|'){
                dfsMaxNum = Math.max(temp,dfsMaxNum);
                temp = 0;
                nowLocation++;
            }else if(s.charAt(nowLocation) == ')'){
                nowLocation++;
                return Math.max(temp,dfsMaxNum);
            }
        }
        return Math.max(temp,dfsMaxNum);
    }
}
