package com.chaoyuan.LeetCode.solution;

/**
 * LengthOfLIS.
 *
 * @author YC
 * @date 2025/11/13 11:29
 * @description LengthOfLIS
 */

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的个数。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int maxLen = 0, res = 0;
        int[] dp = new int[nums.length];
        int[] dp2 = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            dp2[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        dp2[i] = dp2[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dp2[i] += dp2[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                res = dp2[i];
            } else if (dp[i] == maxLen) {
                res += dp2[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,6,7};
        FindNumberOfLIS solution = new FindNumberOfLIS();
        System.out.println(solution.findNumberOfLIS(nums));
    }
}
