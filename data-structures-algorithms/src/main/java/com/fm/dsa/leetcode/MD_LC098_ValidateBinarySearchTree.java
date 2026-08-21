package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

public class MD_LC098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {        
        
        return traverse(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
    public boolean traverse(TreeNode node, int min, int max){
        if(node==null) return true;
        if(node.val<=min || node.val>=max) return false;

        return traverse(node.left,min,node.val)
        && traverse(node.right,node.val,max);

    }
}
