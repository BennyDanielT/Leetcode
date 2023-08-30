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
    public void reorderList(ListNode head) {

        ListNode slow=head,fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode temp=slow;
        ListNode prev=null,next;

//Reverse the second half of the list
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }

        ListNode head2=prev;

        ListNode head1=head;
        //Now, merge the first half of the list and the reversed list
        while(head1!=null && head2!=null)
        {
            temp=head1.next;
            head1.next=head2;
            head1=temp;
            temp=head2;
            head2=head2.next;       

        }
        
        
    }
}