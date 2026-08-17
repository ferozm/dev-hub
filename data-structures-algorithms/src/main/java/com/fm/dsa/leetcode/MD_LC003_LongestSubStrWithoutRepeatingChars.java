package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import java.util.ArrayList;
import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class MD_LC003_LongestSubStrWithoutRepeatingChars {
    public static void main(String[] args) {

        String s = "zxxyzaxyz";
        LOG(lengthOfLongestSubstring(s));
        LOG(lengthOfLongestSubstringV2(s));
    }

    private static int lengthOfLongestSubstring(String str) {

        int left=0, maxLen=0, len=0;
        HashSet<Character> set = new HashSet<>();
        for(int right=0; right<str.length(); right++){
            char c = str.charAt(right);
            while (set.contains(c)) {
                char c1 = str.charAt(left);
                set.remove(c1);
                left++;
            }
            set.add(c);
            len = right-left+1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;

    }

    private static int lengthOfLongestSubstringV2(String str) {

        int result =0;
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<str.length(); i++){
            String s = str.substring(i, i+1);
            while(list.contains(s)){
                list.remove(0);
            }
            list.add(s);
            result = Math.max(result,list.size());
        }

        return result;
    }
}


/*
Given a string s, find the length of the longest substring without duplicate characters.


Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 105
s consists of English letters, digits, symbols and spaces.


 */
