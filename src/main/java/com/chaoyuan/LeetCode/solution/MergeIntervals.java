package com.chaoyuan.LeetCode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * MergeIntervals.
 *
 * @author: chaoyuan
 * @since: 2025/11/10 15:28
 * @description: MergeIntervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = result.get(result.size() - 1);
            int[] interval = intervals[i];
            if (current[1] < interval[0]) {
                result.add(interval);
            } else {
                result.remove(current);
                result.add(new int[]{current[0], Math.max(current[1], interval[1])});
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2},{3,4},{2,3}};
        MergeIntervals solution = new MergeIntervals();
        int[][] result = solution.merge(intervals);
    }
}
