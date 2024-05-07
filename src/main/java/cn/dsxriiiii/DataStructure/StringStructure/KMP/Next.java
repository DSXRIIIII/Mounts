package cn.dsxriiiii.DataStructure.StringStructure.KMP;

import java.util.Arrays;

public class Next {
    public static void main(String[] args) {
        String s = "abcabcabc";
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length();i++){
            while(j > 0 && s.charAt(i) != s.charAt(j) ){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
    }
}
