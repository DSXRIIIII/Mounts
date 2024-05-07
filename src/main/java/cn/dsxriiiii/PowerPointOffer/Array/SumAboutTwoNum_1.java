package cn.dsxriiiii.PowerPointOffer.Array;

import java.util.Arrays;

public class SumAboutTwoNum_1 {
    public int[] TwoSum(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        while(i < j && nums[i] + nums[j] != target){
            if(target > nums[i] + nums[j]){
                i++;
            }else{
                j--;
            }
        }
        return new int[]{i,j};
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,6,10};
        SumAboutTwoNum_1 sumAboutTwoNum1 = new SumAboutTwoNum_1();
        System.out.println(Arrays.toString(sumAboutTwoNum1.TwoSum(nums,8)));
    }
}
