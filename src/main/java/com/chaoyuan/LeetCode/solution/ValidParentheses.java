package com.chaoyuan.LeetCode.solution;

import java.util.Stack;

/**
 * Created by ycsgd on 2016/11/27.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character c : chars) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                continue;
            } else {// || c == ']' || c == ')') {
                Character left;
                switch (c) {
                    case '}':
                        if (!stack.isEmpty()) {
                            left = stack.pop();
                            if (left != '{')
                                return false;
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty()) {
                            left = stack.pop();
                            if (left != '[')
                                return false;
                        } else {
                            return false;
                        }
                        break;
                    case ')':
                        if (!stack.isEmpty()) {
                            left = stack.pop();
                            if (left != '(')
                                return false;
                        } else {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
     }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        validParentheses.isValid("{}");
    }
}
