// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
// Return a deep copy of the list.

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return head;

        RandomListNode node = head;
        while(node!=null){
            RandomListNode next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }

        node = head;
        while(node!=null){
            if(node.random!=null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        RandomListNode copyHead = new RandomListNode(0);
        RandomListNode copy = copyHead;
        node = head;
        while(node!=null){

            copy.next = node.next;
            node.next = node.next.next;
            copy = copy.next;
            node = node.next;

        }
        return copyHead.next;
    }
}
