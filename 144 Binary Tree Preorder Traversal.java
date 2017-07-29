// Given a binary tree, return the preorder traversal of its nodes' values.
// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].
// Note: Recursive solution is trivial, could you do it iteratively?
1.Recursive solution:
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();

            return dfs(root, list);
        }

        private List<Integer> dfs(TreeNode root, List<Integer> list){

            if(root==null) return list;
            list.add(root.val);
            list = dfs(root.left, list);
            list = dfs(root.right, list);
            return list;

        }
    }

2.Iterative solution:
    public class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();

            while(root!=null){

                list.add(root.val);

                if(root.right!=null) stack.push(root.right);

                root = root.left;

                if (root == null && !stack.isEmpty()) {
                    root = stack.pop();
                }
            }

            return list;
        }
    }
