package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

public class HD_LC297_SerializeDeSerializeBT {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {

        if (root == null)
            return "N";
        String result = "";
        result += root.val;
        result += "," + serialize(root.left);
        result += "," + serialize(root.right);

        return result;
    }

    TreeNode deserialize(String data) {
        int[] i = new int[1];
        return build(data.split(","), i);
    }

    TreeNode build(String[] nums, int[] i) {
        String str = nums[i[0]];
        i[0] = i[0] + 1;
        if (str.equals("N"))
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = build(nums, i);
        node.right = build(nums, i);

        return node;
    }
}

/*
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Clarification: The input/output format is the same as how LeetCode serializes
 * a binary tree. You do not necessarily need to follow this format, so please
 * be creative and come up with different approaches yourself.
 * 
 * Example 1: Input: root = [1,2,3,null,null,4,5] Output: [1,2,3,null,null,4,5]
 * 
 * Example 2: Input: root = [] Output: []
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
