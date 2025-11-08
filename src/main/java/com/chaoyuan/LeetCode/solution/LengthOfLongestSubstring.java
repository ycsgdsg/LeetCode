package com.chaoyuan.LeetCode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yc on 2015/11/16.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        l.lengthOfLongestSubstring("abcabcd");
        l.lengthOfLongestSubstring("abba");
        l.lengthOfLongestSubstring("eee");
        l.lengthOfLongestSubstring("abb");
        l.lengthOfLongestSubstring(" ");
        l.lengthOfLongestSubstring("au");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int index = 0, start = 0, length = 0;
        for (; index < chars.length; index++) {
            char c = chars[index];
            if (!map.containsKey(c))  {
                map.put(c, index);
            } else {
                start = Math.max(start, map.get(c) + 1);
                map.put(c, index);
            }
            length = Math.max(length, index - start + 1);
        }
        return length;
    }
}
