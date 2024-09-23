package cn.dsxriiiii.coding.sxf;

import java.util.Scanner;

/**
 * @PackageName: cn.dsxriiiii.coding.sxf
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 22:37
 * @Description: scanner test
 **/
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String c = scanner.nextLine();
        System.out.println("scanner line = " + c);
        String d = scanner.nextLine();
        System.out.println("scanner line = " + d);

    }
}
