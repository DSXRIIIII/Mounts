package cn.dsxriiiii.coding.mali;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.mali
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/24 19:30
 * @Description: 01 两次循环
 **/
public class code2024092401 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        Map<Character,Integer> num_map = new HashMap<>();
        Map<Character,Map<Character,Integer>> map = new HashMap<>();
        for(char c : chars){
            num_map.put(c,num_map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < chars.length;i++){
            char o = chars[i];
            if(!map.containsKey(o)){
                Map<Character,Integer> newMap = new HashMap<>();
                newMap.put(o,i + 1);
                map.put(o,newMap);
            }else {
                Map<Character, Integer> characterIntegerMap = map.get(o);
                System.out.print(o + "，" + (characterIntegerMap.values().toArray()[0]) + ";");
                int value = num_map.get(o);
                num_map.put(o,--value);
                if(num_map.get(o) == 1){
                    System.out.print(o + "，" + (i+1) + ";");
                }
                characterIntegerMap.put(o,i + 1);
                map.put(o,characterIntegerMap);
            }
        }
    }
}
