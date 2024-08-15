package cn.dsxriiiii.lanQiao.answer.practice.Java.B2302;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            String a2 = Integer.toBinaryString(i);
            String a8 = Integer.toOctalString(i);
            String a16 = Integer.toHexString(i);
            if(i % getNum(a2) == 0 && i % getNum(a8) == 0 && i % getNum(a16) == 0 && i % getNum(String.valueOf(i)) == 0){
                count++;
                if(count == 2023){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static int getNum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)>='a'&&s.charAt(i)<='f') //如果是a-f
                sum+=s.charAt(i)-'a'+10;
            else //如果是数字
                sum+=s.charAt(i)-'0';
        }
        return sum;
    }

}
