package cn.dsxriiiii.newcoder;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.newcoder
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/24 15:30
 * @Description: 小红的字符串
 **/
public class BMN2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int start = 0;
        int end = 2;
//        System.out.println(s.substring(start,end + 1));
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            res.add(s.substring(i,i+2));
        }
        //Collections.sort(res,(a,b)-> a.charAt(0) - b.charAt(0));
        res.sort(Comparator.comparingInt(a -> a.charAt(0)));
        for(String str : res){
            System.out.println(str);
        }
    }
}
