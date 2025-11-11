package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListUtils;

/**
 * RotateNums.
 *
 * @author: chaoyuan
 * @since: 2025/11/11 09:56
 * @description: RotateNums
 */
public class RotateNums {
    public void rotate(Integer[] nums, int k) {
        int times = k % nums.length;
        swap(nums,0, nums.length - times - 1);
        swap(nums,nums.length - times, nums.length - 1);
        swap(nums,0, nums.length - 1);
    }

    private void swap(Integer[] nums, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            int temp= nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7};
        int k = 10;
        RotateNums solution = new RotateNums();
        solution.rotate(nums, k);
        ListUtils.print(nums);
    }
}
