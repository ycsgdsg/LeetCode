package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * NextPermutation.
 *
 * @author YC
 * @date 2025/11/27 16:04
 * @description NextPermutation
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1;
        boolean swapped = false;
        for (; i > 0; i--) {
            if (nums[i] < nums[i - 1]) continue;
            for (int j = n - 1; j >= i; j--) {
                if (nums[j] <= nums[i - 1])
                    continue;
                swap(nums, i - 1, j);
                swapped = true;
                break;
            }
            if (swapped) {
                break;
            }
        }
        reverse(nums, i);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1};
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
