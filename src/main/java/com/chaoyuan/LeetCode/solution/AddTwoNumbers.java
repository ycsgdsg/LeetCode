package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * Created by yc on 2015/11/7.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode resultNode = null;
        int val1 = l1.val;
        int val2 = l2.val;
        int result = val1 + val2;
        if (result >= 10) {
            ListNode carry = new ListNode(1);
            resultNode = new ListNode(result % 10);
            resultNode.next = addThreeNumbers(l1.next, l2.next, carry);
        } else {
            resultNode = new ListNode(result);
            resultNode.next = addTwoNumbers(l1.next, l2.next);
        }
        return resultNode;
    }

    public ListNode addThreeNumbers(ListNode l1, ListNode l2, ListNode l3) {
        if (l1 == null) {
            return addTwoNumbers(l2, l3);
        } else if (l2 == null) {
            return addTwoNumbers(l1, l3);
        } else if (l3 == null) {
            return addTwoNumbers(l1, l2);
        }
        int val1 = l1.val;
        int val2 = l2.val;
        int val3 = l3.val;
        int result = val1 + val2 + val3;
        ListNode resultNode = null;
        if (result >= 10) {
            ListNode carry = new ListNode(1);
            resultNode = new ListNode(result % 10);
            resultNode.next = addThreeNumbers(l1.next, l2.next, carry);
        } else {
            resultNode = new ListNode(result);
            resultNode.next = addTwoNumbers(l1.next, l2.next);
        }
        return resultNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
//        atn.print(atn.addTwoNumbers());
    }

    public void print(ListNode node) {
        if (node != null) {
            System.out.print(node.val);
            print(node.next);
        }
    }
}
