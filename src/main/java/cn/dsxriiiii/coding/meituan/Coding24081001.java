package cn.dsxriiiii.coding.meituan;

import java.util.*;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/10 14:54
 * @Email: lihh53453@hundsun.com
 * @Description: 2024年8月10日美团笔试第一题:小妹的密码
 * 第一行输入记住的密码数量
 * 第二行输入正确密码
 * 接下来几行输入密码数量的密码比对值
 * 问 最大需要比对的次数 和 最小要比对的次数
 * 思路：
 * 创建map集合 键为密码长度 值为存放密码的set集合
 * 依次遍历将存储数据 将map转化为list集合
 * 整理后 遍历链表 从最短的长度开始
 * 如果该长度的列表没有数据 step+=当前set集合的长度
 * 如果该长度存在答案数据 最少次数只需要一步就能找到数据 step = step + 1
 *                   最大次数需要遍历所有数据才能找到 step = step + value.size();
 */
public class Coding24081001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String ans = scanner.next();
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String p = scanner.next();
            //如果Map中没有对应的键，就会使用这个新的HashSet作为值
            map.computeIfAbsent(p.length(),k->new HashSet<>()).add(p);
        }
        List<Map.Entry<Integer,Set<String>>> sortedPos = new ArrayList<>(map.entrySet());
        sortedPos.sort(Map.Entry.comparingByKey());
        int step = 0;
        int MIN = -1,MAX = -1;
        for(Map.Entry<Integer,Set<String>> entry : sortedPos){
            Set<String> value = entry.getValue();
            if(value.contains(ans)){
                MIN = step + 1;
                MAX = value.size() + step;
            }else{
                step += value.size();
            }
        }
        System.out.println(MIN + " " + MAX);
        scanner.close();
    }
}
