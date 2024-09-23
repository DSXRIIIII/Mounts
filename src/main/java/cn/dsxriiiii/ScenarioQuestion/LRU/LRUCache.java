package cn.dsxriiiii.ScenarioQuestion.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.ScenarioQuestion.LRU
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/18 15:20
 * @Description: LRU 最近最少使用缓存
 **/
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    private LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    public V getValue(K key) {
        return super.getOrDefault(key, null);
    }

    public void putValue(K key, V value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        // 创建⼀个容量为3的LRU缓存
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);
        // 添加数据
        lruCache.putValue(1, "One");
        lruCache.putValue(2, "Two");
        lruCache.putValue(3, "Three");
        System.out.println(lruCache);
        // 此时缓存为：{1=One, 2=Two, 3=Three}
        // 访问某个元素，使其成为最近访问的元素
        String value = lruCache.getValue(2);
        System.out.println(value);
        System.out.println(lruCache);
        // 此时缓存为：{1=One, 3=Three, 2=Two}
        // 添加新的数据，触发淘汰
        lruCache.put(4, "Four");
        System.out.println(lruCache);
        // 此时缓存为：{3=Three, 2=Two, 4=Four}
        // 元素1被淘汰，因为它是最近最少访问的元素
    }
}
