package com.chaoyuan.LeetCode.solution;

/**
 * SortList.
 *
 * @author YC
 * @date 2025/11/19 10:41
 * @description SortList
 */

import com.chaoyuan.LeetCode.util.ListNode;

import java.util.Comparator;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode left = sortList(head, slow);
        ListNode right = sortList(slow, tail);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode leftCursor = left;
        ListNode rightCursor = right;
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        while (leftCursor != null && rightCursor != null) {
            if (leftCursor.val >= rightCursor.val) {
                cursor.next = rightCursor;
                rightCursor = rightCursor.next;
            } else {
                cursor.next = leftCursor;
                leftCursor = leftCursor.next;
            }
            cursor = cursor.next;
        }
        if (leftCursor == null) cursor.next = rightCursor;
        if (rightCursor == null) cursor.next = leftCursor;
        return head.next;
    }

    private Comparator<ListNode> up = Comparator.comparingInt(o -> o.val);
    private Comparator<ListNode> down = (o1, o2) -> o2.val - o1.val;

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node3 = new ListNode(3, node5);
        ListNode node4 = new ListNode(4, node3);
        ListNode node1 = new ListNode(1, node4);
        ListNode node2 = new ListNode(2, node1);
        SortList solution = new SortList();
        solution.sortList(node2);
    }
}
