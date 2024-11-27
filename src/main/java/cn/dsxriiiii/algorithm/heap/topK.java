package cn.dsxriiiii.algorithm.heap;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.algorithm.heap
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/09 20:42
 * @Description:
 **/
public class topK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> local = new HashMap<>();
        for(int num : nums){
            local.put(num,local.getOrDefault(num,0) + 1);
        }
        int size = local.size();
        Set<Map.Entry<Integer,Integer>> set = local.entrySet();
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(set);
        buildHeap(size,list);
        int[] res = new int[k];
        int index = 0;
        for (int i = local.size() - 1; i >= 0 ; i--) {
            res[index++] = list.get(0).getValue();
            Collections.swap(list,0,i);
            --size;
            maxHeapify(list,size,0);
        }
        return res;
    }

    private void buildHeap(int size, List<Map.Entry<Integer, Integer>> list) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            maxHeapify(list,size,i);
        }
    }

    private void maxHeapify(List<Map.Entry<Integer, Integer>> list, int size, int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if(l < size && list.get(l).getValue() > list.get(largest).getValue()){
            largest = l;
        }
        if(r < size && list.get(r).getValue() > list.get(largest).getValue()){
            largest = r;
        }
        if(largest != i){
            Collections.swap(list,i,largest);
            maxHeapify(list,size,largest);
        }
    }
}
