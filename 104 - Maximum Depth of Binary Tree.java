/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // 遞迴法 //
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int countL = 1;
        int countR = 1;

        if(root.left!=null){
            countL += maxDepth(root.left);
        }

        if(root.right!=null){
            countR += maxDepth(root.right);
        }
        // 判斷左右的高度，回傳較大者 //
        return (countL>countR) ? countL : countR;
    }
}
