// Given inorder and postorder traversal of a tree, construct the binary tree.
// Note:
// You may assume that duplicates do not exist in the tree.

// O(n) time and O(n) space, using HashMap to look for root of the inorder.
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, postorder.length-1, 0, inorder.length-1, map);

    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder,int postStart, int inStart, int inEnd, Map<Integer, Integer> map){
        if(inStart>inEnd || postStart<0){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postStart]);
        int rootIndex = 0;
        rootIndex = map.get(postorder[postStart]);

        root.left = buildTreeHelper(inorder, postorder, postStart-(inEnd-rootIndex)-1, inStart, rootIndex-1, map);
        root.right = buildTreeHelper(inorder, postorder, postStart-1, rootIndex+1, inEnd, map);

        return root;
    }
}
