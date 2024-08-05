package cn.dsxriiiii.LeetCode.LC150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/16 16:32
 * @Email: lihh53453@hundsun.com
 * @Description: 串联所有单词的子串
 * 思路：滑动窗口
 *      1.确定滑动窗口起始位置left，right
 *      2.right不断右移，移动条件为right+单个单词长度不超过s.length()
 *      3.left不断右移，移动条件为
 *                              1.right右移产生的单词在字符串中不存在 此时需要将map清空 left = right count计数器 =0
 *                              2.right右移产生单个单词数超过了words中的数量 此时while循环会判断当前right右移产生单个单词数是否一直超过了words中的数量
 *                                true:count(用来计数判断的有效个数)--,left移动
 */
public class LC30 {
    public static void main(String[] args) {
        String s = "foobarfoobarfoothe";
        String[] words = {"foo","bar","foo","the"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s,String[] words){
        Map<String,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if(s.isEmpty() || words.length == 0) return res;
        for(String word:words){
            if(!s.contains(word)) return res;
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        int oneWordLength = words[0].length();
        int wordsLength = oneWordLength * words.length;
        if(wordsLength > s.length()) return res;
        for(int i = 0;i < words[0].length();i++){
            int left = i;
            int right = i;
            int count = 0;
            Map<String,Integer> subMap = new HashMap<>();
            while(right + oneWordLength  <= s.length()){
                String newWordByRight = s.substring(right,right+oneWordLength);
                right = right + oneWordLength;
                if(!map.containsKey(newWordByRight)){
                    subMap.clear();
                    left = right;
                    count = 0;
                }else{
                    subMap.put(newWordByRight,subMap.getOrDefault(newWordByRight,0) + 1);
                    count++;
                    while(subMap.getOrDefault(newWordByRight,0) > map.getOrDefault(newWordByRight,0)){
                        String newWordByLeft = s.substring(left,left + oneWordLength);
                        subMap.put(newWordByLeft,subMap.getOrDefault(newWordByLeft,0) - 1);
                        count--;
                        left = left + oneWordLength;
                    }
                    if(count == words.length){
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }

    public static List<Integer> solution2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();
        if (s.isEmpty() || words.length == 0) return res;
        for (String word: words) {
            // 主串s中没有这个单词，直接返回空
            if (!s.contains(word)) return res;
            // map中保存每个单词，和它出现的次数
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        // 每个单词的长度， 总长度
        int oneLen = words[0].length(), wordsLen = oneLen * words.length;
        // 主串s长度小于单词总和，返回空
        if (wordsLen > s.length()) return res;
        // 只讨论从0，1，...， oneLen-1 开始的子串情况，
        // 每次进行匹配的窗口大小为 wordsLen，每次后移一个单词长度，由左右窗口维持当前窗口位置
        for (int i = 0; i < oneLen; ++i) {
            // 左右窗口
            int left = i, right = i, count = 0;
            // 统计每个符合要求的word
            Map<String, Integer> subMap = new HashMap<>();
            // 右窗口不能超出主串长度
            while (right + oneLen <= s.length()) {
                // 得到一个单词
                String word = s.substring(right, right + oneLen);
                // 有窗口右移
                right += oneLen;
                // words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!wordsMap.containsKey(word)) {
                    left = right;
                    // 窗口内单词统计map清空，重新统计
                    subMap.clear();
                    // 符合要求的单词数清0
                    count = 0;
                } else {
                    // 统计当前子串中这个单词出现的次数
                    subMap.put(word, subMap.getOrDefault(word, 0) + 1);
                    ++count;
                    // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串
                    // 如 ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                    // 第二个bar虽然是words[]中的单词，但是次数抄了，那么右移一个单词长度后 "|barfoobarfoo|the"
                    // bar还是不符合，所以直接从这个不符合的bar之后开始匹配，也就是将这个不符合的bar和它之前的单词(串)全移出去
                    while (subMap.getOrDefault(word, 0) > wordsMap.getOrDefault(word, 0)) {
                        // 从当前窗口字符统计map中删除从左窗口开始到数量超限的所有单词(次数减一)
                        String w = s.substring(left, left + oneLen);
                        subMap.put(w, subMap.getOrDefault(w, 0) - 1);
                        // 符合的单词数减一
                        --count;
                        // 左窗口位置右移
                        left += oneLen;
                    }
                    // 当前窗口字符串满足要求
                    if (count == words.length) res.add(left);
                }
            }
        }
        return res;
    }
}
