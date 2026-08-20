package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

public class MD_LC236_LowestCommonAncestorOfBT {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val>root.val && q.val>root.val)
                root=root.right;
            else if(p.val<root.val && q.val<root.val)
                root=root.left;
            else
                return root;
        }
        return null;
    }
}
