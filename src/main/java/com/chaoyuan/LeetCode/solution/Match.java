package com.chaoyuan.LeetCode.solution;

/**
 * Created by yc on 2015/12/13.
 */
public class Match {

    public static void main(String[] args) {
        Match l = new Match();
        boolean b;
        b = l.isMatch("aa","a");
        b = l.isMatch("aa","aa");
        b = l.isMatch("aaab","a*b");
        b = l.isMatch("aaaa","a*a");
        b = l.isMatch("aa","a.");
    }


    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s == null || p == null) return false;
        return isMatch(s, 0, p, 0);
    }

    public boolean isMatch(String s, int idx1, String p, int idx2) {
        if (s.length() == idx1 && p.length() == idx2) return true;
        if (p.length() == idx2) return false;
        if (s.length() == idx1) {
            if (idx2 + 1 >= p.length() || p.charAt(idx2 + 1) != '*') {
                return false;
            }
            return isMatch(s, idx1, p, idx2 + 2);
        }

        if (idx2 + 1 <= p.length() - 1 && p.charAt(idx2 + 1) == '*') {
            if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '.') {
                return isMatch(s, idx1 + 1, p, idx2) || isMatch(s, idx1, p, idx2 + 2);
            }
            return isMatch(s, idx1, p, idx2 + 2);
        } else if (p.charAt(idx2) == '.') {
            return isMatch(s, idx1 + 1, p, idx2 + 1);
        } else {
            return p.charAt(idx2) == s.charAt(idx1) && isMatch(s, idx1 + 1, p, idx2 + 1);
        }
    }
}

