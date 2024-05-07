import java.util.Scanner;

public class gift {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxWeight = scan.nextInt();
        int n = scan.nextInt();
        int[] value = new int[n + 1];
        for(int i = 1;i < n;i++){
            value[i] = scan.nextInt();
        }
        int[] dp = new int[maxWeight + 1];
        for(int i = 1; i <= n; i++){
            for(int j = maxWeight;j >= value[i];j--){
                dp[j] = Math.max(dp[j],dp[j - value[i]] + value[i]);
//                res = Math.min(res,res-dp[j]);
            }
        }
        int res = maxWeight - dp[maxWeight];
        System.out.println(res);
        scan.close();
    }
}
