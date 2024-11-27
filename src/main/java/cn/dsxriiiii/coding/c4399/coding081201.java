package cn.dsxriiiii.coding.c4399;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.c4399
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/26 16:47
 * @Description:
 **/
public class coding081201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder cus_s = new StringBuilder();
        int x = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '['){
                x++;
            }else if(s.charAt(i) == ']'){
                if (cus_s.length() == 0){
                    x--;
                    continue;
                }
                res += Integer.parseInt(cus_s.toString()) * x;
                x--;
                cus_s = new StringBuilder();
            }else if(s.charAt(i) == ','){
                if (cus_s.length() == 0){
                    continue;
                }
                res += Integer.parseInt(cus_s.toString()) * x;
                cus_s = new StringBuilder();
            }else{
                cus_s.append(s.charAt(i));
            }
        }
        System.out.println(res);
        scanner.close();
    }
}
