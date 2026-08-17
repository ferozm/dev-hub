package com.fm.dsa.leetcode;

import static com.fm.dsa.DSALogger.LOG;

import com.fm.dsa.*;

// https://leetcode.com/problems/invert-binary-tree/description/


public class EZ_LC226_InvertBinaryTree {
    public static void main(String[] args) {

        LOG(invertTree(null));
    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }
}


/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */