package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import java.util.HashMap;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/

public class EZ_LC020_ValidParantheses {
    public static void main(String[] args) {
        String s1 = "([{}])";
        String s2 = "[]";
        String s3 = "[(])";

        LOG(isValid(s1));
        LOG(isValid(s2));
        LOG(isValid(s3));

    }


    static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> pairing = new HashMap<>();
        pairing.put(')','(');
        pairing.put('}','{');
        pairing.put(']','[');

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!stack.isEmpty() && stack.peek() == pairing.get(c))
                stack.pop();
            else
                stack.push(c);
        }

        return stack.isEmpty();
    }
}


/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */
