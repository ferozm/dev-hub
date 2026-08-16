package com.fm.dsa.leetcode;

import java.util.*;

// https://leetcode.com/problems/minimum-window-substring/description/
public class HD_LC076_MinSubWindowSubString {
    public static void main(String[] args) {

        String s = "cabwefgewcwaefgcf", t = "cae";
        System.out.println(minWindow(s, t));
    }

    static String minWindow(String s, String t) {

        String result = "";

        HashMap<Character, Integer> window = new HashMap();
        HashMap<Character, Integer> countT = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int[] resIndx = {-1, -1};

        int minLen = Integer.MAX_VALUE;
        int have = 0, need = countT.size();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.getOrDefault(c, 0) == countT.get(c))
                have++;

            while (have == need) {
                int strLen = right - left + 1;
                if (strLen < minLen) {
                    minLen = strLen;
                    resIndx[0] = left;
                    resIndx[1] = right;
                }

                //move left pointer towards right
                Character lc = s.charAt(left);
                window.put(lc, window.get(lc) - 1);
                if (countT.containsKey(lc) && window.getOrDefault(lc, 0) < countT.get(lc)) {
                    have--;
                }
                left++;
            }
        }

        if (minLen != Integer.MAX_VALUE) result = s.substring(resIndx[0], resIndx[1] + 1);
        return result;
    }
}


/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
