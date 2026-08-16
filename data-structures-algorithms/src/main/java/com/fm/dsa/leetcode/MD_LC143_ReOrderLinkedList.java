package com.fm.dsa.leetcode;
// https://leetcode.com/problems/reorder-list/description/

import com.fm.dsa.ListNode;

public class MD_LC143_ReOrderLinkedList {
    public static void main(String[] args) {

    }

    static void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        // first get to the midle

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        //reverse the 2nd half
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Merge
        ListNode left = head;
        ListNode right = prev;

        while (right != null) {
            ListNode tempLeft = left.next;
            ListNode tempRight = right.next;
            left.next = right;
            right.next = tempLeft;
            right = tempRight;
            left = tempLeft;
        }
    }
}


/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
 */
