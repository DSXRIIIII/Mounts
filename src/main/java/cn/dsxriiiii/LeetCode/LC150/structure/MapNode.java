package cn.dsxriiiii.LeetCode.LC150.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/8 10:34
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public class MapNode {
    public int val;
    public List<MapNode> neighbors;
    public MapNode() {
        val = 0;
        neighbors = new ArrayList<MapNode>();
    }
    public MapNode(int _val) {
        val = _val;
        neighbors = new ArrayList<MapNode>();
    }
    public MapNode(int _val, ArrayList<MapNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
