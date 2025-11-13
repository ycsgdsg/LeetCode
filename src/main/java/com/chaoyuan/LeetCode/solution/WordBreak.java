package com.chaoyuan.LeetCode.solution;

/**
 * WordBreak.
 *
 * @author YC
 * @date 2025/11/12 16:28
 * @description WordBreak
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";
        WordBreak solution = new WordBreak();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
