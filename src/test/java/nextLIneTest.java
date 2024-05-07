import java.util.Arrays;
import java.util.Scanner;

public class nextLIneTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num-- > 0) {
            int num_Storm = scan.nextInt();
            int chance = scan.nextInt();
            long[] arr = new long[num_Storm + 1];
            scan.nextLine();
            for(int i = 1; i <= num_Storm; i++) {
                arr[i] = scan.nextLong();
            }
            Arrays.sort(arr);
            long[] pre = new long[num_Storm + 1];
            for(int i = 1; i <= num_Storm; i++) {
                pre[i] = pre[i - 1] + arr[i];
            }
            long max = Long.MIN_VALUE;
            for(int i = 0; i <= chance; i++) {
                long res = pre[num_Storm - (chance - i)] - pre[2 * i];
                max = Math.max(max, res);
            }
            System.out.println(max);
        }
        scan.close();
    }
}
