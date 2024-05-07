package cn.dsxriiiii.LanQiao.answer.practice.C.A1902;

//给定数列1, 1, 1, 3, 5, 9, 17, …，从第4 项开始，每项都是前3 项的和。求第20190324项的最后4位数字。
public class Main {
    public static void main(String[] args){
        int a = 1;
        int b = 1;
        int c = 1;
        int temp = 0;
        for(int i = 4; i <= 20190324; i++){
            temp = (a + b + c)%10000;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(temp);
    }
}
