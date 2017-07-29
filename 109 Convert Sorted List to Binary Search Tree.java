// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return BSTHelper(head, null);
    }
    private TreeNode BSTHelper(ListNode head, ListNode end){
        ListNode slow = head;
        ListNode fast = head;

        if(head == end) return null;

        // fastNode is two times faster that slowNode, so the slow would be the middle ListNode of the LinkedList
        while(fast!=end && fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        
        root.left = BSTHelper(head, slow);
        root.right = BSTHelper(slow.next, end);

        return root;

    }
}
