package cn.dsxriiiii.LeetCode.LC150;

public class LC45 {
    public static int jump(int[] nums) {
        int len = nums.length;
        int maxIndex = 0;
        int Border = 0;
        int res = 0;
        for(int i = 0; i < len;i++){
            /*
             * 此处i < len - 1
             * 在遍历数组时，我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
             * 否则就无法跳到最后一个位置了。如果访问最后一个元素，在边界正好为最后一个位置的情况下
             * 我们会增加一次「不必要的跳跃次数」 如何理解呢
             * 假如数组int[] nums = {2,3,1,1,4}; 此时i走到了最后的位置 i = 4；此时边界border = 4；
             * 此时会再一次走到i == border判断条件 此时res++ 就多余了
             */
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if(i == Border){
                Border = maxIndex;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
