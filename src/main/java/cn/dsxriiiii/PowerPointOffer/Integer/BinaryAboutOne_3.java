package cn.dsxriiiii.PowerPointOffer.Integer;

import java.util.Arrays;

public class BinaryAboutOne_3 {
    public int[] countBits(int num){
        int[] result = new int[num + 1];
        for (int i = 0; i <=num; i++) {
            int j = i;
            while(j != 0){
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }
    public int[] countBitsByStrategy(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i & (i - 1)] + 1;  //整数i的二进制形式中1的个数比i&(i - 1)的二进制形式中1的个数多1
        }
        return result;
    }
    public static void main(String[] args) {
        BinaryAboutOne_3 binaryAboutOne_3 = new BinaryAboutOne_3();
        int[] result1 = binaryAboutOne_3.countBits(4);
        int[] result2 = binaryAboutOne_3.countBitsByStrategy(4);
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}
