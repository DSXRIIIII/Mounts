package cn.dsxriiiii.LeetCode;

import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<num;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a);
            System.out.println(b);
        }
        scanner.close();
    }
}
