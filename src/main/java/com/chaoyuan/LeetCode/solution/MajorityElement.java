package com.chaoyuan.LeetCode.solution;

/**
 * MajorityElement.
 *
 * @author YC
 * @date 2025/11/27 15:55
 * @description MajorityElement
 */

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int winner = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (winner == nums[i]) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count = 1;
            } else {
                count--;
            }
        }
        return winner;
    }
}
