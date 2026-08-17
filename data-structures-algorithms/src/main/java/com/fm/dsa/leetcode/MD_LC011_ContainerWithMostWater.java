package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

// https://leetcode.com/problems/container-with-most-water/description/
public class MD_LC011_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1, 7, 2, 5, 4, 7, 3, 6};
        LOG("getMaxArea = " + getMaxArea(heights));

        int[] height1 = {2, 2, 2};
        LOG("getMaxArea = " + getMaxArea(height1));
    }


    // sliding window with dynamic size
    private static int getMaxArea(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            int ht = Math.min(heights[left], heights[right]);
            int wd = right - left;
            int area = ht * wd;

            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}


/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */