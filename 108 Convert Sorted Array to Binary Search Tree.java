// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length==0) return null;

        return BSTHelper(nums, 0, nums.length-1);
    }

    private TreeNode BSTHelper(int[] nums, int low, int high){
        if( low > high ) return null;

        int mid = (low+high)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = BSTHelper(nums, low, mid-1);
        root.right = BSTHelper(nums, mid+1, high);

        return root;
    }
}
