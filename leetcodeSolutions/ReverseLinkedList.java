/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // base case
        if(head == null || head.next == null) {
            return head;
        }
        // recursive case
        ListNode tailOfRest = head.next; // 2 save the node that will become the tail of the rest so we can extend it
        ListNode headOfRest = reverseList(head.next); // 4 trust that the recursion can reverse the rest of the list
        tailOfRest.next = head; // set head to the tail of the rest
        head.next = null;
        return headOfRest;
    }
    // Time Complexity: O(n)
    // Space Complexity O(1)
}