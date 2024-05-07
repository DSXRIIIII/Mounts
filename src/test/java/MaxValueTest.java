import java.util.Arrays;

public class MaxValueTest {
    public static void main(String[] args) {
        int[] values = {1,2,3,4};
        System.out.println(Arrays.stream(values).max().orElse(-1));
    }
}
