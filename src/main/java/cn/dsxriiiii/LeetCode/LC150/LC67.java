package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/13 15:22
 * @Email: lihh53453@hundsun.com
 * @Description: 逢2进一 保存进位值
 */
public class LC67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for(int i = a.length() - 1,j = b.length() - 1;i >=0 || j >=0;i--,j--){
            int sum = temp;
            sum+= i >= 0 ? a.charAt(i) - '0' : 0;
            sum+= j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum%2);
            temp = sum / 2;
        }
        sb.append(temp == 1 ? "1":"");
        return sb.reverse().toString();
    }
}
