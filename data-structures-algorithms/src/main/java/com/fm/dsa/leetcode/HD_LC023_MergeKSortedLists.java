package com.fm.dsa.leetcode;

import com.fm.dsa.ListNode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
public class HD_LC023_MergeKSortedLists {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < lists.length; i++) pq.add(lists[i]);

        ListNode result = null, current = null;

        while (!pq.isEmpty()) {
            ListNode ln = pq.poll();
            if (ln.next != null) pq.add(ln.next);

            if (result == null) {
                result = ln;
                current = result;
            } else {
                current.next = ln;
                current = current.next;
            }
        }

        return result;
    }
}



/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
 */
