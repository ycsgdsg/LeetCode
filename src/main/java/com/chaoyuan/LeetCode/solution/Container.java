package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2016/5/15.
 */
public class Container {

    public int maxArea(int[] height) {
        int max = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            int shorter = Math.min(height[l], height[r]);
            max = Math.max(max, shorter * (r - l));
            if (shorter == height[l]) {
                l ++;
            } else {
                r --;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Container c = new Container();
        int max = c.maxArea(new int[]{1, 2});
        System.out.println(max);
    }
}
