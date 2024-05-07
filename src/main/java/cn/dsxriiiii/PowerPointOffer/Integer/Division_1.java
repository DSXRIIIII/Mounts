package cn.dsxriiiii.PowerPointOffer.Integer;

public class Division_1 {
    public int divide(int dividend,int divisor){
        if(dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0){
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0){
            negative--;
            divisor = -divisor;
        }
        int result = divideCore(dividend,divisor);
        return negative == 1 ? -result : result;
    }
    private int divideCore(int dividend, int divisor){
        int result = 0;
        while(dividend <= divisor){
            int value = divisor;
            int quotient = 1;
            while(value >= 0xc000000 && dividend <= value + value){
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
    public static void main(String[] args) {
        Division_1 di = new Division_1();
        int result = di.divide(0xc000001,0xc000001);
        System.out.println(result);
    }
}
