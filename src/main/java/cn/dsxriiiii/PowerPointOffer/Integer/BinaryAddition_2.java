package cn.dsxriiiii.PowerPointOffer.Integer;

public class BinaryAddition_2 {
    public String addition(String a, String b){
        StringBuilder stringBuilder = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            stringBuilder.append(sum);
        }
        if(carry == 1){
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        BinaryAddition_2 bin = new BinaryAddition_2();
        String result = bin.addition("100","100");
        System.out.println(result);
    }
}
