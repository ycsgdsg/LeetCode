package com.chaoyuan.LeetCode.solution;

/**
 * Rotate.
 *
 * @author YC
 * @date 2025/11/17 16:28
 * @description Rotate
 */

import com.chaoyuan.LeetCode.util.ListUtils;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0, j = m - 1; i < j; i++, j--) {
            for (int k = 0; k < m; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martix = {{1,2,3},{4,5,6},{7,8,9}};
        Rotate solution = new Rotate();
        solution.rotate(martix);
        ListUtils.print(martix);
    }
}
