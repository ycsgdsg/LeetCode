package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FindAnagrams.
 *
 * @author: chaoyuan
 * @since: 2025/11/9 14:32
 * @description: FindAnagrams
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() >= p.length()) {
            int[] charS = new int[26];
            int[] charP = new int[26];
            for (int i = 0; i < p.length(); i++) {
                ++charS[s.charAt(i) - 'a'];
                ++charP[p.charAt(i) - 'a'];
            }
            if (Arrays.equals(charS, charP)) {
                result.add(0);
            }
            for (int i = 0; i < s.length() - p.length(); ++i) {
                --charS[s.charAt(i) - 'a'];
                ++charS[s.charAt(i + p.length()) - 'a'];
                if (Arrays.equals(charS, charP)) {
                    result.add(i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababaab";
        String p = "ab";
        FindAnagrams solution = new FindAnagrams();
        ListUtils.print(solution.findAnagrams(s, p));
    }
}
