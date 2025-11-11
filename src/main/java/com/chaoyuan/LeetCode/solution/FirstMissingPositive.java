package com.chaoyuan.LeetCode.solution;

/**
 * FirstMissingPositive.
 *
 * @author: chaoyuan
 * @since: 2025/11/11 10:37
 * @description: FirstMissingPositive
 */

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num <= length && num > 0)
                nums[num - 1] = -1 * nums[num - 1];

        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return length + 1;

    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        FirstMissingPositive solution = new FirstMissingPositive();
        System.out.println(solution.firstMissingPositive(nums));
    }


}
