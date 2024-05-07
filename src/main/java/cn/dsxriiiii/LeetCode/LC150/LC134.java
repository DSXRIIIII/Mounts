package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：加油站
 * 算法思路：遍历
 * 具体思路：1.循环数组实现
 *         2.剪枝 更新i时 考虑index
 *         3.计算每次的油量
 */
public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        //思路
        while(i < len) {
            int gasCapacity = 0;
            int costCapacity = 0;
            int index = 0;//保存遍历长度 这个坐标可以表示走了index步 是否成功
            while(index < len){//index表示要走的步数 总共要走len步 走到len步就说明成功了
                int cur = (index + i) % len;
                gasCapacity += gas[cur];
                costCapacity += cost[cur];
                if(costCapacity > gasCapacity){ //不满足条件会走break退出while循环 下一步index也不会更新
                    break;
                }
                index++;
            }
            //长度为len满足条件返回坐标
            if(index == len){
                return i;
            }else{
                i = i + 1 + index;//优化手段
                //为什么不采用以下的方式
                //i = i + 1;
                //因为index已经走了index++自增步数 如果break退出证明index + i这个范围都不合适
                //为什么不合适 如果下一步还是从i + 1开始走 走到 前一个index + i位置时还是不满足条件 所以选择剪枝
                //在更新时将i = i + index + 1；此时从这个地方走可以节约很多时间
            }
        }
        return -1;
    }
}
