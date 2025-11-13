package com.chaoyuan.LeetCode.solution;

/**
 * LongestPalindromeSubseq.
 *
 * @author YC
 * @date 2025/11/12 17:12
 * @description LongestPalindromeSubseq
 */

/**
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromeSubString {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            char c1 = s.charAt(i);
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][length-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        LongestPalindromeSubString solution = new LongestPalindromeSubString();
        System.out.println(solution.longestPalindromeSubseq(s));
    }
}
