package cn.dsxriiiii.ScenarioQuestion.Sort;

/**
 * @Author DSXRIIIII
 * @Project mounts
 * @Package cn.dsxriiiii.ScenarioQuestion.Sort
 * @Date 2024/8/22 9:51
 * @Description: 归并排序
 * 1.为什么每一次k都是从0开始 因为每次arr都是一个切片
 * 2.栈溢出的情况 当数组长度为1的时候没有返回就会一直递归导致栈溢出
 */
public class L3xMergeSort {
    private static void MergeSort(int[] arr){
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
//        for (int i = 0; i < mid; i++) {
//            left[i] = arr[i];
//        }
        //等价于下面这行代码
        System.arraycopy(arr, 0, left, 0, mid);
        for (int i = mid ; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        MergeSort(left);
        MergeSort(right);
        Merge(arr,left,right);
    }

    private static void Merge(int[] arr, int[] left, int[] right) {
        // i 是左子数组的索引
        int i = 0;
        // k 是合并后数组 arr 的索引
        int k = 0;
        // j 是右子数组的索引
        int j = 0;

        // 当左子数组和右子数组都还有元素未处理时
        while (i < left.length && j < right.length) {
            // 如果左子数组当前元素小于右子数组当前元素
            if (left[i] < right[j]) {
                // 将左子数组当前元素放入合并后的数组 arr，并移动左子数组和合并后数组的索引
                arr[k++] = left[i++];
            } else {
                // 将右子数组当前元素放入合并后的数组 arr，并移动右子数组和合并后数组的索引
                arr[k++] = right[j++];
            }
        }

        // 当左子数组还有剩余元素时
        while (i < left.length) {
            // 将左子数组剩余元素依次放入合并后的数组 arr，并移动左子数组和合并后数组的索引
            arr[k++] = left[i++];
        }

        // 当右子数组还有剩余元素时
        while (j < right.length) {
            // 将右子数组剩余元素依次放入合并后的数组 arr，并移动右子数组和合并后数组的索引
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        MergeSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
