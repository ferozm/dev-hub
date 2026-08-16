package com.fm.dsa.leetcode;

// https://leetcode.com/problems/product-of-array-except-self/description/
public class MD_LC238_ProductOfArrayExceptSElf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};
        int[] result = productExceptSelf(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int pfxTotal = 1, sfxTotal = 1;

        for (int i = 0; i < nums.length; i++) {
            pfxTotal *= i == 0 ? 1 : nums[i - 1];
            result[i] = pfxTotal;
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            sfxTotal *= j == nums.length - 1 ? 1 : nums[j + 1];
            result[j] = result[j] * sfxTotal;

        }
        return result;

    }
}


/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
