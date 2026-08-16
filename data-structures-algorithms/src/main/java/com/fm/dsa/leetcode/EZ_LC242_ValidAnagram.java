package com.fm.dsa.leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/valid-anagram/description/
public class EZ_LC242_ValidAnagram {
    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        System.out.println(isAnagram(s, t));

        System.out.println(isAnagramV2(s, t));

    }

    // An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
    private static boolean isAnagram(String s1, String s2) {

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        return String.valueOf(c1).equals(String.valueOf(c2));
    }

    private static boolean isAnagramV2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 1);

            int a = t.lastIndexOf(s1);
            if (a < 0) return false;

            t = t.replaceFirst(s1, "");
        }

        return t.isEmpty();
    }
}


/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
