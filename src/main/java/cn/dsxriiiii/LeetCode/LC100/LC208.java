package cn.dsxriiiii.LeetCode.LC100;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.LC100
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/03 15:03
 * @Description: LC208
 **/
class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie() {
        boolean isEnd = false;
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie trie = this;
        char[] charArray = word.toCharArray();
        for(char c : charArray){
            int index = c - 'a';
            if(trie.children[index] == null){
                children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return null != trie && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private Trie searchPrefix(String word){
        Trie trie = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(trie.children[index] == null){
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }
}
