// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3

public class Solution {
    public List<TreeNode> generateTrees(int n) {

        if(n==0) return new ArrayList<TreeNode>();

        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start > end){
            list.add(null);
            return list;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftSubTree = generateSubTrees(start, i-1);
            List<TreeNode> rightSubTree = generateSubTrees(i+1, end);
            for(TreeNode left : leftSubTree){
                for(TreeNode right : rightSubTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
