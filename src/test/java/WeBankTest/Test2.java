package WeBankTest;

public class Test2 {
    public static void main(String[] args) {
        int[][] mofang = {{1,2,3},{4,5,6},{7,8,9}};

        // 2 3 1 操作values[1][0,1,2]
        int temp = mofang[2][0];
        mofang[2][0] = mofang[2][1];
        mofang[2][1] = mofang[2][2];
        mofang[2][2] = temp;

        for(int[] i:mofang){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
