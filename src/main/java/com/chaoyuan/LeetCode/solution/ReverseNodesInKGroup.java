package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

import java.util.Stack;

/**
 * Created by ycsgd on 2016/12/3.
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (current != null) {
            for (int i = 0; i < k && current != null; i++) {
                stack.push(current);
                current = current.next;
            }
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    tail.next = stack.pop();
                    tail = tail.next;
                    tail.next = null;
                }
            } else{
                Stack<ListNode> newStack = new Stack<ListNode>();
                while (!stack.isEmpty()) {
                    newStack.push(stack.pop());
                }
                while (!newStack.empty()) {
                    tail.next = newStack.pop();
                    tail = tail.next;
                    tail.next = null;
                }
            }
        }
        return newHead.next;

    }

    private ListNode swapPairs(ListNode head, int k) {
        if (head.next == null) {
            return head;
        } else {
            ListNode newHead = head.next;
            head.next = null;
            ListNode nextHead = newHead.next;
            newHead.next = head;
            head.next = swapPairs(nextHead, k-1);
            return newHead;
        }
    }

    private ListNode revertList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode iterator = current.next;
            current.next = head;
            head = current;
            current = iterator;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ReverseNodesInKGroup swapNodesInPairs = new ReverseNodesInKGroup();
//        swapNodesInPairs.revertList(node1);
//        swapNodesInPairs.reverseKGroup(node1, 3);
        swapNodesInPairs.reverseKGroup(node1, 4);
    }
}
