package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 10:40
 * @Email: lihh53453@hundsun.com
 * @Description:
 * 对于一个前缀树节点
 * 每一个节点都维护了一个26位的数组
 * 并且每一个节点都有一个isEnd标志位标志是否存在前缀
 */
public class LC208 {
    private LC208[] children;
    private boolean isEnd;
    public LC208() {
        boolean isEnd = false;
        children = new LC208[26];
    }

    public void insert(String word) {
        LC208 trie = this;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int index = c - 'a';
            if(trie.children[index] == null){
                trie.children[index] = new LC208();
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        LC208 trie = searchPrefix(word);
        return null != trie && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private LC208 searchPrefix(String prefix) {
        LC208 trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(trie.children[index] == null){
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }
}
