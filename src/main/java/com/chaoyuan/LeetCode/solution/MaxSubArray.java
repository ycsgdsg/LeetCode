package com.chaoyuan.LeetCode.solution;

/**
 * MaxSubArray.
 *
 * @author: chaoyuan
 * @since: 2025/11/10 14:44
 * @description: MaxSubArray
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, -1, 4,5,-5,6};
        MaxSubArray solution = new MaxSubArray();
        System.out.println(solution.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum = sum + num;
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }
}
