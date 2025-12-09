package com.chaoyuan.LeetCode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * CopyRandomList.
 *
 * @author YC
 * @date 2025/11/18 16:25
 * @description CopyRandomList
 */
public class CopyRandomList {
    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        if (!map.containsKey(head)) {
            Node newHead = new Node(head.val);
            map.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }

    public static class Node {
        private final int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
        }
    }
}
