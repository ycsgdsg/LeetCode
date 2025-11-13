package com.chaoyuan.LeetCode.solution;


import com.chaoyuan.LeetCode.util.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * BuildTree.
 *
 * @author YC
 * @date 2025/11/13 15:44
 * @description BuildTree
 */

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
                Arrays.stream(preorder).boxed().collect(Collectors.toList()),
                Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder == null || preorder.isEmpty()) return null;
        TreeNode ret = new TreeNode(preorder.get(0));
        if (preorder.size() > 1) {
            int i = 0;
            while (!Objects.equals(inorder.get(i++), preorder.get(0)));
            List<Integer> leftPre = preorder.subList(1, i);
            List<Integer> leftIn = inorder.subList(0, i - 1);

            List<Integer> rightPre = preorder.subList(i, preorder.size());
            List<Integer> rightIn = inorder.subList(i, inorder.size());
            ret.left = buildTree(leftPre, leftIn);
            ret.right = buildTree(rightPre, rightIn);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7}, inorder = {9,3,15,20,7};
        BuildTree solution = new BuildTree();
        TreeNode ret = solution.buildTree(preorder, inorder);
    }
}
