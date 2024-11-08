package cn.dsxriiiii.coding.kedaxunfei;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/06 16:42
 * @Description:
 * 给出一个大小为n的序列a，每次操作可以选择序列a中的一个数x，把x变成x*2或者[x/2]（对同一个a可以操作多次但不能既进行乘操作又进行除操作）。
 * 问最少操作多少次使得a是不下降的。
 * /
 * 5
 * 10 10 5 6 4
 * /
 * 3
 * /
 **/
public class coding071303 {
    public static final long MAXN = 1000000000000000000L;
    // 使用二维列表模拟 C++ 中的二维哈希表
    static List<Map<Long, Integer>> dp = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 初始化 dp[0]
        Map<Long, Integer> initialMap = new HashMap<>();
        initialMap.put(1L, 0);
        dp.add(initialMap);

        for (int i = 0; i < n; i++) {
            Map<Long, Integer> currentDp = dp.get(i);
            Map<Long, Integer> nextDp = new HashMap<>();
            for (Map.Entry<Long, Integer> entry : currentDp.entrySet()) {
                long j = entry.getKey();
                int steps = entry.getValue();
                if (nums[i] >= j) {
                    // 不变
                    if (!nextDp.containsKey(nums[i]) || nextDp.get(nums[i]) > steps) {
                        nextDp.put((long) nums[i], steps);
                    }

                    // 变大
                    long num = nums[i];
                    int cnt = 0;
                    while (num <= MAXN) {
                        num *= 2;
                        cnt++;
                        if (!nextDp.containsKey(num) || nextDp.get(num) > steps + cnt) {
                            nextDp.put(num, steps + cnt);
                        }
                        if (num > MAXN / 2) break;
                    }

                    // 变小
                    num = nums[i];
                    cnt = 0;
                    while (num / 2 >= j) {
                        cnt++;
                        num /= 2;
                        if (!nextDp.containsKey(num) || nextDp.get(num) > steps + cnt) {
                            nextDp.put(num, steps + cnt);
                        }
                    }
                } else {
                    // 只能变大
                    long num = nums[i];
                    int cnt = 0;
                    while (num <= MAXN) {
                        num *= 2;
                        cnt++;
                        if (num >= j && (!nextDp.containsKey(num) || nextDp.get(num) > steps + cnt)) {
                            nextDp.put(num, steps + cnt);
                        }
                        if (num > MAXN / 2) break;
                    }
                }
            }
            dp.add(nextDp);
        }

        int ans = Integer.MAX_VALUE;
        Map<Long, Integer> lastMap = dp.get(n);
        for (Map.Entry<Long, Integer> entry : lastMap.entrySet()) {
            if (entry.getValue() < ans) {
                ans = entry.getValue();
            }
        }

        System.out.println(ans);
        scanner.close();
    }
}
