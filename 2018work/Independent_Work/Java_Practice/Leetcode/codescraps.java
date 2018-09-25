/**
 * 
 Code Scraps
 Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}

//Source
//https://leetcode.com/problems/roman-to-integer/description/


class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]=='I'){
                result++;
            }
            else if (arr[i]=='V'){
                result+=5;
            }
            else if (arr[i]=='X'){
                result+=10;
            }
            else if (arr[i]=='L'){
                result+=50;
            }
            else if (arr[i]=='C'){
                result+=100;
            }
            else if (arr[i]=='D'){
                result+=500;
            }
            else if (arr[i]=='M'){
                result+=1000;
            }
            //need to double up to account for our previous free addition
            if(i!=0){
                if(arr[i-1]=='I' && arr[i]=='V'){
                    result-=2;
                }
                else if(arr[i-1]=='I' && arr[i]=='X'){
                    result-=2;
                }
                else if(arr[i-1]=='X' && arr[i]=='L'){
                    result-=20;
                }
                else if(arr[i-1]=='X' && arr[i]=='C'){
                    result-=20;
                }
                else if(arr[i-1]=='C' && arr[i]=='D'){
                    result-=200;
                }
                else if(arr[i-1]=='C' && arr[i]=='M'){
                    result-=200;
                }
            }
        }
        return result;
    }
}

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