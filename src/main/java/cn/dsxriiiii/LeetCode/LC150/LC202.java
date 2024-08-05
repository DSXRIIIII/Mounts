package cn.dsxriiiii.LeetCode.LC150;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: Mounts
 * @Description: 快乐数  1**2 + 9**2 = 82
 *                      8**2 + 2**2 = 68
 *                      6**2 + 8**2 = 100
 *                      1**2 + 0**2 + 0**2 = 1
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/19 14:39
 * @Email: lihh53453@hundsun.com
 * 技巧：快乐树会形成一个循环
 *      例如：4 最终会回到4
 *      最大的数999999999 也会回到810  最后811次循环就会回到起点
 * 思路：1.字符串分解 ？ -> 会死循环
 *      2.怎么跳出死循环 ？
 *      3.哈希Set 把每个数都放到set中 当set有重复值则会退出循环
 *      4.快慢指针 当快指针指向慢指针说明此时走了一个循环周期  要判断这个循环是不是1引起的
 */
public class LC202 {

    public static int GetNext(int n){
        int total = 0;
        while(n != 0){
            int num = n % 10;
            total += num * num;
            n = n / 10;
        }
        return total;
    }

    public boolean isHappyBySet(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = GetNext(n);
        }
        return n == 1;
    }

    public boolean isHappyByHash(int n) {
        int slow = n,fast = n;
        do{
            slow = GetNext(slow);
            fast = GetNext(fast);
            fast = GetNext(fast);
        }while(slow != fast);

        return slow == 1;
    }

    public static void main(String[] args) {
        //System.out.println(GetNext(12));
    }
}
