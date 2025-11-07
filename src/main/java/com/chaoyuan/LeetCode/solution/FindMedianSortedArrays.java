package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/11/13.
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {1,2,3,5,5,6,100};
        double d = f.findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = 0, index1 = 0, index2 = 0;
        int[] union = new int[nums1.length + nums2.length];

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                union[index++] = nums1[index1++];
            } else {
                union[index++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            union[index++] = nums1[index1++];
        }

        while (index2 < nums2.length) {
            union[index++] = nums2[index2++];
        }

        if (union.length % 2 == 0) {
            double num1 = union[(union.length - 1) / 2];
            double num2 = union[(union.length - 1) / 2 + 1];
            return (num1 + num2) / 2;
        } else {
            return union[(union.length - 1) / 2];
        }
    }
}
