package cn.dsxriiiii.lanQiao.answer.practice.Java.B2301;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger start = BigInteger.ONE;
        for(int i = 1 ;i <=39;i++){
            start = start.multiply(new BigInteger(String.valueOf(i)));
            sum = sum.add(start);
        }
        System.out.println(sum.mod(new BigInteger(String.valueOf(1000000000))));
    }
}
