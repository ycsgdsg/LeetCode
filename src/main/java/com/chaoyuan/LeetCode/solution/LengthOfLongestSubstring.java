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
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int index=0, low=0, length=0;
        for (; index<chars.length; index++) {
            char c = chars[index];
            if (!map.containsKey(c))  {
                map.put(c, index);
            } else {
                if (low < map.get(c) + 1) {
                    low = map.get(c) + 1;
                }
                map.put(c, index);
            }

            if (length < index - low + 1) {
                length = index - low + 1;
            }
        }

        if (length < index - low) {
            length = index - low;
        }

        return length;
    }
}
