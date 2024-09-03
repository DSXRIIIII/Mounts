package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 14:35
 * @Email: lihh53453@hundsun.com
 * @Description: 字典树 + 回溯 + 递归dfs
 * 1.构建字典树 将每一个单词添加到字典树中
 * 2.遍历每一个棋子 遍历完棋子都需要回溯
 * 3.dfs的过程中会访问当前字典树上是否已经构建了单词 满足isEnd时就将其添加到结果集合中
 */
public class LC212 {
    // 存储结果集
    private final Set<String> res = new HashSet<>();
    // 四个方向的移动：右，左，下，上
    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 接收一个字符矩阵和单词数组，返回矩阵中能拼出的单词列表
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        // 将所有单词插入字典树
        for (String word : words) {
            trie.insert(word);
        }

        // 遍历棋盘的每个格子，从每个格子开始深度优先搜索
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie.root, i, j, new StringBuilder());
            }
        }

        // 将结果集转换为列表并返回
        return new ArrayList<>(res);
    }

    // 深度优先搜索函数
    private void dfs(char[][] board, TrieNode node, int i, int j, StringBuilder word) {
        // 检查当前位置是否越界或已经被访问过
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || node == null || board[i][j] == '*') {
            return;
        }

        // 当前字符
        char c = board[i][j];
        // 计算字符在字典树中的索引
        int index = c - 'a';
        // 获取字典树中对应的节点
        TrieNode nextNode = node.children[index];
        // 如果没有对应的节点，说明当前路径不包含任何单词
        if (nextNode == null) {
            return;
        }

        // 将当前字符添加到路径中
        word.append(c);
        // 如果当前节点是单词的结尾，将路径添加到结果集中
        if (nextNode.isEnd) {
            res.add(word.toString());
        }

        // 标记当前位置为已访问
        board[i][j] = '*';
        // 遍历四个方向
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            // 递归搜索下一个位置
            dfs(board, nextNode, newI, newJ, word);
        }
        // 恢复当前位置的字符
        board[i][j] = c;
        // 回溯，移除路径中的最后一个字符
        word.setLength(word.length() - 1);
    }
}

// 定义字典树节点
class TrieNode {
    // 存储子节点的数组，长度为26，对应26个英文字母
    TrieNode[] children = new TrieNode[26];
    // 标记该节点是否是单词的结尾
    boolean isEnd;

    public TrieNode() {}
}

// 定义字典树
class Trie {
    // 字典树的根节点
    public TrieNode root = new TrieNode();

    // 向字典树中插入单词
    public void insert(String word) {
        TrieNode node = root;
        // 遍历单词中的每个字符
        for (char c : word.toCharArray()) {
            // 计算字符在字典树中的索引
            int index = c - 'a';
            // 如果当前节点没有子节点，创建新的子节点
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            // 移动到子节点
            node = node.children[index];
        }
        // 设置当前节点为单词的结尾
        node.isEnd = true;
    }
}