package com.chaoyuan.LeetCode.solution;

/**
 * OrangesRotting.
 *
 * @author YC
 * @date 2025/11/26 08:10
 * @description OrangesRotting
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        Queue<Position> swiftQueue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Position(i, j));
                }
            }
        }
        int result = 0;
        do {
            boolean rotted = false;
            while (!queue.isEmpty()) {
                Position position = queue.poll();
                int row = position.row, column = position.column;
                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    swiftQueue.add(new Position(row - 1, column));
                    rotted = true;
                }
                if (row + 1 < m && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    swiftQueue.add(new Position(row + 1, column));
                    rotted = true;
                }
                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    swiftQueue.add(new Position(row, column - 1));
                    rotted = true;
                }
                if (column + 1 < n && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    swiftQueue.add(new Position(row, column + 1));
                    rotted = true;
                }
            }
            if (rotted) {
                result++;
                rotted = false;
            }
            while (!swiftQueue.isEmpty()) {
                Position position = swiftQueue.poll();
                int row = position.row, column = position.column;
                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    queue.add(new Position(row - 1, column));
                    rotted = true;
                }
                if (row + 1 < m && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    queue.add(new Position(row + 1, column));
                    rotted = true;
                }
                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    queue.add(new Position(row, column - 1));
                    rotted = true;
                }
                if (column + 1 < n && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    queue.add(new Position(row, column + 1));
                    rotted = true;
                }
            }
            if (rotted) {
                result++;
                rotted = false;
            }
        } while (!queue.isEmpty());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result = -1;
                    break;
                }
            }
        }

        return result;
    }

    public static class Position {
        public int row;
        public int column;

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2}};
        OrangesRotting solution = new OrangesRotting();
        System.out.println(solution.orangesRotting(grid));
    }
}
