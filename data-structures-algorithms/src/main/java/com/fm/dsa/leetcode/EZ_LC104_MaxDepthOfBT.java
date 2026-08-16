package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class EZ_LC104_MaxDepthOfBT {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        //recursive DFS
        if(root==null) return 0;
        //   return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        // BFS
        int level=0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.remove();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level++;
        }

        return level;

    }
}


/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
 */
