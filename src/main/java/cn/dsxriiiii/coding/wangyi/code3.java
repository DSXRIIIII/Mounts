package cn.dsxriiiii.coding.wangyi;

import cn.hutool.core.annotation.Link;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.wangyi
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 11:18
 * @Description: 3
 **/
public class code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if(!s.startsWith("[") && s.endsWith("]")){
                System.out.println("invalid" + " " + "0");;
            }
            String[] substring = s.split(",");
//            System.out.println(Arrays.toString(substring));
            int index = 1;
            for (String s1 : substring) {
                Node judge = judge(s1);
                if (!judge.judge && index != 1) {
                    System.out.println("invalid" + " " + (index + judge.index));
                }
                index += s1.length() + 1;
            }
            System.out.println("valid");
        }
    }
    private static Node judge(String s){
        int index = 0;
        char[] charArray = s.toCharArray();
        if(s.isEmpty()) return new Node(0,false);
        if(s.length() == 1) return new Node(1,true);
        Map<Character,Integer> map = new HashMap<>();
        for(char c : charArray){
            if(c == '['){
                map.put(c,map.getOrDefault(c,0) + 1);
            }else if(c == ']'){
                map.put(c,map.getOrDefault(c,0) + 1);
            }else if(map.isEmpty()){
                index++;
            }
        }
        if(map.size() != 0 && !map.get('[').equals(map.get(']'))){
            return new Node(index,false);
        }
        return new Node(index,true);
    }
}
class Node{
    public int index;
    public boolean judge;
    public Node(int index,boolean judge){
        this.index = index;
        this.judge = judge;
    }
}
