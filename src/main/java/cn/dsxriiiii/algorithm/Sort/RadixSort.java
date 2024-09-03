package cn.dsxriiiii.algorithm.Sort;


import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args){
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组: " + Arrays.toString(array));
        radixSort(array);
        System.out.println("排序后的数组: " + Arrays.toString(array));

    }
    public static void radixSort(int[] array){
        int max = Arrays.stream(array).max().getAsInt();
        int exp = 1;

        while(max / exp > 0){
            countingSort(array,exp);
            exp *= 10;
        }
    }
    public static void countingSort(int[] array,int exp){
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0;i < n;i++){
            //统计单词出现的次数
            count[(array[i] / exp) % 10]++;
        }
        //将count数组变成累积数组，表示每个数字在输出数组中的位置
        for(int i = 1;i < 10;i++){
            count[i] += count[i - 1];
        }
        for(int i = n - 1; i >= 0;i--){
            output[count[(array[i]/exp) % 10] - 1] = array[i];
            count[(array[i]/exp)%10]--;
        }
        System.arraycopy(output,0,array,0,n);
    }
}
