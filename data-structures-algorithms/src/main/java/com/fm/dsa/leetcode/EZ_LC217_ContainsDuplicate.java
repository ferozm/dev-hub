package com.fm.dsa.leetcode;

import java.util.HashSet;

import static com.fm.dsa.DSALogger.LOG;

/*
https://leetcode.com/problems/contains-duplicate/description/
 */
public class EZ_LC217_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 1};
        LOG("containsDuplicate = " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4, 5};
        LOG("containsDuplicate = " + containsDuplicate(nums2));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.


Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true



Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */