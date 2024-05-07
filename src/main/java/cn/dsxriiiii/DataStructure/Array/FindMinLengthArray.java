package cn.dsxriiiii.DataStructure.Array;
/*
*
* https://leetcode.cn/problems/2VG8Kg/description/
* 寻找长度最小的子数组
*
* */
public class FindMinLengthArray {

    public static void main(String[] args) {
        FindMinLengthArray findMinLengthArray = new FindMinLengthArray();
        int result = findMinLengthArray.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        System.out.println(result);
    }
    public int minSubArrayLen(int target, int[] nums){
        int result = Integer.MAX_VALUE;
        int i = 0;//借助变量i,而不用fori循环是方便每一次更新滑动窗口大小 ，使i++
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target){ //在while循环之中不断地滑动数组，否则i不会发生滑动，就不会更新滑动数组
                int getLength = j - i + 1;
                result = Math.min(getLength,result);
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
