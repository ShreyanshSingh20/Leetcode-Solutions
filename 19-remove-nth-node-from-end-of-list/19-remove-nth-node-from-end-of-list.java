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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size=getSize(head);
        int fromStart=size-n+1;
        int counter=1;
        
        ListNode curr=head;ListNode prev=null;
        while(counter!=fromStart){
            prev=curr;
            curr=curr.next;
            counter++;
        }
        
        if(prev==null&&curr.next==null){
            return null;
        }else if(prev==null&&curr.next!=null){
            head=curr.next;
            curr.next=null;
            return head;
        }
        
        prev.next=curr.next;
        curr.next=null;
        
        return head;
    }
    
    public int getSize(ListNode head){
        ListNode curr=head;
        int res=0;
        while(curr!=null){
            curr=curr.next;
            res++;
        }
        return res;
    }
}