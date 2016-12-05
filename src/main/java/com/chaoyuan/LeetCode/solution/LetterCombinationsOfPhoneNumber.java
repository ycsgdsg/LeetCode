package com.chaoyuan.LeetCode.solution;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoyuan on 11/25/2016.
 */
public class LetterCombinationsOfPhoneNumber {
    private static Map<String, List<String>> numToCharMap = new HashMap<String, List<String>>();
    static {
        numToCharMap.put("0", new ArrayList<String>());
        numToCharMap.put("1", new ArrayList<String>());
        numToCharMap.put("2", Arrays.asList(new String[]{"a", "b", "c"}));
        numToCharMap.put("3", Arrays.asList(new String[]{"d", "e", "f"}));
        numToCharMap.put("4", Arrays.asList(new String[]{"g", "h", "i"}));
        numToCharMap.put("5", Arrays.asList(new String[]{"j", "k", "l"}));
        numToCharMap.put("6", Arrays.asList(new String[]{"m", "n", "o"}));
        numToCharMap.put("7", Arrays.asList(new String[]{"p", "q", "r", "s"}));
        numToCharMap.put("8", Arrays.asList(new String[]{"t", "u", "v"}));
        numToCharMap.put("9", Arrays.asList(new String[]{"w", "x", "y", "z"}));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<String>();
        }
        if (digits.length() == 1) {
            return numToCharMap.get(digits);
        }
        List<String> result = new ArrayList<String>();
        List<String> currentList = numToCharMap.get(digits.substring(0, 1));
        List<String> lastList = letterCombinations(digits.substring(1, digits.length()));
        for (String pre : currentList) {
            for (String end : lastList) {
                result.add(pre + end);
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
