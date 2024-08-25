package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/21 17:36
 * @Description: 实现快速排序
 * 1.按照基准数排序
 * 2.如下的例子是对第一个数为基准
 * 3.小于基准数的值放到左边 大于基准数的值放到右边
 */
public class L3xQuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int location = partition(arr,low,high);
            quickSort(arr,low,location - 1);
            quickSort(arr,location + 1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // 将 low 位置的元素作为划分的基准值 loc
        int loc = arr[low];
        // cur 表示从 low + 1 开始，第一个大于等于基准值的元素位置
        int cur = low + 1;
        // 遍历从 low + 1 到 high 的所有元素
        for (int i = low + 1; i <= high; i++) {
            // 如果当前元素小于基准值
            if(arr[i] < loc){
                // 将当前元素与 cur 位置的元素交换，使得小于基准值的元素都在 cur 左边
                swap(arr,i,cur);
                // cur 向右移动一位，表示下一个大于等于基准值的位置
                cur++;
            }
        }
        // 将基准值与 cur - 1 位置的元素交换，使得基准值处于正确的位置
        swap(arr,cur - 1,low);
        // 返回基准值的最终位置
        return cur - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
