package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/group-anagrams/description/

public class MD_LC049_GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};

        List<List<String>> output = getGroupAnagrams(input);

        for (int i = 0; i < output.size(); i++) {
            List<String> l = output.get(i);
            for (int j = 0; j < l.size(); j++) {
                LOG(l.get(j));
            }
            LOG("---------");
        }
    }


    private static List<List<String>> getGroupAnagrams(String[] str) {

        HashMap<String, ArrayList<String>> set = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            char[] c1 = str[i].toCharArray();
            Arrays.sort(c1);
            String s1 = new String(c1);

            if (!set.containsKey(s1)) {
                set.put(s1, new ArrayList<String>());
            }
            set.get(s1).add(str[i]);
        }

        return new ArrayList<>(set.values());

    }
}

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.


 */
