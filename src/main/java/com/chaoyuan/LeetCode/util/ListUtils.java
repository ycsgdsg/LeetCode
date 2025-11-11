package com.chaoyuan.LeetCode.util;

import java.util.Arrays;
import java.util.List;

/**
 * ListUtils.
 *
 * @author: chaoyuan
 * @since: 2025/11/9 14:38
 * @description: ListUtils
 */
public class ListUtils {
    public static <T> void print(List<T> list) {
        list.forEach(System.out::println);
    }
    public static <T> void print(T[] list) {
        Arrays.stream(list).forEach(System.out::println);
    }
}
