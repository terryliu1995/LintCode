/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        //this problem can divide into 3 small problems
        //1.find kth listnode 
        //2.reverse firt k listnodes
        //3.connect first k listnode with the last n-k nodes
        //4.loop until the number of left nodes is less than k.
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        //keep reversing until the number of left nodes is less than k
        while (true) {
            head = reverseK(head, k);
            if (head == null) {
                break;
            }
        }
        
        return dummy.next;
    }
    
    public ListNode reverseK(ListNode head, int k) {
        //find kth node
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            if (nk == null) {
                return null;
            }
            nk = nk.next;
        }
        
        if (nk == null) {
            return null;
        }
        
        // reverse        
        ListNode n1 = head.next;
        ListNode nkplus = nk.next; 
        
        ListNode prev = null;
        ListNode curt = n1;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // connect
        head.next = nk;
        n1.next = nkplus;
        return n1;
    }
}
