package com.fm.dsa.leetcode;

import com.fm.dsa.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class MD_LC019_RemoveNthNodeFromEndOfLL {

    public static void main(String[] args) {

    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;

        return dummy.next;
    }
}


/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.


Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?
 */
