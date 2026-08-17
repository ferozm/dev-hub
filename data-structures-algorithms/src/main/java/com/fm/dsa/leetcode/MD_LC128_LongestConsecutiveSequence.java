package com.fm.dsa.leetcode;
// https://leetcode.com/problems/longest-consecutive-sequence/description/

import static com.fm.dsa.DSALogger.LOG;

import java.util.Arrays;

public class MD_LC128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        int result = longestConsqSeqLength(nums);
        LOG("longestConsqSeqLength = " + result);

    }

    private static int longestConsqSeqLength(int[] nums) {

        int maxLen = 0;
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) len++;
            else if (nums[i] == nums[i - 1]) continue;
            else len = 0;

            maxLen = Math.max(maxLen, len);
        }
        return maxLen;

    }
}

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.


Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 */
