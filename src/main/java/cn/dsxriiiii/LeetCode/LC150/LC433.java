package cn.dsxriiiii.LeetCode.LC150;

import java.util.*;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/9 9:03
 * @Email: lihh53453@hundsun.com
 * @Description: 最小基因变化
 * 思路：
 * 1.将单词中每一个字符替换成dict的单词 添加到队列中
 * 2.存储在队列中时进行判断 visit是否遍历过 set集合是否包含目标数组
 * 3.满足以上条件step++
 * 4.当找到end单词时返回step 否则返回-1
 * 5.bfs条件：队列 弹出 队列长度遍历
 */
public class LC433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Character[] dict = {'A','C','G','T'};
        if(startGene.equals(endGene)) return 0;
        if(!set.contains(endGene)) return -1;
        queue.add(startGene);
        visited.add(startGene);
        int step = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; i < word.length(); i++) {
                    for (int k = 0; j < 4; j++) {
                        if(dict[k] != word.charAt(j)){
                            StringBuilder sb = new StringBuilder(word);
                            sb.setCharAt(j,dict[k]);
                            String v_string = sb.toString();
                            if(!visited.contains(v_string) && set.contains(v_string)){
                                if(v_string.equals(endGene)){
                                    return step;
                                }
                                queue.offer(v_string);
                                visited.add(v_string);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
