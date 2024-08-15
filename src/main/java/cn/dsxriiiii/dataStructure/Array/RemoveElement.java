package cn.dsxriiiii.dataStructure.Array;

import java.util.Arrays;

/*
* 双指针法移除元素
* 利用快指针不断移动，慢指针遇到指定元素停止移动的原理，不断地将快指针元素的值赋值给慢指针
* 假如说并没有遇到val值时呢，fast和slow是并行运行的，所以赋值操作就是将原有的值赋值出来
* 在remove函数中，只是在原地对nums数组进行操作，所以返回的是slow指针的下标值
* 在printRemoveArray函数之中，我们使用类似切片的方法调用Arrays.copyOfArray(数组，起始位置，终止位置)输出切割的数组
*
* */
public class RemoveElement {
    public static int remove(int[] nums, int val){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != val){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
    public static void printRemovedArray(int index,int[] nums){
        int[] newArray = Arrays.copyOfRange(nums,0,index);
        System.out.println(Arrays.toString(newArray));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int newIndex = remove(nums,3);
        printRemovedArray(newIndex, nums);
    }
}
