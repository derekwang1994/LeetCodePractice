// 這題會用到 104 - Maximum Depth of Binary Tree
// 尋找node左樹的高度和右樹的高度，然後相減，如果差超過1，表示非高度平衡樹
// 如果沒差超過1，傳入左節點與右節點繼續判斷是否為高度平衡樹

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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int heightL = height(root.left); //左樹的高度
        int heightR = height(root.right); //右樹的高度

        if( Math.abs( heightL - heightR ) >1 ) return false;

        return (isBalanced(root.left) && isBalanced(root.right)); //利用遞迴來檢查所有節點

    }
    public int height(TreeNode node){
        if(node==null) return 0;

        int left = 1;
        int right = 1;

        left += height(node.left);
        right += height(node.right);

        return left > right ? left : right; // 回傳節點高度(level)
    }
}
