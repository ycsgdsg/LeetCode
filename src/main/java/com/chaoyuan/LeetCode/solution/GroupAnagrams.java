package com.chaoyuan.LeetCode.solution;

import java.util.*;

/**
 * GroupAnagrams.
 *
 * @author: chaoyuan
 * @since: 2025/11/7 17:12
 * @description: GroupAnagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = buildKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String buildKey(String str) {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) characters.add(str.charAt(i));
        Collections.sort(characters);
        return Arrays.toString(characters.toArray());
    }
}
