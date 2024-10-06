package cn.dsxriiiii.LeetCode.LC100;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 16:17
 * @Description:
 **/
public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()){
            if(priorityQueue.size() < k){
                priorityQueue.add(key);
            }else if(map.get(key) > map.get(priorityQueue.peek())){
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        int [] res = new int[k];
        int index = 0;
        while(!priorityQueue.isEmpty()){
            res[index++] = priorityQueue.poll();
        }
        return res;
    }
}
