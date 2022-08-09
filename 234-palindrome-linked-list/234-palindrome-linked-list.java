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
    public boolean isPalindrome(ListNode head) {
        
        int size=getSize(head);
        if(size==1) return true;
        
        int half=size/2;
        ListNode curr=head;ListNode prev=null;
        while(half>0){
            prev=curr;
            curr=curr.next;
            half--;
        }
        
        ListNode newHead=null;
        if(size%2==0){
            prev.next=null;
            newHead=curr;
        }else{
            newHead=curr.next;
            curr.next=null;
        }
        
        ListNode temp=reverse(newHead);
        temp.next=null;
        ListNode head1=head;
        ListNode head2=finalHead;
        
        while(head1!=null&&head2!=null){
            if(head1.val!=head2.val) return false;
            head1=head1.next;
            head2=head2.next;
        }
        
        return true;
    }
    
    ListNode finalHead=null;
    
    public ListNode reverse(ListNode head){
        if(head.next==null) {finalHead=head; return head; }
        reverse(head.next).next=head;
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