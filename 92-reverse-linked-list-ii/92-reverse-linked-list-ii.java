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
    ListNode l;
    ListNode r;
    ListNode prevLeft;
    ListNode nextRight;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        right=right-left-1;
        left--;//converting to 0 based indexing
        ListNode curr=head;
        this.prevLeft=null;
        while(curr!=null){
            if(left>0){// i have not found left node till yet
                this.prevLeft=curr;
                curr=curr.next;
                left--;
            }else if(left==0){//found it the break
                this.l=curr;
                break;
            }
        }
        
        if(l==null) return head;//if left node not found at all
        if(curr!=null) curr=curr.next;//if i have any scope of finding right node
        
        while(curr!=null){
            if(right>0){//right node not found till yet
                curr=curr.next;
                right--;
            }else if(right==0){//just found the right node
                this.r=curr;
                break;
            }
        }
        
        if(r==null) return head;//if right node was not in the list
        
        this.nextRight=r.next;//found the right node so updated the next to right node
        
        ListNode tail=reverse(l,r);
        
        tail.next=nextRight;
        
        if(prevLeft==null) return r;
        else{
            prevLeft.next=r;
            return head;
        }
        
    }
    
    public ListNode reverse(ListNode root,ListNode right){
        if(root==right) return right;
        reverse(root.next,right).next=root;
        return root;
    }
}