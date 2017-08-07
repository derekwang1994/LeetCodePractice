// Given a binary tree, return the inorder traversal of its nodes' values.
// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

1.Recursive solution:

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            if(root==null) return list;

            return helper(root, list);
        }

        private List<Integer> helper(TreeNode root, List<Integer> list){
            if(root.left==null && root.right==null){
                list.add(root.val);
                return list;
            }
            if(root.left!=null){
                list = helper(root.left, list);
            }
            list.add(root.val);
            if(root.right!=null){
                list = helper(root.right, list);
            }
            return list;
        }
    }

2.Iterative solution:

    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();

            while(root!=null || !stack.isEmpty()){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();

                list.add(root.val);

                root = root.right;

            }

            return list;
        }
    }
