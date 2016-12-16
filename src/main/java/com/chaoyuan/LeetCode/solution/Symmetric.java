package com.chaoyuan.LeetCode.solution; /**
 * Created by yc on 2015/10/31.
 */

import java.util.*;

public class Symmetric {

    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int lineCount = cin.nextInt();
        for (int index = 0; index < lineCount; index ++) {
            String context = cin.next();
            System.out.println(isSymmetric(context));

        }
    }

    private static int isSymmetric (String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int result = 0;
        for (char c : chars) {
            boolean isFound = false;
            Stack<Character> stack_1 = new Stack<Character>();
            if (c == '[' || c == '(') {
                stack.push(c);
                isFound = true;
            } else if (c == ']') {
                while (!stack.isEmpty()) {
                    char right = stack.pop();
                    if ( right != '[') {
                        stack_1.push(right);
                    } else {
                        isFound = true;
                        break;
                    }
                }

            } else if (c == ')')  {
                while (!stack.isEmpty()) {
                    char right = stack.pop();
                    if ( right != '(') {
                        stack_1.push(right);
                    } else {
                        isFound = true;
                        break;
                    }
                }
            }
            if (!isFound) {
                result++;
            } else {
                result = result + stack_1.size();
            }
        }
        return result + stack.size();
    }

    private static char[] insertChar( char[] chars, char c, int index) {
        char[] result = new char[chars.length + 1];
        for (int i = 0; i < index; i++) {
            result[i] = chars[i];
        }
        result[index] = c;
        for (int i = index + 1; i < result.length; i++) {
            result[i] = chars[i-1];
        }
        return result;
    }
}

