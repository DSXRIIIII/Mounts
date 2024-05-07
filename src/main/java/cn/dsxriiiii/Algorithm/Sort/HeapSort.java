package cn.dsxriiiii.Algorithm.Sort;
import java.util.Arrays;
public class HeapSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("堆排序原始数组: " + Arrays.toString(array));
        heapSort(array);
        System.out.println("堆排序后的数组: " + Arrays.toString(array));
    }
    public static void heapSort(int[] array){
        int n = array.length;
        //构建这一半的最大堆
        for(int i = n / 2 - 1;i >= 0;i--){
            heapIfy(array,n,i);
        }

        for(int i  = n - 1;i > 0;i--){
            swap(array,0,i);
            heapIfy(array,i,0);
        }
    }
    public static void heapIfy(int[] array,int n,int root){
        int largest = root;
        int leftChild = 2 *  root + 1;
        int rightChild = 2 * root + 2;
        if(leftChild < n && array[leftChild] > array[largest]){
            largest = leftChild;
        }
        if(rightChild < n && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        if(largest != root){
            swap(array,root,largest);
            heapIfy(array, n, largest);
        }
    }
    public static void swap(int [] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
