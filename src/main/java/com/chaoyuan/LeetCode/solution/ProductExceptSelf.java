package com.chaoyuan.LeetCode.solution;

/**
 * ProductExceptSelf.
 *
 * @author: chaoyuan
 * @since: 2025/11/11 10:30
 * @description: ProductExceptSelf
 */

import com.chaoyuan.LeetCode.util.ListUtils;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    public Integer[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i];
        }
        Integer[] result = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        ProductExceptSelf solution = new ProductExceptSelf();
        ListUtils.print(solution.productExceptSelf(nums));
    }
}
