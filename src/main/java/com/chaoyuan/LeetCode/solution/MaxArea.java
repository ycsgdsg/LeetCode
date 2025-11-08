package com.chaoyuan.LeetCode.solution;

/**
 * MaxArea.
 *
 * @author: chaoyuan
 * @since: 2025/11/8 15:20
 * @description: MaxArea
 */

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            result = Math.max(result, temp);
            if (height[i] < height[j]) i++;
            else j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        MaxArea solution = new MaxArea();
        int result = solution.maxArea(nums);
        System.out.println(result);
    }
}
