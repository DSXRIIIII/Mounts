package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashSet;
import java.util.Set;

    /**
     * @ProjectName: Mounts
     * @Description:
     * @Author: DSXRIIIII
     * @CreateDate: 2024/8/2 21:28
     * @Email: lihh53453@hundsun.com
     */
    public class LC128 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            //初始长度为0 因为要对空的数组判断
            int result = 0;
            for (int num : nums) {
                set.add(num);
            }
    //        for (int num : nums) {
    //            int locLen = 1;
    //            int currentNum = num;
    //            while (!set.contains(currentNum - 1)) {
    //                currentNum += 1;
    //                locLen += 1;
    //            }
    //            result = Math.max(locLen, result);
    //        }
    //        return result;
            for (int num : nums) {
                //上面的方法缺少对这个数是不是最底层的数的判断
                //因为题目要求连续那么只能是一直加1连续的数 那么-1判断的逻辑就不能少
                if(!set.contains(num - 1)){
                    //有数字 保底就是1
                    int locLen = 1;
                    int currentNum = num;
                    //不断往前走的逻辑 只要set有+1的数 就是连续并且满足条件的
                    while (set.contains(currentNum + 1)) {
                        currentNum += 1;
                        locLen += 1;
                    }
                    result = Math.max(locLen, result);
                }
            }
            return result;
        }
    }
