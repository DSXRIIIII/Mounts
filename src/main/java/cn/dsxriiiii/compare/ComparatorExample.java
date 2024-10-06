package cn.dsxriiiii.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @PackageName: cn.dsxriiiii.compare
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 15:43
 * @Description: Comparator比较器
 **/
public class ComparatorExample {
    public static void main(String[] args) {
        String[] s = {"ecc", "bbd", "aae","cec","eac"};
        Arrays.sort(s, (o1, o2) -> {
            if (o1.charAt(0)!= o2.charAt(0)) {
                return o1.charAt(0) - o2.charAt(0);
            } else {
                char c1 = o1.length() > 1? o1.charAt(1) : '\u0000';
                char c2 = o2.length() > 1? o2.charAt(1) : '\u0000';
                return Character.compare(c1, c2);
            }
        });
        System.out.println(Arrays.toString(s));
    }
}
