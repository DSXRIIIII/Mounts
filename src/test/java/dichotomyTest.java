public class dichotomyTest {
    public static int dichotomy(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(arr[middle] == target) {
                return middle;
            }
            if(arr[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int result = dichotomy(arr,3);
        System.out.println(result);
    }
}
