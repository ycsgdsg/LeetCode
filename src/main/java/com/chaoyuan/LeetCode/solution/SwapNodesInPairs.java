package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * Created by ycsgd on 2016/12/3.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            head.next = null;
            ListNode nextHead = newHead.next;
            newHead.next = head;
            head.next = swapPairs(nextHead);
            return newHead;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        swapNodesInPairs.swapPairs(node1);
    }
}
