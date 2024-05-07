package cn.dsxriiiii.PowerPointOffer.Integer;

public class AppearOnceNumber_4 {
    public int singleNumber(int[] nums){
        int[] bitSums = new int[32];
        for(int num : nums){
            for (int i = 0; i < 32; i++) {
                bitSums[i] += (num >> (31 - i)) & 1;
            }
        //  最后数组的值为[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3]
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + bitSums[i] % 3;
            //左移 << 1 表示 在末尾也就是右端添加0，原数乘以2 ，如果bitSums[i] % 3有余数就添加 1
            //假如100 的二进制数为 1100100 1x2 1x2+1 (1x2+1)x2 (1x2+1)x2X2 ((1x2+1)x2x2x2+1) ((1x2+1)x2x2x2+1)x2 ((1x2+1)x2x2x2+1)x2
            //就是说有1就乘以2加1，没有1就乘以2
        }
        return result;
    }

    public static void main(String[] args) {
        AppearOnceNumber_4 appearOnceNumber4 = new AppearOnceNumber_4();
        System.out.println(appearOnceNumber4.singleNumber(new int[]{7,8,7,8,7,8,100}));
    }
}
