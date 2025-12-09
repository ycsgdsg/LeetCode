package com.chaoyuan.LeetCode.solution;

/**
 * SwapPairs.
 *
 * @author YC
 * @date 2025/11/18 15:54
 * @description SwapPairs
 */

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        else {
            ListNode first = head;
            ListNode second = first.next;
            first.next = swapPairs(second.next);
            second.next = first;
            return second;
        }
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        SwapPairs solution = new SwapPairs();
        solution.swapPairs(node1);
    }
}
