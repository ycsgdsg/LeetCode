package com.chaoyuan.LeetCode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yc on 2015/11/7.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.getOrDefault(nums[i], new ArrayList<>()).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            List<Integer> list = map.getOrDefault(sub, null);
            if (list == null) continue;
            for (Integer r : list) {
                if (i != r) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = r;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.print(ts.twoSum(new int[]{2,3,2,3,3,4,4}, 6));
    }

    public void print(int[] numbers) {
        if (numbers != null) {
            for (int number : numbers) {
                System.out.println(number);
            }
        }
    }
}
