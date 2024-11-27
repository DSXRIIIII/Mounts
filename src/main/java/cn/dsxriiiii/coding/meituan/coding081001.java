package cn.dsxriiiii.coding.meituan;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.meituan
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/23 12:11
 * @Description:
 **/
public class coding081001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String ans = scanner.nextLine();
        Map<Integer, Set<String>> find  = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String test = scanner.nextLine();
            find.computeIfAbsent(test.length(),k -> new HashSet<>()).add(test);
        }
        List<Map.Entry<Integer,Set<String>>> sortList = new ArrayList<>(find.entrySet());
        sortList.sort(Map.Entry.comparingByKey());
        int step = 0;
        int MIN = -1;
        int MAX = -1;
        for (Map.Entry<Integer,Set<String>> entry : sortList){
            Set<String> value = entry.getValue();
            if (value.contains(ans)) {
                MIN = step + 1;
                MAX = step + value.size();
            }else{
                step += value.size();
            }
        }
        System.out.println(MIN + " " + MAX);
    }
}
