package cn.dsxriiiii.lanQiao.answer.practice.C.A1901;

public class Main {
    public static void main(String[] args){
        long sum = 0;
        for (int i = 0; i <= 2019 ; i++) {
            String get_i = String.valueOf(i);
            if(get_i.contains("2") || get_i.contains("0") || get_i.contains("1") || get_i.contains("9")){
                sum+=i*i;
            }
        }
        System.out.println(sum);
    }
}
