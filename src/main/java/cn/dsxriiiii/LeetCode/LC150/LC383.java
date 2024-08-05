package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description: LC383 赎金信
 * @Author: DSXRIIIII
 * @CreateDate: 2024/5/24 17:02
 * @Email: lihh53453@hundsun.com
 *
 * 解题思路：字母数组++和--
 **/
public class LC383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] charArr = new int[26];
        for(char a : magazine.toCharArray()){
            charArr[a -'a']++;
        }
        for(char b : ransomNote.toCharArray()){
            --charArr[b - 'a'];
            if(charArr[b - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
