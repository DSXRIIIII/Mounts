package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/6/17 9:55
 * @Email: lihh53453@hundsun.com
 * @Description: 最小覆盖子串
 * 思路：滑动窗口
 *      1.维护两个数组保存128位(包含大小写)
 *      2.包含函数 判断s中所有的字符数量比t的所有字符数量多
 *      3.右移条件：走到s串的结尾
 *      4.左移条件：使用包含函数 不断左指针右移 并且在数组中减少字符--;
 *      5.此时左右指针维护的最小字串长度判断并且不断更新
 */
public class LC76 {
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s,t));
    }
    public static String minWindow(String s, String t) {
        char[] charArray = s.toCharArray();
        int nowLeft = -1;
        int nowRight = s.length();
        int left = 0;
        int[] arrT = new int[128];
        int[] arrS = new int[128];
        for(char c : t.toCharArray()){
            arrT[c]++;
        }
        for (int right = 0; right < s.length(); right++) {
            arrS[charArray[right]]++;
            while(isCover(arrS,arrT)){
                if(right - left < nowRight - nowLeft){
                    nowRight = right;
                    nowLeft = left;
                }
                arrS[charArray[left++]]--;
            }
        }
        return nowLeft < 0 ? "" : s.substring(nowLeft,nowRight+1);
    }

    private static boolean isCover(int[] s, int[] t) {
        for(int i = 'A';i <= 'Z';i++){
            if(s[i] < t[i]){
                return false;
            }
        }
        for(int i = 'a';i <= 'z';i++){
            if(s[i] < t[i]){
                return false;
            }
        }
        return true;
    }
}
