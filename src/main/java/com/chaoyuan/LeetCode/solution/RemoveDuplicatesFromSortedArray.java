package com.chaoyuan.LeetCode.solution;

/**
 * Created by ycsgd on 2016/12/17.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int j=0;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[j]) {
                nums[++j]=nums[i];
            }
        return ++j;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
//        int[] nums = {1,2,3};
        int[] nums = {1,1,2,2,3,3};
        int length = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        for (int i = 0; i < length; i ++) {
            System.out.println(nums[i]);
        }
    }
}
