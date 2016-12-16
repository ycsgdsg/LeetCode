package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/12/5.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        int i = ri.reverse(1534236469);
    }

    public int reverse(int x)  {
        String s = String.valueOf(x);
        try {
            return Integer.valueOf(reverseString(s));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public String reverseString(String s) {
        if (s == null ||s.isEmpty()) {
            return "";
        }
        char[] chars = s.toCharArray();
        for (int low = 0, high = chars.length - 1; low < high; low++, high--) {
            if (low == 0 && chars[low] == '-') {
                low++;
            }
            swap(chars, low, high);
        }
        return String.valueOf(chars);
    }

    public void swap (char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }
}
