package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 11:13
 * @Email: lihh53453@hundsun.com
 * @Description: 单词拼写
 * 1.每一个节点维护一个节点数组和结束标志isEnd
 * 2.使用start坐标标志位 当与长度相同时 结束判断isEnd是否为true
 */
public class LC221 {
}
class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
    }

    public void addWord(String word) {
        WordDictionary node = this;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int index = charArray[i] - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    private boolean search(WordDictionary node, String word, int start) {
        if (start == word.length()) {
            return node.isEnd;
        }
        char c = word.charAt(start);
        if (c != '.') {
            WordDictionary child = node.children[c - 'a'];
            return child != null && search(child, word, start + 1);
        } else {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && search(node.children[j], word, start + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
