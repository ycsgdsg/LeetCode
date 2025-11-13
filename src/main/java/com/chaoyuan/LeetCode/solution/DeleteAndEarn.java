package com.chaoyuan.LeetCode.solution;

/**
 * DeleteAndEarn.
 *
 * @author YC
 * @date 2025/11/11 15:20
 * @description DeleteAndEarn
 */

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int[] sums = new int[max + 1];
        for (int num : nums) {
            sums[num] += num;
        }
        return rob(sums);
    }

    private int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        int[] dp = new int[2];
        // 0表示不拿，1表示拿
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = dp[1];
            dp[1] = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = temp;
        }
        return dp[1];

    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        DeleteAndEarn solution = new DeleteAndEarn();
        System.out.println(solution.deleteAndEarn(nums));
    }
}
