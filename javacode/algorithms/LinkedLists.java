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
