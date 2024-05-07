package cn.dsxriiiii.LeetCode.LC150;

/**
 * 题目：盛最多水的容器
 * 算法：双指针
 * 思路：双指针前后两方向移动,每次移动时记录此时面积并且保存最大的面积值
 * 技巧：移动时 容器的最大值取决于边界的最小值 area = min(left,right) * (right - left);
 *      无论长边怎么移动 都取决于短边的长度 所以移动时要移动短边
 */
public class LC11 {
    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while(left < right){
            res = Math.max(res,Math.min(height[left],height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
