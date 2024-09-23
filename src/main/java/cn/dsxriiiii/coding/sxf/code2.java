package cn.dsxriiiii.coding.sxf;

import java.util.*;
/**
 * @PackageName: cn.dsxriiiii.coding.sxf
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/20 21:20
 * @Description: 第二题
 **/
public class code2 {
    private static Map<Integer, List<Integer>> ip_map;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] number = scanner.nextLine().split(" ");
        int n = Integer.valueOf(number[0]);
        int m = Integer.valueOf(number[1]);
        Map<String, Integer> ids = new HashMap<>();
        ip_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] ips = scanner.nextLine().split(" ");
            ids.put(ips[0], Integer.valueOf(ips[1]));
        }
        for (int i = 0; i < m; i++) {
            String[] locations = scanner.nextLine().split(" ");
            List<Integer> list = ip_map.getOrDefault(Integer.valueOf(locations[0]), new ArrayList<>());
            list.add(Integer.valueOf(locations[1]));
            ip_map.put(Integer.valueOf(locations[0]), list);
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            boolean res = false;
            String[] ip_idxs = scanner.nextLine().split(" ");
            if (!ids.isEmpty() && ip_idxs.length != 0) {
                int index1 = ids.get(ip_idxs[0]);
                int index2 = ids.get(ip_idxs[1]);
                res = dfs(index1, index2);
                System.out.println(res ? "Yes" : "No");
            }
        }
    }
    public static boolean dfs(int a, int b) {
        List<Integer> list = ip_map.get(a);
        if(list == null || list.isEmpty()) return false;
        if (list.contains(b)) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            boolean res = dfs(b, list.get(i));
            if (res) return res;
        }
        return false;
    }
}
