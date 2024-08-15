package cn.dsxriiiii.lanQiao.answer.practice.Java.B2202;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        for(int i = 2022; i <=2022222022;i++) {
            if(String.valueOf(i).equals(reverse(String.valueOf(i))) && judgeM(String.valueOf(i))) {
                count++;
            }
        }
        System.out.print(count);
//		String a = "1234321";
//		String b = "123434321";
//		System.out.print(a.equals(reverse(a)) && judgeM(a));
//		System.out.print(b.equals(reverse(b)) && judgeM(b));
//
    }
    public static String reverse(String s) {
        char[] a = s.toCharArray();
        for(int i = 0,j = a.length - 1; i < a.length / 2;i++,j--) {
            swap(i,j,a);
        }
        return new String(a);
    }
    public static void swap(int i,int j,char[] a) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static boolean judgeM(String s) {
        char[] b = s.toCharArray();
        boolean temp = true;
        //原本这里没有做奇数偶数的判断 并且 i 是从 0 开始 那么到 b.length + 1的位置就会 (b[i] >= b[i + 1]) 出现问题
        if(b.length % 2 == 0) {
            for(int i = 0; i < b.length / 2;i++) {
                if(b[i] >= b[i + 1]) {
                    temp = false;
                    break;
                }
            }
        }else {
            for(int i = 0; i < b.length / 2 + 1;i++) {
                if(b[i] >= b[i + 1]) {
                    temp = false;
                    break;
                }
            }
        }
        return temp;
    }
}
