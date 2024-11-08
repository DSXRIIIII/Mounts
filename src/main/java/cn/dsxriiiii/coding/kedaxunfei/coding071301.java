package cn.dsxriiiii.coding.kedaxunfei;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/06 16:10
 * @Description:
 * 牛牛拥有一个长度为 n 的01 串，现在他想知道，对于每个字符，在它前面的最近的不同字符的下标是多少？
 * /
 * 本题为多组测试数据，第一行输入一个正整数 T(1<=t<=100)，
 * 代表测试数据组数。对于每组测试数据，第一行输入一个正整数 n(1<=n<=1000)，代表初始 01串的长度。第二行输入一个长度为 n的01 串，代表初始字符串
 * /
 * 对于每组测试数据，一行输出 n 个整数 a1,a2,...,an，
 * 其中 ai 代表初始字符串中第 i 个位置的字符前面，最近的不同字符的下标是 ai，特殊的，如果前面不存在不同字符，则输出 -1 表示不存在。
 * /
 * 输入
 * 1
 * 4
 * 1101
 * /
 * 输出
 * -1 -1 2 3
 **/
public class coding071301 {
    private static int dif;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            int len = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            int index0 = -1;
            int index1 = -1;
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) == '0'){
                    System.out.print(index1 + " ");
                    index0 = i + 1;
                }else{
                    System.out.print(index0 + " ");
                    index1 = i + 1;
                }
            }
        }
    }
}
