package cn.dsxriiiii.coding.huawei;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.huawei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/08 19:36
 * @Description:
 * 第一行输入两个正整数n和d ，代表软件的个数和依赖关系。后面d行输入相应的依赖关系。下一行输入一个正整数q，代表查询的组数。之后q行输入相应的查询。
 * 第一行输出q。之后q行每行输出一个正整数，如果是依赖关系，输出1，否则输出0
 * /
 *   3 3
 *   0 1
 *   1 2
 *   0 2
 *   2
 *   1 0
 *   0 1
 *   /
 *   2
 *   0
 *   1
 *   /
 **/
public class coding071702 {
    private static Map<Integer, List<Integer>> paths;

    public static void main(String[] args) {
        paths = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            paths.put(i,new ArrayList<>());
        }
        for(int i = 0;i < d;i++){
            String[] path = scanner.nextLine().split(" ");
            List<Integer> local = paths.getOrDefault(Integer.parseInt(path[0]), new ArrayList<>());
            local.add(Integer.parseInt(path[1]));
            paths.put(Integer.parseInt(path[0]),local);
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        System.out.println(q);
        for (int i = 0; i < q; i++) {
            String[] finds = scanner.nextLine().split(" ");
            if(findIndex(Integer.parseInt(finds[0]),Integer.parseInt(finds[1]))){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    private static boolean findIndex(int son, int father) {
        boolean res = false;
        if(son == father){
            return true;
        }
        for(int next : paths.get(son)){
            res = findIndex(next,father);
            if(res) break;
        }
        return res;
    }
}
