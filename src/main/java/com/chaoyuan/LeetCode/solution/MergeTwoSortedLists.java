package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * Created by chaoyuan on 11/28/2016.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode iterator = result;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                iterator.next = n1;
                iterator = n1;
                n1 = n1.next;
            } else {
                iterator.next = n2;
                iterator = n2;
                n2 = n2.next;
            }
        }
        if (n1 == null) {
            iterator.next = n2;
        }
        if (n2 == null) {
            iterator.next = n1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(6);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        mergeTwoSortedLists.mergeTwoLists(n1, n5);
    }
}


