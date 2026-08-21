package com.fm.dsa.leetcode;
import java.util.*;

import com.fm.dsa.TreeNode;

public class MD_LC102_BTLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root==null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.remove();
                list.add(node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
