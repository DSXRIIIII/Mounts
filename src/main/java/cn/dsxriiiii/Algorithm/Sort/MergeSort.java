package cn.dsxriiiii.Algorithm.Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args){
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("排序后的数组: " + Arrays.toString(array));
    }
    public static void mergeSort(int [] array,int left,int right){
        if(left < right){
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1,right);
            merge(array,left,middle,right);
        }
    }
    public static void merge(int[] array, int left, int middle, int right){
        int length_A = middle - left + 1;
        int length_B = right - middle;
        int[] leftArray = new int[length_A];
        int[] rightArray = new int[length_B];
        System.arraycopy(array,left,leftArray,0,length_A);
        System.arraycopy(array,middle + 1,rightArray,0,length_B);
        int i = 0, j = 0,k = left;
        while(i < length_A && j < length_B){
            if(leftArray[i] < rightArray[j]){
                array[k] = leftArray[i];
                i++;
            }else{
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i < length_A){
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < length_B){
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
