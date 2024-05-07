package cn.dsxriiiii.Algorithm.Sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];//取出来的数
            int j = i - 1;//取出来的数与前面的n数（j--得到）进行比较
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];//如果比取出来的数大，那么就把这个数向后移动进行覆盖
                j--;//进行下一次的判断
            }
            arr[j + 1] = key;//在while循环中j--过一次，此时要将判断的位置 +1 ,这才是要插入的位置
        }
    }

    public static void main(String[] args) {
        int[] arr = {29,10,11,12,14,37,15};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
