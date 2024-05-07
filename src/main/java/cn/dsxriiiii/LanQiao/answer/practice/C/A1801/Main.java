package cn.dsxriiiii.LanQiao.answer.practice.C.A1801;
//在分数问题中要求两个数互质，那么就要考虑最大公约数实现互质，否则会出现没有约分的情况
public class Main {
    public static void main(String[] args) {
        int a = (int) (Math.pow(2, 20) - 1);
        int b = (int) (Math.pow(2, 19));
        //Math.pow(2, 19)是Double类型需要转化为int
        int c = gcd(a, b);
        System.out.println(c);
        if (c != 1)
            System.out.println(a / c + "/" + b / c);
        else
            System.out.println(a + "/" + b);


    }
    public static int gcd(int a,int b){
        if (b != 0){
            return gcd(b,a%b);
        }else{
            return a;
        }
    }
}
