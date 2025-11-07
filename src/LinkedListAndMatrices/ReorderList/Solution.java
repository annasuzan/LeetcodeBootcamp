package LinkedListAndMatrices.ReorderList;

class ListNode{
    int val;
    ListNode next;
}
public class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null){
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;

        while (fast != null && fast.next != null){
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prevSlow!=null){
            prevSlow.next = null;
        }

        ListNode prev = null;
        while (slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode left = head;
        ListNode right = prev;

        left = head;
        right = prev;
        while(left!= null && right != null){
            ListNode leftNext = left.next;
            left.next = right;
            ListNode rightNext = right.next;
            right.next = leftNext;
            prev = right;
            left = leftNext;
            right = rightNext;
        }


        if(right != null){
            prev.next = right;

        }

    }
}
