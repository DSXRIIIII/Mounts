package cn.dsxriiiii.LeetCode.LC100;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/30 10:44
 * @Description: LC128
 **/
public class LC128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            int len = 1;
            if(!set.contains(num - 1)){
                int cur = num;
                while(set.contains(cur + 1)){
                    cur += 1;
                    len++;
                }
                res = Math.max(len,res);
            }
        }
        return res;
    }
}
