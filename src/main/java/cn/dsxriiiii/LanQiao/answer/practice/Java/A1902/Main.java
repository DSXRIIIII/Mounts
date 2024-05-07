package cn.dsxriiiii.LanQiao.answer.practice.Java.A1902;

//给定数列 1, 1, 1, 3, 5, 9, 17, …，从第 4 项开始，每项都是前 3 项的和。求 第 20190324 项的最后 4 位数字

public class Main {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        int k = 1;
        int temp = 0;
        for (int l = 4; l <= 20190324; l++) {
            temp = (i + j + k)%10000;
            i = j;
            j = k;
            k = temp;
        }
        System.out.println(temp);
    }
}
