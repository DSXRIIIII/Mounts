package cn.dsxriiiii.LeetCode.LC150;

import cn.dsxriiiii.LeetCode.LC150.structure.MapNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/8 10:34
 * @Email: lihh53453@hundsun.com
 * @Description: 克隆图
 * 保证图不会死循环的满足条件
 * 1.map存储已经访问的节点 在访问之前进行判断
 * 2.在递归之前就要将克隆节点保存到map中防止重复访问
 */
public class LC133 {
    private final Map<MapNode,MapNode> map = new HashMap<>();
    public MapNode cloneGraph(MapNode node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        MapNode cacheNode = new MapNode(node.val,new ArrayList<>());
        map.put(node,cacheNode);
        for(MapNode mapNode:node.neighbors){
            cacheNode.neighbors.add(cloneGraph(mapNode));
        }
        return cacheNode;
    }
}
