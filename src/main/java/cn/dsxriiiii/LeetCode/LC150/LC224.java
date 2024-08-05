package cn.dsxriiiii.LeetCode.LC150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/3 19:17
 * @Email: lihh53453@hundsun.com
 * @Description:
 * 定义一个栈用来记录当前括号内的数字是否要变成负数
 * 例如-(1 + 2 + 3) --> -1 - 2 - 3
 * sign 的作用即是 保持同一个括号内的数字 去掉括号后的数字要转换
 * 并且该题目也有多位数相加 所以还要添加一个循环
 * (1 + 2 - (1 + 2))
 * 分析：
 *     1.遇到（括号 将当前sign值添加到队列
 *     2.遇到 数字1 res+=sign*1 此时sign为1
 *     3.遇到 + 保持最新的sign peek操作不会将值弹出只做检查
 *     4.遇到 数字2 res+=sign*2 此时sign为1
 *     5.遇到 - 反转此时的sign值 -ops.peek() 将此时的sign值反转
 *     6.遇到（括号 将当前sign值添加到队列 此时sign值为-1 意味着括号内的所有加减号都要反转
 *     7.遇到 数字1 res+=sign*1 此时sign为-1 所以是减操作
 *     8.遇到 数字2 res+=sign*1 此时sign为-1 所以是减操作
 *     9.遇到）括号 将当前sign值移除队列 最新的sign值不会对产生数字影响
 *     10.遇到）括号 将当前sign值移除队列 最新的sign值不会对产生数字影响
 */
public class LC224 {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;
        ops.push(1);
        int index = 0;
        int res = 0;
        while(index < s.length()){
            if(s.charAt(index) == ' '){
                index++;
            }else if(s.charAt(index) == '('){
                ops.push(sign);
                index++;
            }else if(s.charAt(index) == ')'){
                ops.pop();
                index++;
            }else if(s.charAt(index) == '+'){
                sign = ops.peek();
                index++;
            }else if(s.charAt(index) == '-'){
                sign = -ops.peek();
                index++;
            }else{
                int num = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                res += sign * num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " 2-1 + 2 ";
        LC224 lc224 = new LC224();
        lc224.calculate(s);
    }
}
