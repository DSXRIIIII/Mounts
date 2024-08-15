package cn.dsxriiiii.LeetCode.LC150;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/12 17:04
 * @Email: lihh53453@hundsun.com
 * @Description: 搜索旋转排序数组
 * 二分查找
 * 左节点从0开始 右节点到n-1结束
 * 找到严格递增区间 nums[0] <= nums[mid]
 * 1.true:说明左区间为严格递增区间 3 4 5 6 7 1 2
 *      1.1.target在[0,mid]之间 right = mid - 1 缩小到左递增区间
 *      1.2 target在该区间内 left = mid + 1;
 * 2.false:说明右区间为严格递增区间 6 7 1 2 3 4 5
 *      2.1.target在[mid,n - 1]之间 left = mid + 1 缩小到右递增区间
 *      2.2 target在不该区间内 right = mid - 1;
 */
public class LC33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //选择一个有序数组进行处理
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
