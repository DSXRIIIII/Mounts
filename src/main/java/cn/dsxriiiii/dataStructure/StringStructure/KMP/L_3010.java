package cn.dsxriiiii.dataStructure.StringStructure.KMP;

import java.util.Arrays;
import java.util.Scanner;

public class L_3010 {
    static int[] next;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        scan.nextLine();
        String s = scan.nextLine();
        next = new int[len];
        GetString(s);
        int maxNum = 0;
        System.out.println(Arrays.toString(next));
        for (int j : next) {
            maxNum = Math.max(maxNum, j);
        }
        System.out.println(maxNum);
        scan.close();
    }
    public static void GetString(String s){
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length();i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
