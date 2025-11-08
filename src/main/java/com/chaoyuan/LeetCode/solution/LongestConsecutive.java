package com.chaoyuan.LeetCode.solution;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LongestConsecutive.
 *
 * @author: chaoyuan
 * @since: 2025/11/7 19:24
 * @description: LongestConsecutive
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int temp = num;
                int longest = 1;
                while (set.contains(++temp)) {
                    longest++;
                }
                result = Math.max(result, longest);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive solution = new LongestConsecutive();
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}
