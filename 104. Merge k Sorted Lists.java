/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0) {
            return null;
        }
        int k = lists.size();
        // maintain a miniheap, put first elements of k lists, and poll the smallest one.
        PriorityQueue<ListNode> miniHeap = new PriorityQueue<>(k, new Comparator<ListNode>(){
            //override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        //put the first elements of k lists into miniheap
        for(int i = 0; i < k; i ++) {
            if(lists.get(i) != null) {
                miniHeap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while(!miniHeap.isEmpty()) {
            //get the smallest one
            ListNode node = miniHeap.poll();
            cursor.next = node;
            cursor = node;
            if(node.next != null) {
                miniHeap.add(node.next);
            }
        }
        return dummy.next;
    }
}
// Time complexity is O(n + k);
//space complexity is O(n + k)
