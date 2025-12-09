package com.chaoyuan.LeetCode.solution;

/**
 * SingleNumber.
 *
 * @author YC
 * @date 2025/11/27 12:45
 * @description SingleNumber
 */

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,2,4};
        SingleNumber solution = new SingleNumber();
        System.out.println(solution.singleNumber(nums));
    }
}
