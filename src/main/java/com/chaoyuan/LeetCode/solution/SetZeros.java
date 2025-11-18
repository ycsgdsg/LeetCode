package com.chaoyuan.LeetCode.solution;

/**
 * SetZeros.
 *
 * @author YC
 * @date 2025/11/17 11:44
 * @description SetZeros
 */

import com.chaoyuan.LeetCode.util.ListUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row = false, column = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                column = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                row = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (column) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martix = {{0,1,2,0}, {3,4,5,2},{1,3,1,5}};
        SetZeros solution = new SetZeros();
        solution.setZeroes(martix);
        for (int[] array : martix) {
            ListUtils.print(Arrays.stream(array).boxed().collect(Collectors.toList()));
        }
    }
}
