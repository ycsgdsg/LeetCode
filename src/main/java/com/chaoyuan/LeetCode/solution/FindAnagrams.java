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
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (isAngram(sub, p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAngram(String s, String p) {
        if (s.length() != p.length()) return false;
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charP);
        for (int i = 0; i < s.length(); i++) {
            if (charS[i] != charP[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ababaab";
        String p = "ab";
        FindAnagrams solution = new FindAnagrams();
        ListUtils.print(solution.findAnagrams(s, p));
    }
}
