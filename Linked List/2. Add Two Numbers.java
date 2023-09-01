/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1, head2 = l2;
        int sum, digit, digit1, digit2;
        int carry = 0;
        ListNode sumHead = new ListNode();
        ListNode temp = sumHead;

        while (head1 != null || head2 != null || carry > 0) {
            digit1 = (head1 == null) ? 0 : head1.val;
            digit2 = (head2 == null) ? 0 : head2.val;
            sum = digit1 + digit2 + carry;
            digit = sum % 10;
            carry = sum / 10;

            ListNode nextNode = new ListNode(digit);
            temp.next = nextNode;
            temp = temp.next;
            head1 = (head1 != null) ? head1.next : null;
            head2 = (head2 != null) ? head2.next : null;
        }

        temp.next = null;
        return sumHead.next;
    }
}