package cn.dsxriiiii.lanQiao.answer.practice.Java.A1901;

import java.math.BigInteger;

//小明对数位中含有 2、0、1、9 的数字很感兴趣，在 1 到 40 中这样的数包 括 1、2、9、10 至 32、39 和 40，共 28 个，
// 他们的和是 574，平方和是 14362。 注意，平方和是指将每个数分别平方后求和。
//请问，在 1 到 2019 中，所有这样的数的平方和是多少?
public class Main {
    public static void main(String[] args) {
        BigInteger sum =  BigInteger.ZERO;
        for(int i = 1; i <= 2019; i++){
            String value = String.valueOf(i);
            if(value.contains("2") || value.contains("0") || value.contains("1") || value.contains("9")){
                BigInteger temp = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i));
                sum = sum.add(temp);
            }
        }
        System.out.println(sum);
        //用long可以解决，BigInteger也可以解决
    }
}
