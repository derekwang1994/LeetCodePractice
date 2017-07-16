// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if(inStart>inEnd || preStart>preorder.length-1){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = inStart; // Index of current root in inorder
        while(inIndex <= inEnd && preorder[preStart]!=inorder[inIndex]){
            inIndex++;
        }

        root.left = buildTreeHelper(preorder, inorder, preStart+1, inStart, inIndex-1);
        root.right = buildTreeHelper(preorder, inorder, preStart+inIndex-inStart+1, inIndex+1, inEnd);
        return root;
    }
}
