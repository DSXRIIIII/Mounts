package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Description: note
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/5 17:18
 * @Email: lihh53453@hundsun.com
 **/
public class LC242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] c = new int[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(c[i] != 0){
                return false;
            }
        }
        return true;
    }
}
