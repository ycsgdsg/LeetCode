package com.chaoyuan.LeetCode.solution;

import java.util.*;

/**
 * Created by ycsgd on 2016/11/19.
 */

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
public class ThreeSums {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2) {
            if(nums[i] > 0) break;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if(sum <= 0) while(nums[j] == nums[++j] && j < k);
                if(sum >= 0) while(nums[k--] == nums[k] && j < k);
            }
            while(nums[i] == nums[++i] && i < nums.length - 2);
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSums threeSums = new ThreeSums();
        List<List<Integer>> result = threeSums.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
