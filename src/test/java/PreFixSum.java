import java.util.Arrays;

public class PreFixSum {
    public static int[] calculatePreFixSum(int[] arr){
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for(int i = 1; i < n;i++){
            preSum[i] = preSum[i-1] + arr[i];
        }
        return preSum;
    }
    public static int getRangeSum(int[] preSum,int left,int right){
        if(left == 0){
            return preSum[right];
        }else{
            return preSum[right] - preSum[left - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] getPreSum = calculatePreFixSum(arr);
        int result = getRangeSum(getPreSum,0,2);
        System.out.println(result);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(getPreSum));
    }
}
