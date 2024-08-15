package cn.dsxriiiii.lanQiao.answer.practice.C.A1807;


import java.util.Scanner;

//二维差分
/*
题目：    在一个 n×n 的格子上，有 m 个地毯。给定这些地毯的信息，询问每个点被多少个地毯覆盖。
         输入格式:
         第一行包含两个正整数 n 和 m，表示格子的大小和地毯的数量。
         接下来的 m 行，每行包含两对坐标 (x1, y1) 和 (x2, y2)，分别表示一块地毯的左上角和右下角坐标。

         输出格式:
         输出 n 行，每行 n 个正整数。
         第 i 行第 j 列的正整数表示格子 (i, j) 被多少个地毯覆盖。

*/

public class CarpetCoverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] D = new int[5001][5001];  // 差分数组，注意Java数组下标从0开始

        while (m-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            D[x1][y1] += 1;           // 计算差分数组
            D[x2 + 1][y1] -= 1;
            D[x1][y2 + 1] -= 1;
            D[x2 + 1][y2 + 1] += 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                D[i][j] += D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1];
                System.out.print(D[i][j] + " ");
            }
            System.out.println(); // 换行
        }
    }
}


