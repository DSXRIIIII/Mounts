package cn.dsxriiiii.Algorithm.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        double[] array={0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        System.out.println("原始数组" + Arrays.toString(array));
        bucketSort(array);
        System.out.println("排序后的数组" + Arrays.toString(array));
    }
    public static void bucketSort(double[] array){
        int n = array.length;
        ArrayList<Double>[] buckets =new ArrayList[n];
        for (int i = 0; i < n; i++){
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * array[i]);
            buckets[bucketIndex].add(array[i]);
        }
        for(int i = 0;i < n;i++){
            Collections.sort(buckets[i]);
        }
        int index = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0;j < buckets[i].size();j++){
                array[index++] = buckets[i].get(j);
            }
        }

    }
}
