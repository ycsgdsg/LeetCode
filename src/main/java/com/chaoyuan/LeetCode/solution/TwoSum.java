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
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int index = 0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                map.get(nums[index]).add(index + 1);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(index + 1);
                map.put(nums[index], list);
            }
        }

        for (int num : nums) {
            int sub = target - num;
            if (map.containsKey(sub)) {
                List<Integer> list1 = map.get(num);
                List<Integer> list2 = map.get(sub);
                if (sub == num) {
                    if (list1.size() > 1) {
                        result[0] = list1.get(0);
                        result[1] = list1.get(list1.size() - 1);
                    } else {
                        continue;
                    }
                } else {
                    result[0] = list1.get(0);
                    result[1] = list2.get(list2.size() - 1);
                }
                break;
            }
        }
        return result;
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
