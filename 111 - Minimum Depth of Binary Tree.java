// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {

        if(root==null) return 0;

        int countL = minDepth(root.left);
        int countR = minDepth(root.right);

        if(countL==0 && countR!=0) return countR +1;

        else if(countR==0 && countL!=0) return countL +1;

        else if(countL==0 && countR==0) return 1;

        else return Math.min(countL,countR) + 1;

    }
}
