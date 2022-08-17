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
        if(head==null) return null;
        reverse(head);
        return newHead;
    }
    
    public ListNode newHead=null;
    
    public ListNode reverse(ListNode head){
        if(head.next==null) {newHead=head;return head;}
        reverse(head.next).next=head;
        head.next=null;
        return head;
    }
}

