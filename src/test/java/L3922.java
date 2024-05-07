import java.util.Scanner;

public class L3922 {
    static int people_num;
    static int plan_sum;
    static int org_energy;
    static int[] power = new int[people_num + 1];
    static int[] pro_power = new int[plan_sum + 1];
    static int[] cost_energy = new int[plan_sum + 1];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //人数 计划数 初始精力
        //2 2 4
        // 1 1  每个士兵的初始力量值
        // 2 3  每种力量提升值
        // 2 3  每种精力消耗值
        people_num = scan.nextInt();
        plan_sum = scan.nextInt();
        org_energy = scan.nextInt();

        for(int i = 1;i <= people_num;i++){
            power[i] = scan.nextInt();
        }
        for(int i = 1;i <= plan_sum;i++){
            pro_power[i] = scan.nextInt();
        }
        for(int i = 1;i <= plan_sum;i++){
            cost_energy[i] = scan.nextInt();
        }
//        for(int i = 1; i < people_num;i++){
//            for(int j = )
//        }

        


        scan.close();
    }
}
