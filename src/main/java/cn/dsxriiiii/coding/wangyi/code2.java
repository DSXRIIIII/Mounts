package cn.dsxriiiii.coding.wangyi;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.coding.wangyi
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 10:32
 * @Description: 2
 **/
public class code2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sc = scanner.nextLine();
        char[] s = sc.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length / 2;i++){
            if(s[i] != s[s.length - i - 1]){
                s[s.length - i - 1] = s[i];
            }
        }
        for(char c : s){
            sb.append(c);
        }
        BigDecimal old_num = new BigDecimal(sc);
        BigDecimal new_num = new BigDecimal(sb.toString());
        if(!old_num.remainder(new_num).equals(old_num)){
            System.out.println(old_num.remainder(new_num));
        }else{
            System.out.println(new_num.remainder(old_num));
        }
    }
}
