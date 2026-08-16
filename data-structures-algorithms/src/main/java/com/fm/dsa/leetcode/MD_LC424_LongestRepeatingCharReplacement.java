package com.fm.dsa.leetcode;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/

import java.util.HashMap;

public class MD_LC424_LongestRepeatingCharReplacement {
    public static void main(String[] args) {

        String s = "AABABBA";
        System.out.println((characterReplacement(s, 1)));

    }

    // Dynamic sliding window
    private static int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int result = 0;
        int left = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            map.put(key, map.getOrDefault(key, 0) + 1);

            count = Math.max(count, map.get(key));

            while (right - left + 1 - count > k) {
                map.put(s.charAt(left), map.getOrDefault(key, 0) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);

        }

        return result;

    }
}

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.


Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
 */
