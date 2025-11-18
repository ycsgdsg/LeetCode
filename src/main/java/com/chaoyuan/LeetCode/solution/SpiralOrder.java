package com.chaoyuan.LeetCode.solution;

/**
 * SpiralOrder.
 *
 * @author YC
 * @date 2025/11/17 15:35
 * @description SpiralOrder
 */

import com.chaoyuan.LeetCode.util.ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        return run(matrix, 0, 0, n - 1, m - 1);
    }

    public List<Integer> run(int[][] matrix, int x1, int y1, int x2, int y2) { // (x1,y1)(x2,y1)(x2,y2)(x1,y2) 代表左上右下2个顶点
        List<Integer> result = new ArrayList<>();
        if (x1 <= x2 && y1 <= y2) {
            for (int i = x1; i <= x2; i++) {
                result.add(matrix[y1][i]);
            }
            for (int i = y1 + 1; i <= y2; i++) {
                result.add(matrix[i][x2]);
            }
            for (int i = x2 - 1; y2 > y1 && i >= x1; i--) {
                result.add(matrix[y2][i]);
            }
            for (int i = y2 - 1; x2 > x1 && i > y1; i--) {
                result.add(matrix[i][x1]);
            }
            result.addAll(run(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] martix = {{1,2,3},{5,6,7},{9,10,11}};
        SpiralOrder solution = new SpiralOrder();
        ListUtils.print(solution.spiralOrder(martix));
    }
}
