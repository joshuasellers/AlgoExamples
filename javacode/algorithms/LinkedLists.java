package javacode.algorithms;

import java.util.LinkedList;

public class LinkedLists {

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

    public void add(int val){
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = new ListNode(val);
    }

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
