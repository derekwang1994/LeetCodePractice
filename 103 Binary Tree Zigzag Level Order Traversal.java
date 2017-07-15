// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

// Bfs, Queue //
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();

        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        boolean order = true;

        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> tempList = new ArrayList<>();

            int levelNum = queue.size();

            for(int i=0; i<levelNum; i++){

                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);

                if(order){
                    tempList.add(queue.poll().val);
                }else{
                    tempList.add(0, queue.poll().val);
                }


            }

            list.add(tempList);
            order = order ^ true;
        }

        return list;
    }
}
