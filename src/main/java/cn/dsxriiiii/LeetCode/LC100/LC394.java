package cn.dsxriiiii.LeetCode.LC100;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/05 14:25
 * @Description: LC394
 **/
public class LC394 {
    private static int index;
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                String value = getDigit(s);
                stack.push(value);
            }else if(Character.isLetter(c) || c == '['){
                stack.push(String.valueOf(s.charAt(index++)));
            }else{
                index++;
                LinkedList<String> cur = new LinkedList<>();
                while(!"[".equals(stack.peek())){
                    cur.push(stack.poll());
                }
                Collections.reverse(cur);
                String cur_string = getString(cur);
                stack.poll();
                int mul = Integer.parseInt(Objects.requireNonNull(stack.poll()));
                StringBuilder sb = new StringBuilder();
                while(mul-- > 0){
                    sb.append(cur_string);
                }
                stack.push(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(stack));
        return sb.reverse().toString();
    }

    private String getString(LinkedList<String> cur) {
        StringBuilder sb = new StringBuilder();
        for(String s : cur){
            sb.append(s);
        }
        return sb.toString();
    }

    private String getDigit(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LC394 lc394 = new LC394();
        System.out.println(lc394.decodeString("3[a2[c]]"));;
    }
}
