package cn.dsxriiiii.coding.wangyi;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.wangyi
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 10:04
 * @Description: 1
 **/
public class code1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length;i++){
            if(map.containsKey(s[i])){
                int index = map.get(s[i]);
                s[index] = null;
                map.put(s[i], i);
                continue;
            }
            map.put(s[i],i);
        }
        for (String value : s) {
            if (value != null) {
                System.out.print(value + " ");
            }
        }
    }
}
