package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 9:44
 * @Email: lihh53453@hundsun.com
 * @Description: 单词接龙
 * 单词接龙 参数 start开始单词 end结束单词 限定符合的单词集合keys
 * 1.遍历单词集合set防止重复遍历
 * 2.queue队列保存下一遍历单词 创建队列 初始化队列 弹出节点 确定每一次队列的长度循环遍历
 * 3.确定判断条件
 *   3.1 不在keys中直接进入下一次循环
 *   3.2 visit已经访问的直接进入下一次循环
 */
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visit = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> key = new HashSet<>(wordList);
        int step = 1;
        if(beginWord.equals(endWord) || !key.contains(endWord)) return 0;
        queue.offer(beginWord);
        visit.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                assert word != null;
                if(word.equals(endWord)) return step;
                for (int j = 0; j < endWord.length(); j++) {
                    char[] charArray = word.toCharArray();
                    char temp = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if(k == word.charAt(j)){
                            continue;
                        }
                        charArray[j] = k;
                        String v_string = new String(charArray);
                        if(!visit.contains(v_string) && key.contains(v_string)){
                            visit.add(v_string);
                            queue.offer(v_string);
                        }
                    }
                    charArray[j] = temp;
                }
            }
            step++;
        }
        return 0;
    }
}
