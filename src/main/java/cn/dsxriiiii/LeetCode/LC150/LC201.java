package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 15:07
 * @Email: lihh53453@hundsun.com
 * @Description: 数字范围按位与
 * 1.从区间left到right的闭区间 每一个元素进行与运算
 * 对于每一位 例如
 * 9   1 0 0 1
 * 10  1 0 1 0
 * 11  1 0 1 1
 * 12  1 1 0 0
 * 这四个数进行&运算 一旦遇到0就一定是0
 * 所以要找到这个区间的公共前缀 公共前缀对应的树即为要找的数
 * 当 left >= right时 此时右区间的数已经比left小了 此时就代表找到了最小的公共前缀
 * 利用 n&(n-1) 不断取出最后位的1
 */
public class LC201 {
    public int rangeBitwiseAnd(int left, int right) {
        while(left < right){
            right &= right - 1;
        }
        return right;
    }
}
