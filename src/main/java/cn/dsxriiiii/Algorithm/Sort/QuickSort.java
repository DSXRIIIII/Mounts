package cn.dsxriiiii.Algorithm.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {49,38,65,97,76,13,27};
        //{49,38,65,97,76,13,27}   奇数选择49
        //{27,38,13,26,49,97,65}
        //选择49 的左右侧进行递归
        System.out.println("原始数组" + Arrays.toString(array));
        quickSort(array,0,array.length - 1);
        System.out.println("排序后的数组" + Arrays.toString(array));
    }
    public static void quickSort(int[] array,int low, int high){
        if(low < high){
            int partitionIndex = partition(array,low,high);
            quickSort(array,low,partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    public static int partition(int[] array,int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for(int j = low;j < high;j++){
            if(array[j] < pivot){
                i++;
                swap(array,i,j);
            }
        }
        swap(array,i+1,high);
        return i + 1;
    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
