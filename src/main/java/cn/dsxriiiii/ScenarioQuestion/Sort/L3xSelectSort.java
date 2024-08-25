package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/22 10:52
 * @Description: 选择排序
 * 每一次都可以确定最小值/最大值
 * i负责确认交换的位置 j确认最小/大值的坐标位置
 * 最后交换位置即可
 */
public class L3xSelectSort {
    public static void selectionSort(int[] arr) {
        // 外层循环，控制已排序部分的边界，i 从 0 到数组长度减 1，每一轮确定一个最小元素并放在正确位置
        for (int i = 0; i <= arr.length - 1; i++) {
            // 假设当前索引 i 对应的元素为最小元素，记录其索引为 min
            int min = i;
            // 内层循环，从 i + 1 开始遍历未排序部分，寻找最小元素
            for (int j = i + 1; j <= arr.length - 1; j++) {
                // 如果当前遍历到的元素比已假设的最小元素小
                if(arr[j] < arr[min]){
                    // 更新最小元素的索引为 j
                    min = j;
                }
            }
            // 将找到的最小元素与当前未排序部分的第一个元素（即索引为 i 的元素）交换位置
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
