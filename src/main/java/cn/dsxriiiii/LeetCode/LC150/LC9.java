package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 16:28
 * @Email: lihh53453@hundsun.com
 * @Description: 回文数
 * 1.字符串反转比较即可
 * 2.while(x > reverseNum)将数从最后一位不断的添加 如12321 最后比较即为 12 与 123 比较 此时是奇数情况
 *                                            如1221 最后比较即为 12 与 12 比较 此时是偶数情况
 * 3.最后比较两个值是否相等
 * 4.注意是否是10的倍数 同样地，如果数字的最后一位是 0，为了使该数字为回文，则其第一位数字也应该是 0 只有0满足这个条件
 */
public class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;
        while(x > reverseNum){
            reverseNum = reverseNum * 10 + x % 10;
            x/=10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
