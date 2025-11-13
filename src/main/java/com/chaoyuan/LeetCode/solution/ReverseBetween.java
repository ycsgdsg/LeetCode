package com.chaoyuan.LeetCode.solution;

/**
 * ReverseBetween.
 *
 * @author YC
 * @date 2025/11/13 15:05
 * @description ReverseBetween
 */

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(0, head);
        ListNode pre = preHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode newHead = new ListNode(0);
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            temp.next = newHead.next;
            newHead.next = temp;
        }
        ListNode temp = pre.next;
        pre.next = newHead.next;
        while (newHead.next != null) {
            newHead = newHead.next;
        }
        newHead.next = temp;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ReverseBetween solution = new ReverseBetween();
        solution.reverseBetween(node1, 2, 4);
    }
}
