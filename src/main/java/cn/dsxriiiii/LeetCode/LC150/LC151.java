package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

/**
 * 题目：反转字符串中的单词
 * 算法思路：调用方法（正则表达式）
 * 具体思路：1.字符数组的第一个字符串为比较串
 *          2.横向比较法 两两比较
 *          3.纵向比较法 全部比较
 *          4.时间复杂度都为O(mn) 空间复杂度为O(1) 常数
 * 补充：正则表达式：
 *          1.“_”  匹配任何单个字符
 *          2."*"  匹配0个或者多个在它面前的字符
 *          3."%"  匹配任意数字字符
 *          4."[]" 匹配方括号中的任意字符
 */
public class LC151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords_queue(s));
    }
    public static String reverseWords_function(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        // "\\s+" 表示一个或者多个连续的空白字符串
        Collections.reverse(list);//翻转list中的所有单词
        System.out.println(list);//[blue, is, sky, the]
        return String.join(" ",list);
    }

    /**
     * 使用双端队列Deque在头部插入新数据
     */
    public static String reverseWords_queue(String s) {
        s = s.trim();
        Deque<String> queue = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){ //从左向右遍历 遇到字符添加进入word 当遇到空白字符时添加进入队列并且重置word
            char c = s.charAt(left);
            if(word.length() != 0 && c == ' '){
                queue.offerFirst(word.toString());
                word.setLength(0);
            }else if(c != ' '){//"example   good a" 确保这样的方式也能通过 避免中间的多余空格
                word.append(c);
            }
            left++;
        }
        queue.offerFirst(word.toString());
        return String.join(" ",queue);
    }
}
