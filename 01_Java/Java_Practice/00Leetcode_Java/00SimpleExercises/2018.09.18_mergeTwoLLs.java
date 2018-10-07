
//https://leetcode.com/problems/merge-two-sorted-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {    
        ListNode nNode = new ListNode(-1);
        ListNode newhead = nNode;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                nNode.next = l1;
                l1 = l1.next;
            }
            else {
                nNode.next = l2;
                l2 = l2.next;
            }
            //moves our list along through the itteration
            nNode = nNode.next; 
        }
        //Handles any nodes that got left behind
        while (l1 != null){
            nNode.next = l1;
            nNode = nNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            nNode.next = l2;
            nNode = nNode.next;
            l2 = l2.next;
        }
        
        //Gets rid of the dummy node
        return newhead.next;
    }
    
}