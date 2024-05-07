package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：跳跃游戏
 * 算法思路-1：贪心算法
 * 具体思路：遍历每一个位置，思考每一个位置可以到达的最远举例，前提条件是位置i可以到达
 */
public class LC55 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i = 0; i < nums.length;i++){
            int curIndex = i + nums[i];
            if(i <= maxIndex){   //这里必须要满足的条件 maxIndex记录的是要到达的最远距离
                //如果 i > maxIndex 进行操作是无效的 因为永远到达不了这个位置
                maxIndex = Math.max(curIndex,maxIndex);
            }
            if(maxIndex >= nums.length - 1){  //这里必须满足>=的条件 {0} 这样的情况也是可以到达的
                return true;
            }
        }
        return false;
    }
}
