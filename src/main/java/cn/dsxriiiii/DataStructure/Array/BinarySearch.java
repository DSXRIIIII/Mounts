package cn.dsxriiiii.DataStructure.Array;
/*
* 最基础的二分查找
*
*
* */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int Result = binarySearch.searchWithoutEqual(new int[]{-1,0,3,5,9,12},9);
        System.out.println(Result);
    }
    public int searchWithEqual(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if (nums[middle] == target){
                return middle;
            }
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }
        }
        return -1;
    }
    public int searchWithoutEqual(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(nums[middle] == target){
                return middle;
            }
            if(nums[middle] > target){
                right = middle;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }
}
