
import java.util.Arrays;

public class MaxHappiness {

    public static int maxHappiness(int[] happiness, int k) {
        Arrays.sort(happiness);
        int sum = 0;

        for (int i = happiness.length - 1;i >= 0 && k > 0; i--) {
            k--;
            sum += happiness[i];
            happiness[i] = 0;
            for(int j = 0;j < i;j++){
                happiness[j] = Math.max(0, happiness[j] - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 1; // 这里 k 的值是未知的，假设为 3
        System.out.println(maxHappiness(happiness, k));  // 输出: 52
    }



}

