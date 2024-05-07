package WeBankTest;
import java.util.*;

public class Main {
    static int[][] mofang = {{1,2,3},{4,5,6},{7,8,9}};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] values = new int[n];
        for(int i = 0; i < n;i++){
            values[i] = scan.nextInt();
            if(values[i] == 1){
                //1 2 3 -> 2 3 1 操作values[0][0,1,2]
                int temp = mofang[0][2];
                mofang[0][2] = mofang[0][1];
                mofang[0][1] = mofang[0][0];
                mofang[0][0] = temp;
            }
            if(values[i] == 2){
                // 2 3 1 操作values[1][0,1,2]
                int temp = mofang[1][2];
                mofang[1][2] = mofang[1][1];
                mofang[1][1] = mofang[1][0];
                mofang[1][0] = temp;
            }
            if(values[i] == 3){
                // 2 3 1 操作values[2][0,1,2]
                int temp = mofang[2][2];
                mofang[2][2] = mofang[2][1];
                mofang[2][1] = mofang[2][0];
                mofang[2][0] = temp;
            }
            if(values[i] == 4){
                // 2 3 1 操作values[0,1,2][0]
                int temp = mofang[0][0];
                mofang[0][0] = mofang[1][0];
                mofang[1][0] = mofang[2][0];
                mofang[2][0] = temp;
            }
            if(values[i] == 5){
                // 2 5 8 -> 5 8 2 操作values[0,1,2][1]
                int temp = mofang[0][1];
                mofang[0][1] = mofang[1][1];
                mofang[1][1] = mofang[2][1];
                mofang[2][1] = temp;
            }
            if(values[i] == 6){
                // 2 3 1 操作values[0,1,2][2]
                int temp = mofang[0][2];
                mofang[0][2] = mofang[1][2];
                mofang[1][2] = mofang[2][2];
                mofang[2][2] = temp;
            }
        }
        for(int[] i:mofang){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}
