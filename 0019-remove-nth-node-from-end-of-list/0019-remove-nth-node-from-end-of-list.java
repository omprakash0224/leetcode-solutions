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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // move fast n+1 ahead
        for(int i = 0; i <= n; i++){
            fast = fast.next;
        }
        // move pointers till fast is null
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        //remove nth node
        slow.next = slow.next.next;
        return dummy.next;
    }
}