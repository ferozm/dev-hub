package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

public class EZ_LC572_SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

    /*
        // BFS
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(isSame(node,subRoot)) return true;
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return false;
    */

    if(subRoot==null) return true;
    if(root==null) return false;

    if(isSame(root,subRoot)) return true;

    return(isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));

    }

    // DFS
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;

        return isSame(p.left,q.left) && isSame(p.right, q.right);
    }
}
