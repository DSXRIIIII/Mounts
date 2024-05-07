package WeBankTest;
import java.util.*;
public class Test3 {
    static boolean[] jug = new boolean[100];
    static Map<int[],Integer> map =new HashMap<>();
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[][] values = new int[n*(n-1)/2][3];
        for(int i = 0;i < n*(n-1)/2;i++){
            for(int j = 0;j < 3;j++){
                values[i][j] = scan.nextInt();
                jug[values[i][0]] = true;
                jug[values[i][1]] = true;
                map.put(new int[]{i, j},values[i][3]);
            }
        }
        for(int i = 1;i <= 100;i++){
            for(int j = i+1;j <= 100;j++){
                if (map.containsKey(new int[]{i, j}) && jug[i] && jug[j]){

                }
            }
        }
    }
}
