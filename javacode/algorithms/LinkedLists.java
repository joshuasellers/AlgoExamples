package javacode.algorithms;


public class LinkedLists {
    // In java, the LinkedList class is built-in, but we will create our own for demonstration.

    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode() {}
        public ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }
    public ListNode head;

    public LinkedLists(int val){
        this.head = new ListNode(val);
    }

    /*
    * Add a new node with the given value to the end of the linked list.
    *
    * Steps:
    * 1. Create a new node with the given value.
    * 2. Traverse the list to find the last node.
    * 3. Set the next pointer of the last node to the new node.
    *
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    * 
    * @param val The value to be added to the linked list.
    * @return void
     */
    public void add(int val){
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }

    /**
     * Add a new node with the given value before the specified node.
     *
     * Steps:
     * 1. Create a new node with the given value.
     * 2. Traverse the list to find the specified node.
     * 3. Set the next pointer of the new node to the specified node.
     * 4. Set the next pointer of the previous node to the new node.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param val The value to be added to the linked list.
     * @param node The node before which the new node will be inserted.
     * @return void
     */
    public void add(int val, ListNode node){
        ListNode newNode = new ListNode(val, node);
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void printList(){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    /*
    * Detect if a linked list has a cycle using Floyd's Tortoise and Hare algorithm.
    * This algorithm uses two pointers that move at different speeds.
    * If there is a cycle, the fast pointer will eventually meet the slow pointer.
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    * 
    * Steps:
    * 1. Initialize two pointers, fast and slow, both starting at the head of the list.
    * 2. Move the slow pointer one step at a time and the fast pointer two steps at a time.
    * 3. If there is a cycle, the fast pointer will eventually meet the slow pointer.
    * 4. If the fast pointer reaches the end of the list (null), then there is no cycle.
    * 
    * @return boolean True if a cycle exists, false otherwise
     */
    public boolean linkedListHasCycle(){
        boolean hasCycle = false;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }
    
}
