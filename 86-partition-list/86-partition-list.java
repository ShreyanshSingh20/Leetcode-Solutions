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
    public ListNode partition(ListNode head, int x) {
        
        ListNode before=null;
        ListNode after=null;
        
        ListNode startBefore=null;
        ListNode startAfter=null;
        ListNode prev=head;
        while(head!=null){
            if(head.val<x){
                if(before==null) {
                    before=head;
                    if(startBefore==null) startBefore=before;
                }
                else{
                    before.next=head;
                    before=before.next;
                }
            }else if(head.val>=x){
                if(after==null){ 
                    after=head;
                    if(startAfter==null) startAfter=after;
                }
                else{
                    after.next=head;
                    after=after.next;
                }
            }
            head=head.next;
            prev.next=null;
            prev=head;
        }
        if(startBefore==null){
            return startAfter;
        }
        before.next=startAfter;
        return startBefore;
        
    }
}

// before:1->2->2
// after:4->3->5
// target: