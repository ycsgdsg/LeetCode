package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/11/24.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String s = l.longestPalindrome("adfdaadffgaabbccbbaadfgrysddd");
//        String s = l.longestPalindrome("aabccbaa");
//        String s = l.longestPalindrome("aa");
//        String s = l.longestPalindrome("ab");
//        String s = l.longestPalindrome("aba");
//        String s = l.longestPalindrome("a");
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int left = 0, right = s.length() - 1, maxLength = 0, lowIndex = -1, highIndex = 1;
        while (left < right) {
            int low = left;
            int high = left;
            while (low >= 0 && high <= right && s.charAt(low) == s.charAt(high)) {
                low --;
                high ++;
            }
            if (maxLength < high - low) {
                maxLength = high - low;
                lowIndex = low;
                highIndex = high;
            }
            low = left;
            high = left + 1;
            while (low >= 0 && high <= right && s.charAt(low) == s.charAt(high)) {
                low --;
                high ++;
            }
            if (maxLength < high - low) {
                maxLength = high - low;
                lowIndex = low;
                highIndex = high;
            }
            left ++;
        }


        return s.substring(lowIndex + 1, highIndex);

    }
}
