package cn.dsxriiiii.algorithm.Sort;

import java.util.Arrays;
//冒泡排序
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,8,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
