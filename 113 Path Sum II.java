// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new ArrayList<>();

        if(root==null) return result;

        findPath(root, sum, result, new ArrayList<>());

        return result;
    }
    private void findPath(TreeNode root, int sum, List<List<Integer>> result, List<Integer> temp){

        if(root==null){
            return;
        }

        temp.add(root.val);

        if(sum-root.val==0 && root.left==null && root.right==null){
            result.add(new ArrayList<>(temp));
        }else{
            findPath(root.left, sum-root.val, result, temp);
            findPath(root.right, sum-root.val, result, temp);
        }

        temp.remove(temp.size()-1);
    }
}
