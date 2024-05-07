import java.util.Scanner;

public class Daozei {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] value = new int[n + 1];
        int sum = 0;
        for(int i = 1; i <= n;i++){
            value[i] = scan.nextInt();
            sum += value[i];
            scan.nextLine();
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];
        if(sum % 2 == 1){
            System.out.print("No");
            return;
        }
        for(int i = 1; i <=n;i++){
            for(int j = target; j >= value[i];j--){
                dp[j] = Math.max(dp[j],dp[j - value[i]]+ value[i]);
            }
        }
        if(dp[target] == target){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
        scan.close();
    }
}
