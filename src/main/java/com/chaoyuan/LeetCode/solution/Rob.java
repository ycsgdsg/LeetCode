package com.chaoyuan.LeetCode.solution;

/**
 * Rob.
 * @author YC
 * @date 2025/11/11 14:48
 * @description Rob
 */
public class Rob {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            // [i][0]表示不拿当前, [i][1]表示要拿当前
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        Rob solution = new Rob();
        System.out.println(solution.rob(nums));
    }
}
