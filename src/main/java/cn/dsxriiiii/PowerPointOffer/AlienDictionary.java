package cn.dsxriiiii.PowerPointOffer;

import java.util.*;

public class AlienDictionary {
    public String isAlienSorted(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character,Integer> inDegree = new HashMap<>();
        for(String word : words){
            for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch, new HashSet<Character>());
                inDegree.putIfAbsent(ch, 0);
            }
        }
        for(int i = 1; i< words.length; i++){
            String word1 = words[i];
            String word2 = words[i-1];
            if(word1.startsWith(word2) && !word1.equals(word2)){
                return "";
            }
            for(int j = 0; j < word1.length() && j < word2.length(); j++){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if(ch1 != ch2){
                    if(!graph.get(ch1).contains(ch2)){
                        graph.get(ch1).add(ch2);//防止添加相同节点
                        inDegree.put(ch2,inDegree.get(ch2) + 1);
                        //inDegree.get(ch2)++
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(char ch : inDegree.keySet()){
            if(inDegree.get(ch) == 0){
                queue.add(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!queue.isEmpty()){
            char ch = queue.remove();
            stringBuilder.append(ch);
            for(char next : graph.get(ch)){
                inDegree.put(next,inDegree.get(next) - 1);
                if(inDegree.get(next) == 0){
                    queue.add(next);
                }
            }
        }
        return stringBuilder.length() == graph.size() ? stringBuilder.toString():"";
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String Result = alienDictionary.isAlienSorted(new String[]{"ac","ab","bc","zc","zb"});
        String Result2 = alienDictionary.isAlienSorted(new String[]{"hello","leetcode"});
        System.out.println(Result);
        StringBuilder sb = new StringBuilder(Result).reverse();
        StringBuilder sb2 = new StringBuilder(Result2).reverse();
        System.out.println(sb);
        System.out.println(sb2);
    }
}
