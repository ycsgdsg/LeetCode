package com.chaoyuan.LeetCode.solution;

import java.util.Scanner;

/**
 * Created by yc on 2015/10/31.
 */
public class SplitOddAndEven {

    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int lineCount = cin.nextInt();
        for (int index = 0; index < lineCount; index ++) {
            int n = cin.nextInt();
            for (int i = 1; i <= n; i+=2) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 2; i <= n; i+=2) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
