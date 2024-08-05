package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Mounts
 * @Description: 汇总区间-LC228
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/2 21:48
 * @Email: lihh53453@hundsun.com
 * 思路：记录初始位置值 并且不断index++即可
 * 要注意while循环条件下
 * 1.确保循环条件
 * 2.确保不要死循环
 */
public class LC228 {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < nums.length){
            int start = index;
            index++;
//            while(nums[index - 1] + 1 == nums[index]){
//                index+=1;
//            }
            //这里要添加限定的范围否则index会一直增加
            while(index < nums.length && nums[index - 1] + 1 == nums[index]){
                index+=1;
            }
            int location = index - 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nums[start]);
            if(start<location){
                stringBuilder.append("->");
                stringBuilder.append(nums[location]);
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }
}
