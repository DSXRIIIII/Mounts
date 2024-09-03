package cn.dsxriiiii.lanQiao.answer.practice.C.A1802;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1901; i <= 2000; ++i) {
            if(i % 400 == 0 ||(i%4 == 0 && i%100 != 0)) {
                sum+=366;
            }else {
                sum+=365;
            }
        }
        System.out.print(sum/7);
    }


}