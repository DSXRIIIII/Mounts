package cn.dsxriiiii.coding.mihayou;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.mihayou
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/22 13:02
 * @Description:
 **/
public class codeing080303 {
    private static void solve() {
        int n = sc.nextInt();
        int x = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        int[] indegre = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
            indegre[a]++;
            indegre[b]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            if (indegre[i] == 1) {
                if (i == x) {
                    System.out.println("Xiaoyo");
                    return;
                }
                q.add(i);
            }
        }

        int cnt = 0;
        boolean flg = false;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            if (node == x) {
                flg = true;
                continue;
            }
            for (int next : graph.get(node)) {
                indegre[next]--;
                if (indegre[next] == 1) {
                    q.add(next);
                }
            }
        }

        if (!flg) {
            System.out.println("Draw");
        } else if (cnt % 2 == 0) {
            System.out.println("Pyrmont");
        } else {
            System.out.println("Xiaoyo");
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            solve();
        }
        sc.close();
    }
}
