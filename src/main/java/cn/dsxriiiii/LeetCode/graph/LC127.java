package cn.dsxriiiii.LeetCode.graph;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.LeetCode.graph
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/10/31 11:55
 * @Description:
 **/
public class LC127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Deque<String> deque = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        Set<String> steps = new HashSet<>(wordList);
        deque.offer(beginWord);
        visit.add(beginWord);
        int res = 1;
        while(!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String s = deque.poll();
                if (s.equals(endWord)) return res;
                char[] charArray = s.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k!= originalChar) {
                            charArray[j] = k;
                            String next = new String(charArray);
                            if (!visit.contains(next) && steps.contains(next)) {
                                visit.add(next);
                                deque.offer(next);
                            }
                        }
                    }
                    charArray[j] = originalChar;
                }
            }
            res++;
        }
        return 0;
    }
}
