package cn.dsxriiiii.LeetCode;

/**
 * @PackageName: cn.dsxriiiii.LeetCode
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/19 9:35
 * @Description: 买卖股票的最佳时机III
 * 确定好四个状态
 **/
public class LC123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //第一天买入
        int buy1 = -prices[0];
        //第一天买入且买出
        int sell1 = 0;
        //第一天全部卖出且买入新的
        int buy2 = -prices[0];
        //第一天全部卖出且全部卖出
        int sell2 = 0;
        for (int i = 1; i < n; i++) {
            //只进行过一次买操作
            buy1 = Math.max(buy1,-prices[i]);
            //买操作之后卖出
            sell1 = Math.max(sell1,buy1 + prices[i]);
            //第一次买卖交易后买入
            buy2 = Math.max(buy2,sell1 - prices[i]);
            //第一次买卖交易后卖出
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }
        return sell2;
    }
}
