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
        //not a good practice to modify the original list
        ListNode curr=head;
        ListNode newHead=null;
        ListNode pointer=null;
        while(curr!=null){
            if(curr.val<x){
                 if(newHead==null){
                     newHead=new ListNode(curr.val);
                     pointer=newHead;
                 }else{
                     ListNode newNode=new ListNode(curr.val);
                     pointer.next=newNode;
                     pointer=newNode;
                 }
            }
            curr=curr.next;
        }
        
        curr=head;
        while(curr!=null){
            if(curr.val>=x){
                if(newHead==null){
                     newHead=new ListNode(curr.val);
                     pointer=newHead;
                 }else{
                     ListNode newNode=new ListNode(curr.val);
                     pointer.next=newNode;
                     pointer=newNode;
                 }
            }
            curr=curr.next;
        }
        
        return newHead;
    }
    
}