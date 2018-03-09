/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        //using a map to store the relationshop between old_node and new_node,
        //when traversing the original list, execute deep copy 
        //get newnode from map with oldnode
        //Time complexity is O(n), Space Complexity is o(n)
        if (head == null) {
            return null;
        }
        //HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;//pre is for copy next relationship
        RandomListNode newNode;//newNode for deep copying newnode from oldnode
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while(head != null){ //construct relationship
            
            if(map.containsKey(head)){
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
           
            pre.next = newNode; //copy next relationship;
            // copy random relationship;
            if(head.random != null) {
               if(map.containsKey(head.random)) {
                    newNode.random = map.get(head.random);
                } else {
                    newNode.random= new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                } 
            }
            //prepareing for next loop
            pre = newNode;
            head = head.next;   
        }
         return dummy.next;   
        
    }
}
