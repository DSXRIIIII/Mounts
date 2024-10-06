package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 18:43
 * @Description: LC75
 **/
public class LC75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while(i <= p2 && nums[i] == 2 ){
                swap(i,p2,nums);
                p2--;
            }
            if(nums[i] == 0){
                swap(i,p0,nums);
                p0++;
            }
        }
    }

    private void swap(int i, int p2, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[p2];
        nums[p2] = temp;
    }
}
