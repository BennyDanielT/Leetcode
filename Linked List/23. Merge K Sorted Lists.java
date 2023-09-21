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
    public ListNode mergeKLists(ListNode[] lists) 
    {
        int size = lists.length;
        int interval = 1;
        if(lists==null || size==0)
        {
            return null;
        }


        while(interval<size)
        {
            for(int i=0;i<size-interval;i+=(2*interval)) //Sexy Maths Operation
            {
                ListNode l1=lists[i];
                ListNode l2=i+1<size?lists[i+1]:null;
                lists[i]=mergeLists(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }

    public ListNode mergeLists(ListNode l1, ListNode l2)
    {
        ListNode facilitatorNode = new ListNode();
        ListNode head = facilitatorNode;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                head.next=l1;
                l1=l1.next;
            }
            else
            {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;

        }
        if(l1!=null)
            head.next=l1;
        if(l2!=null)
            head.next=l2;
        return facilitatorNode.next;
    }
}