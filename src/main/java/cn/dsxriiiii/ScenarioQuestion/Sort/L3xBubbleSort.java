package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/22 10:30
 * @Description: 冒泡排序
 * 每一次的遍历都会确定数组的【最后一位】的位置
 * j的区间范围为[0,n - 1] -> [0,n - 2] -> [0,n - 3]
 */
public class L3xBubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
