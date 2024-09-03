package cn.dsxriiiii.lanQiao.answer.practice.Java.B2303;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int count = 0;
//    public static void main(String[] args) {
//        //4
//        //-5 5-i 6+3i -4+0i
////        Scanner scan = new Scanner(System.in);
////        int n =scan.nextInt();
////        String[] s = new String[n];
////        for(int i = 0;i < n;i++){
////            s[i] = scan.next();
////            if(!s[i].contains("i") || Long.valueOf(s[s[i].indexOf("i") - 1]) % 2 == 0){
////                count++;
////            }
////        }
////        System.out.print(count);
////        scan.close();
////        String s = "5-i";
////        System.out.println(Long.valueOf(s.charAt(s.indexOf("i") - 1)) % 2 == 0);
////        if(!s[i].contains("i"){
////            if(Long.valueOf(s[i].charAt(s[i].indexOf("i") - 1)) % 2 == 0)
////            count++;
////        }
//
////        Scanner scan = new Scanner(System.in);
////        int size = scan.nextInt();
////        Long[] b = new Long[size];
////        Long[] c = new Long[size];
////        Long[] a = new Long[size];
////        for(int i = 0;i < size - 1;i++){
////            b[i] = scan.nextLong();
////        }
////        for(int i = 0;i < size - 1;i++){
////            c[i] = scan.nextLong();
////        }
////        Arrays.sort(b);
////        Arrays.sort(c);
////        a[0] = Math.max(0,Math.min(b[0],c[0]));
////        a[1] = Math.min(b[1],c[1]) - a[0];
////        a[2] = Math.min(b[2],c[2]) - a[1];
////        a[3] = Math.max(b[2],c[2]) - Math.max(b[1],c[1]);
////        for(int i = 0;i < 4;i++){
////            System.out.print(a[i] + " ");
////        }
////        scan.close();
////    }
//        Scanner scan = new Scanner(System.in);
//        int size = 4;
//        Long[] b = new Long[size - 1];
//        for(int i = 0;i < size - 1;i++){
//            b[i] = scan.nextLong();
//        }
//        System.out.println(Arrays.toString(b));
//        Arrays.sort(b);
//        System.out.println(Arrays.toString(b));
//
//    }
////    public static void swap(Long[] value){
////        for(int i = 0;i < value.length;i++){
////            for(int j = 0;j <  )
////        }
////    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        Long[] b = new Long[size - 1];
        Long[] c = new Long[size - 1];
        Long[] a = new Long[size];
        for(int i = 0;i < size - 1;i++){
            b[i] = scan.nextLong();
        }
        for(int i = 0;i < size - 1;i++){
            c[i] = scan.nextLong();
        }
        Arrays.sort(b);//???
        Arrays.sort(c);
        a[0] = Math.min(b[0],c[0]);
        if(b[0] != c[0]){
            a[1] = Math.max(b[0],c[0]);
        }else{
            a[1] = Math.max(b[1],c[1]) - a[0];
        }
        if(b[0] == c[0] && b[1] == c[1]){
            a[2] = Math.min(b[2] - b[1],c[2]-c[1]);
        }else{
            a[2] = Math.min(b[1] - b[0],c[1] - c[0]);
        }
        a[3] = Math.max(b[2] - b[1],c[2] - c[1]);
        for(int i = 0;i < 4;i++){
            System.out.print(a[i] + " ");
        }
        scan.close();
    }
}
