package cn.dsxriiiii.LeetCode.LC150;

public class LC122 {
    public static void main(String[] args) {
        int[] nums =  {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] cash = new int[len];
        int[] gu = new int[len];
        cash[0] = 0;
        gu[0] = -prices[0];
        for(int i = 1; i < len;i++){
            cash[i] = Math.max(cash[i - 1],gu[i - 1] + prices[i]);
            gu[i] = Math.max(gu[i - 1],cash[i - 1] -prices[i] );
        }
        return cash[len-1];
    }
}
