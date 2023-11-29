/**
*
* LCR108 单词接龙
* https://leetcode.cn/problems/om3reC/description/
*
*/
package cn.dsxriiiii.PowerPointOffer;
import java.util.*;

public class WordChain {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);//需要将wordList单词表传入set之中，否则set读取不到数据
        queue1.add(beginWord);
        int length = 1;
        while(!queue1.isEmpty()){
            String code = queue1.remove();
            if(code.equals(endWord)){
                return length;
            }
            List<String> neighbors = getNeighbors(code);
            for(String neighbor: neighbors){
                if(set.contains(neighbor)){
                    queue2.add(neighbor);
                    set.remove(neighbor);
                }
            }
            if(queue1.isEmpty()){
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<String>();
            }

        }
        return 0;
    }

    public List<String> getNeighbors(String word){
        List<String> neighbors = new LinkedList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char old = arr[i];
            for(char v = 'a'; v <= 'z'; v++){
                if(old != v){
                    arr[i] = v;
                    neighbors.add(String.valueOf(arr));
                }
            }
//            System.out.println(arr[i]);全部输出‘z’

            arr[i] = old;
        }
        return neighbors;
        //对单词进行取邻操作时要将数组还原
        //否则wordlist全部都是'zzz','zzz','zzz'....

    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        WordChain wordChain = new WordChain();
        int Result = wordChain.ladderLength("hit","cog",wordList);
        System.out.println(Result);
    }
}
