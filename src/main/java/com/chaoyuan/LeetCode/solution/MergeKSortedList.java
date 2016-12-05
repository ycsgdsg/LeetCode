package com.chaoyuan.LeetCode.solution;

import com.chaoyuan.LeetCode.util.ListNode;

/**
 * Created by ycsgd on 2016/12/3.
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }

    private ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return mergeTwoLists(l1,l2);
        }else
            return null;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        mergeKSortedList.mergeKLists(null);
    }
}
