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
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if(node == null) {
            node =  new ListNode(x);
            node.next = node;
            return node;
        }
        //pre cannot set to pull, becasue in line 43, we will get null pointer exception.
        ListNode pre = node;
        ListNode current = node.next;
        // stop loop when we traverse one circle.
        while(current != node) {
        //insert x into regular position， like 1-2-3-x -5
            if(pre.val <= x && current.val >= x ) {
                break;
            }
        //insert x into head or tail
            if(pre.val > current.val &&
               (x > pre.val || x < current.val)) {
                break;
            }
            pre = current;
            current = current.next;
        }
        
        pre.next = new ListNode(x);
        pre.next.next = current;
        
        return current;
    }
}
