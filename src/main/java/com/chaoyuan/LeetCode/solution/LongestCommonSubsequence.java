package com.chaoyuan.LeetCode.solution;

/**
 * LongestCommonSubsequence.
 *
 * @author YC
 * @date 2025/11/13 14:36
 * @description LongestCommonSubsequence
 */

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}
