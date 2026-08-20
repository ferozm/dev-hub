package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

public class EZ_LC100_SameTree {
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val != q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
     }
    
}
