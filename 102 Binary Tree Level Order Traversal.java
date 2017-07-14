// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

// bfs solution using queue //
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root==null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> tempList = new ArrayList<>();

            for(int i=0; i<levelNum; i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                tempList.add( queue.poll().val );
            }

            list.add(tempList);
        }

        return list;

    }
}
