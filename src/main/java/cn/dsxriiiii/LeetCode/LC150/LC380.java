package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

public class LC380 {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    public LC380() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int lastNum = list.get(list.size()-1);
        list.set(index,lastNum);
        map.put(lastNum,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}
