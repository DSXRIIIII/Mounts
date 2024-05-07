import java.math.BigInteger;
import java.util.Scanner;

public class Number9Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        long x = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i)); // 获取字符对应的数字值
            x = x * 10 + d;
            x %= 9;
            if (x == 0) ans++;
        }
        System.out.println(ans);
        scanner.close();
    }
}
