package cn.dsxriiiii.newcoder;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.newcoder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/24 15:28
 * @Description: 小红正在参加牛客周赛，已知周赛一共有 6 道题，现在给定小红每道题的得分，请你计算小红最终的总分。
 **/
public class BMN1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextInt()){
            sum+=scanner.nextInt();
        }
        System.out.println(sum);
    }
}
