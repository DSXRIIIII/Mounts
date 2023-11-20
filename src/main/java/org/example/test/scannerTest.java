package org.example.test;

import javafx.scene.SnapshotParameters;

import java.util.Scanner;

public class scannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        *使用nextline()吞掉换行符
        *
        String a = scanner.next();
        scanner.nextLine();
        int b = scanner.nextInt();
        System.out.println(a);
        System.out.println(b);*/
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
