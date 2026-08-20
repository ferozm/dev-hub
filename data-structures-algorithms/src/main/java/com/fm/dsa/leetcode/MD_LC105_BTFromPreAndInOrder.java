package com.fm.dsa.leetcode;

import com.fm.dsa.TreeNode;

public class MD_LC105_BTFromPreAndInOrder {

    public static void main(String[] args) {
        TreeNode tn = buildTree(new int[]{3, 9, 20, 15, 7},new int[]{9,3,15,20,7});
        System.out.println(tn.val);
    }


    static int preIdx = 0;

    static int findIdx(int[] list, int left, int right, int val){
        for(int i=0; i<=right; i++){
            if(list[i]==val) return i;
        }

        return -1;
    }

    static TreeNode traverse(int[] preOrder, int[] inOrder, int left, int right){
        if(left>right) return null;

        TreeNode root = new TreeNode(preOrder[preIdx]);

        int idx = findIdx(inOrder, left, right, preOrder[preIdx]);
        preIdx++;

        root.left = traverse(preOrder, inOrder, left, idx-1);
        root.right = traverse(preOrder, inOrder, idx+1, right);

        return root;

    }

    static public TreeNode buildTree(int[] preorder, int[] inorder) {

        return traverse(preorder, inorder, 0, inorder.length-1);
    }
}
