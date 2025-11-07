package com.chaoyuan.LeetCode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoyuan on 11/28/2016.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        gen(res, "", n, n);
        return res;
    }

    private void gen(List<String> res, String present, int left, int right) {
        if (right == 0) {
            res.add(present);
        }
        if (left > 0) {
            gen(res, present + "(", left - 1, right);
        }
        if (right > left) {
            gen(res, present + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
