package com.chaoyuan.LeetCode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yc on 2015/11/16.
 */

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcd"));
        System.out.println(l.lengthOfLongestSubstring("abba"));
        System.out.println(l.lengthOfLongestSubstring("eee"));
        System.out.println(l.lengthOfLongestSubstring("abb"));
        System.out.println(l.lengthOfLongestSubstring(" "));
        System.out.println(l.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) return 0;
        if (length == 1) return 1;
        int[] dp = new int[length];
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        dp[0] = 1;
        charMap.put(chars[0], 0);
        for (int i = 1; i < length; i++) {
            char c = chars[i];
            if (!charMap.containsKey(c)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                int start = charMap.get(c);
                dp[i] = Math.min(i - start, dp[i - 1] + 1);
            }
            charMap.put(c, i);
        }
        return Arrays.stream(dp).max().orElse(1);
    }

//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.isEmpty()) return 0;
//        char[] chars = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        int index = 0, start = 0, length = 0;
//        for (; index < chars.length; index++) {
//            char c = chars[index];
//            if (!map.containsKey(c))  {
//                map.put(c, index);
//            } else {
//                start = Math.max(start, map.get(c) + 1);
//                map.put(c, index);
//            }
//            length = Math.max(length, index - start + 1);
//        }
//        return length;
//    }
}
