import java.util.Arrays;
import java.util.Scanner;
public class StairProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int break_num = scan.nextInt();
        int mod = 1000000007;
        scan.nextLine();
        int[] arr  = new int[(int)(1e5 + 10)];
        boolean[] index = new boolean[(int)(1e5 + 10)];
        for(int i = 0;i < break_num;i++){
            arr[i] = scan.nextInt();
            index[arr[i]] = true;
        }
        int[] dp = new int[(int)(1e5 + 10)];
        dp[0] = 1;
        dp[1] = index[1] ? 0 : 1;
        for(int i = 2;i <=n;i++){
            if(index[i]) {
                continue;
            }else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            }
        }
        System.out.print(dp[n]);
        System.out.println(Arrays.toString(dp));
        scan.close();
    }

}
