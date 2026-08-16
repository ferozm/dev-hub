package com.fm.dsa.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class MD_LC215_KthLargestElementInArray {

    public static void main(String[] args) {
        int[] nums ={3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,3));
    }

    private  static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap by default;
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a); //add comparator to make it max heap
//        for(int i=0; i<nums.length; i++){
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

}


/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
