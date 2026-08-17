package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import java.util.ArrayList;

// https://neetcode.io/problems/string-encode-and-decode/question
public class MD_LC271_EncodeDecodeStrings {
    public static void main(String[] args) {
        String[] strs = {"Hello", "World"};

        String encodedString = encode(strs);
        LOG("encoded string = " + encodedString);

        String[] decodedStr = decode(encodedString);
        LOG("decoded string = " + decodedStr);

    }

    private static String encode(String[] s) {

        String encodedString = "";
        for (int i = 0; i < s.length; i++) {
            int l = s[i].length();
            encodedString += l + "#" + s[i];

        }
        return encodedString;

    }

    private static String[] decode(String s) {
        ArrayList<String> list = new ArrayList<>();

        // for(int i=0; i<s.length(); i++){

        //     int idx = s.indexOf("#", i);
        //     String ss1 = s.substring(i,idx);
        //     int len = Integer.valueOf(ss1);

        //     list.add(s.substring(idx+1,idx+1+len));

        //     i=idx+len;

        // }

        for (int i = 0; i < s.length(); ) {
            int idx = s.indexOf("#", i);
            String t = s.substring(i, idx);
            int len = Integer.parseInt(t);
            idx++;
            String st = s.substring(idx, idx + len);
            list.add(st);
            i = len + idx;
        }

        return list.toArray(new String[list.size()]);
    }
}


/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

String encode(List<String> strs) {
    // ... your code
    return encoded_string;
}
Machine 2 (receiver) has the function:

List<String> decode(String encoded_string) {
    // ... your code
    return decoded_strs;
}
So Machine 1 does:

String encoded_string = encode(strs);
and Machine 2 does:

List<String> decoded_strs = decode(encoded_string);
decoded_strs in Machine 2 should be the same as the input strs in Machine 1.

Implement the encode and decode methods.

Example 1:

Input: strs = ["Hello","World"]

Output: ["Hello","World"]
Explanation:

Solution solution = new Solution();
String encoded_string = solution.encode(strs);

// Machine 1 ---encoded_string---> Machine 2

List<String> decoded_strs = solution.decode(encoded_string);

Example 2:

Input: strs = [""]

Output: [""]

Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains any possible characters out of 256 valid ASCII characters.
 */
