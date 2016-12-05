package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * Created by ycsgd on 2016/11/27.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toBeRemoved = new ListNode(0);
        toBeRemoved.next = head;
        ListNode tail = toBeRemoved;
        for (int step = 0; step < n; step++) {
            if (tail != null) {
                tail = tail.next;
            } else {
                break;
            }
        }
        if (tail == null ||tail.next == null) {
            return head.next;
        }
        while (tail.next != null) {
            toBeRemoved = toBeRemoved.next;
            tail = tail.next;
        }
        if (toBeRemoved.next != null && toBeRemoved.next.next != null) {
            toBeRemoved.next = toBeRemoved.next.next;
        } else {
            toBeRemoved.next = null;
        }
        return head;

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
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        removeNthNodeFromEndOfList.removeNthFromEnd(node1, 11);
    }
}
