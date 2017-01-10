package com.chaoyuan.LeetCode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chaoyuan on 1/10/2017.
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int len = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j*len, i + j*len + len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        List<Integer> result = test.findSubstring("barfoothefoobarman", new String[] {"bar", "foo"});
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
