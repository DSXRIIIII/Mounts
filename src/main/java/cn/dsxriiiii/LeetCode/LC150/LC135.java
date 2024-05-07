package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：分发糖果
 * 算法思路：两次遍历
 * 具体思路：1.从左向右遍历 当i > i-1 数组更新++,否则arr[i] = 1;
 *         2.从右向左遍历 同上 记录right值是为了当不断递增时 res 可以 加上 比较中的最大值
 */
public class LC135 {
    public static void main(String[] args) {
        int[] nums = {1,0,2};
        System.out.println(candy(nums));

    }
    public static int candy(int[] ratings) {
        int res = 0;
        int len = ratings.length;
        int[] arr = new int[len];
        for(int i = 0; i < ratings.length;i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                arr[i] = arr[i - 1] + 1;
            }else{
                arr[i] = 1;
            }
        }
        int right = 0;
        for(int j = ratings.length - 1;j >= 0;j--){
            if(j < len - 1 && ratings[j] > ratings[j + 1]) {
                right++;
            }else{
                right = 1;
            }
            //res += arr[j]; 保存的right值是用来当左边值大于右边值时 right会right++
            //例如下面这个数组{1,3,5,3,2,1} 第三个人比左右两边都要高 但是 从右向左right == 4 arr[i] = 3 所以要取大值4
            res += Math.max(arr[j],right);

        }
        //System.out.println(Arrays.toString(arr));
        return res;
    }
}
