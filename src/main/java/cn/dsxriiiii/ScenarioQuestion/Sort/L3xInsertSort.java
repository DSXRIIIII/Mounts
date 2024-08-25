package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/22 11:17
 * @Description: 插入排序
 * 找到一个元素cur 找到比cur大的位置不断地往后排
 * 将cur插入到比他大的数的前面
 * arr[index] = arr[index - 1]; 将index所处位置比较大的元素往后移->index--
 * 最后将cur元素插入到index的位置
 */
public class L3xInsertSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // 遍历整个数组，从第一个元素开始认为是已排序部分，逐渐扩大已排序部分
        for (int i = 0; i < n; i++) {
            // 将当前要插入的元素保存到 cur
            int cur = arr[i];
            // index 用于标记当前要插入的位置
            int index = i;
            // 当 index 大于 0 且前一个位置的元素大于当前元素时，进行移动操作
            while (index > 0 && arr[index - 1] > cur) {
                // 将较大的元素向后移动一位
                arr[index] = arr[index - 1];
                // index 递减，继续向前比较
                index--;
            }
            // 找到合适位置后，将当前元素插入
            arr[index] = cur;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        insertionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
