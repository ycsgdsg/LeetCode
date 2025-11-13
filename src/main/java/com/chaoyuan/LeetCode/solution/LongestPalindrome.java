package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/11/24.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
//        String s = l.longestPalindrome("adfdaadffgaabbccbbaadfgrysddd");
//        String s = l.longestPalindrome("aabccbaa");
//        String s = l.longestPalindrome("aa");
//        String s = l.longestPalindrome("ab");
//        String s = l.longestPalindrome("aba");
//        String s = l.longestPalindrome("a");
        String s = l.longestPalindrome("aaaa");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        Boolean[][] dp = new Boolean[length][length];
        char[] chars = s.toCharArray();
        int max = 1, begin = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = deepDiv(chars, dp, i, j);
                    }
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    private Boolean deepDiv(char[] chars, Boolean[][] booleans, int low, int high) {
        if (low >= high) {
            booleans[low][high] = true;
            return true;
        } else if (chars[low] != chars[high]) {
            booleans[low][high] = false;
            return false;
        } else if (booleans[low+1][high-1] == null) {
            booleans[low+1][high-1] = deepDiv(chars, booleans, low+1, high-1);
        }
        return booleans[low+1][high-1];
    }

//    public String longestPalindrome(String s) {
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//
//        int left = 0, right = s.length() - 1, maxLength = 0, lowIndex = -1, highIndex = 1;
//        while (left < right) {
//            int low = left;
//            int high = left;
//            while (low >= 0 && high <= right && s.charAt(low) == s.charAt(high)) {
//                low --;
//                high ++;
//            }
//            if (maxLength < high - low) {
//                maxLength = high - low;
//                lowIndex = low;
//                highIndex = high;
//            }
//            low = left;
//            high = left + 1;
//            while (low >= 0 && high <= right && s.charAt(low) == s.charAt(high)) {
//                low --;
//                high ++;
//            }
//            if (maxLength < high - low) {
//                maxLength = high - low;
//                lowIndex = low;
//                highIndex = high;
//            }
//            left ++;
//        }
//
//
//        return s.substring(lowIndex + 1, highIndex);
//
//    }
}
