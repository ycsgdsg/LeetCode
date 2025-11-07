package com.chaoyuan.LeetCode.solution;

import java.util.Arrays;

/**
 * Created by ycsgd on 2016/11/19.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new AssertionError();
        }
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int current = nums[i] + nums[i + 1] + nums[i + 2];
            if (countDistance(target, current) <= countDistance(target, result)) {
                result = current;
            }
        }
        return result;
    }

    private int countDistance(int num1, int num2) {
        if (num1 > num2) {
            return num1 - num2;
        } else {
            return num2 - num1;
        }
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int result = threeSumClosest.threeSumClosest(new int[] {-3,0,1,2}, 1);
    }
}
