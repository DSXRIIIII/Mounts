package cn.dsxriiiii.LeetCode.NewCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class checkWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 内存容量
        int m = scanner.nextInt(); // 文章长度
        int num = 0;

        Deque<String> queue = new ArrayDeque<>();
        scanner.nextLine();
        for (int j = 0; j < m; j++) {
            String a = scanner.next();
            if (queue.contains(a)) {
                continue; // 如果内存中已存在该单词，继续下一个单词的处理
            }

            if (queue.size() < n) {
                queue.addLast(a); // 内存未满，直接添加单词到内存
            } else {
                queue.pollFirst(); // 内存已满，移除最早进入内存的单词
                queue.addLast(a); // 添加新单词到内存
            }
            num++; // 每次查字典都加1
        }

        System.out.println(num);

        scanner.close(); // 关闭Scanner
    }
}
