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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode curr = head;
        while(curr.next != null){
            ListNode temp = curr.next;
            if(curr.val == temp.val){
                curr.next = temp.next;
            }else{
                curr = temp;
            }
        }
        return head;
    }
}