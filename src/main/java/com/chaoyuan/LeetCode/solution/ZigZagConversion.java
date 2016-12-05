package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/12/3.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        String s = conversion.convert("PAYPALISHIRING", 7);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int numLines = s.length();

        char[][] chars = new char[numRows][numLines];
        int index = 0;
        for (int j = 0; j < numLines; j ++) {
            int i = 0;
            for (; i < numRows && index < s.length(); i ++) {
                chars[i][j] = s.charAt(index);
                index++;
            }
            j ++;
            if (j > numLines - 1) {
                break;
            }
            if (numRows > 2) {
                for (i = numRows - 1; i >= 0 && index < s.length(); i--) {
                    if (j % 2 == 1) {
                        if (i == 0) {
                            break;
                        }
                        if (i == numRows - 1) {
                            i--;
                        }
                    }
                    chars[i][j] = s.charAt(index);
                    index++;
                }
            } else {
                for (i = 0; i < numRows && index < s.length(); i ++) {
                    chars[i][j] = s.charAt(index);
                    index++;
                }
            }

        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < numLines; j ++) {
                if (chars[i][j] != '\u0000') {
                    sb.append(chars[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
