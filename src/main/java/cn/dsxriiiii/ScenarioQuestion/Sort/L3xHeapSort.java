package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/22 11:53
 * @Description: 堆排序
 * 每一次处理大顶堆确定最大的元素已经浮现到堆的根结点
 * 把根结点与最后一位交换 这样最大值就会排序到最后一位
 */
public class L3xHeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个提取最大元素并重新调整堆
        for (int i = n - 1; i >= 0; i--) {
            // 将最大元素（堆顶）与当前未排序部分的最后一个元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 对交换后的堆进行调整
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        // 初始化当前节点 i 为最大元素的索引
        int largest = i;
        // 左子节点索引
        int left = 2 * i + 1;
        // 右子节点索引
        int right = 2 * i + 2;
        // 如果左子节点存在且大于当前最大元素
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // 如果右子节点存在且大于当前最大元素
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // 如果最大元素不是当前节点 i，则交换并递归调整
        if (largest!= i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
