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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};

        // Need at least 3 nodes to form a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        int index = 1; // Position tracker (starting from 1 for second node)
        int firstCritical = -1; // First critical point index
        int prevCritical = -1;  // Previous critical point index
        int minDist = Integer.MAX_VALUE; // Track minimum distance

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {
            int nextVal = curr.next.val;

            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > nextVal) || 
                (curr.val < prev.val && curr.val < nextVal)) {
                
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDist = Math.min(minDist, index - prevCritical);
                    result[1] = index - firstCritical; // max distance
                }
                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (result[1] == -1) return result; // No valid critical points
        result[0] = minDist;
        return result;
    }
}