package com.chaoyuan.LeetCode.solution;

/**
 * MinCostClimbingStairs.
 *
 * @author: chaoyuan
 * @since: 2025/11/8 17:11
 * @description: MinCostClimbingStairs
 */

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        if (cost.length == 1) return 0;

        dp[cost.length - 1] = cost[cost.length - 1];
        dp[cost.length - 2] = cost[cost.length - 2];
        for (int i = cost.length - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
