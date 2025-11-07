package com.chaoyuan.LeetCode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yc on 2015/12/5.
 */
public class StringToInteger {

    public static void main(String[] args) {
        StringToInteger sti = new StringToInteger();
        int i = sti.myAtoi("18446744073709551617");
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char[] chars = str.trim().toCharArray();
        Long result = 0L;

        boolean isNegative = false;
        if (chars[0] == '-') {
            isNegative = true;
            chars[0] = '0';
        } else if (chars[0] == '+') {
            chars[0] = '0';
        }

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            Long preResult = result;
            if (c < '0' || c > '9') {
                break;
            }
            if (isNegative) {
                result = result * 10 - (c - '0');
                if (result > preResult) {
                    return Integer.MIN_VALUE;
                }
            } else {
                result = result * 10 + (c - '0');
                if (result < preResult) {
                    return Integer.MAX_VALUE;
                }
            }
        }

        if (result > Integer.MAX_VALUE ) {
            return  isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return  isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }

        return result.intValue();
    }

}
