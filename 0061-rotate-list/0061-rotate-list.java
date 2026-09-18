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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode last = head;

        while (last.next != null) {
            last = last.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        last.next = head;
        int steps = length - k;
        ListNode newLast = head;

        for (int i = 1; i < steps; i++) {
            newLast = newLast.next;
        }

        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }
}