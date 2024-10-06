package cn.dsxriiiii.LeetCode.LC100;

import java.util.Arrays;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 15:58
 * @Description: LC215
 **/
public class LC215 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(heapSize,nums);
        System.out.println(Arrays.toString(nums));
        for (int i = nums.length - 1; i < nums.length - k + 1 ; i++) {
            swap(0,i,nums);
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }
        System.out.println(Arrays.toString(nums));
        return nums[0];

    }

    private void buildHeap(int heapSize, int[] nums) {
        for (int i = heapSize / 2 - 1; i >= 0; --i) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if(left < heapSize && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(i,largest,nums);
            maxHeapify(nums,largest,heapSize);
        }
    }
    private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC215 lc215 = new LC215();
        lc215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},3);
    }

}
