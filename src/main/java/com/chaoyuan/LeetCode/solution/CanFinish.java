package com.chaoyuan.LeetCode.solution;

/**
 * CanFinish.
 *
 * @author YC
 * @date 2025/11/28 14:43
 * @description CanFinish
 */

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            if (!map.containsKey(prerequisite[0])) {
                map.put(prerequisite[0], new ArrayList<>());
            }
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        for (Integer key : map.keySet()) {
            Set<Integer> pathSet = new HashSet<>();
            pathSet.add(key);
            if (!visited[key] && hasCircle(pathSet, map, key, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCircle(Set<Integer> pathSet, Map<Integer, List<Integer>> map, Integer key, boolean[] visited) {
        if (map.containsKey(key)) {
            List<Integer> nextList = map.get(key);
            for (Integer next : nextList) {
                if (pathSet.contains(next)) {
                    // 有环
                    return true;
                }
                pathSet.add(next);
                visited[next] = true;
                if (hasCircle(pathSet, map, next, visited)) {
                    return true;
                }
                pathSet.remove(next);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,3},{0,1}};
        CanFinish solution = new CanFinish();
        System.out.println(solution.canFinish(3, prerequisites));
    }
}
