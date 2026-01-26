package javacode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        callDFSMethods();
        System.out.println("");
        callBFS();
        System.out.println("");
        callBinarySearch();
        System.out.println("");
        callTwoPOinter();
        System.out.println("");
        callSlidingWindow();
        System.out.println("");
        callLinkedLists();
        System.out.println("");
        callHeapArray();
        System.out.println("");
    }

    private static void callDFSMethods() {
        // Example graph represented as an adjacency list
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        graph.put(1, new ArrayList<>(Arrays.asList(0, 3, 4)));
        graph.put(2, new ArrayList<>(Arrays.asList(0)));
        graph.put(3, new ArrayList<>(Arrays.asList(1)));
        graph.put(4, new ArrayList<>(Arrays.asList(1, 5)));
        graph.put(5, new ArrayList<>(Arrays.asList(4)));

        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        System.out.print("Depth-First Search starting from node 0: ");
        dfs.dfs(0);
        System.out.println("\nPath exists between 0 and 5: " + dfs.dfsPathCheck(0, 5));
        System.out.println("Depth-First Search checking for cycle starting at 0: " + dfs.dfsCycleCheck(0));
    }

    private static void callBFS() {
        // Example graph represented as an adjacency list
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        graph.put(0, new ArrayList<>(Arrays.asList(1, 2)));
        graph.put(1, new ArrayList<>(Arrays.asList(0, 3, 4)));
        graph.put(2, new ArrayList<>(Arrays.asList(0)));
        graph.put(3, new ArrayList<>(Arrays.asList(1)));
        graph.put(4, new ArrayList<>(Arrays.asList(1, 5)));
        graph.put(5, new ArrayList<>(Arrays.asList(4)));

        BredthFirstSearch bfs = new BredthFirstSearch(graph);
        System.out.println("Breadth-First Search starting from node 0:");
        bfs.bfs(0);
        System.out.print("\nChecking for path from 0 to 5: ");
        System.out.println(bfs.bfsCheckPath(0,5));
    }

    private static void callBinarySearch() {
        int[] test = {1,2,3,4,5,6,7,8};
        BinarySearch bs = new BinarySearch(test);
        System.out.println("Test array " + Arrays.toString(test));
        System.out.println("Checking if 2 in list: " + (bs.binarySearch(2)==1));
        System.out.println("Checking if 9 in list: " + (bs.binarySearch(9)==1));
    }

    private static void callTwoPOinter(){
        List<Integer> test = new ArrayList<>(Arrays.asList(1,4,6,9,2,4,10));
        TwoPointer tp = new TwoPointer(test);
        System.out.println("Test array " + test.toString());
        System.out.println("Confirming if sum for 11 exists: " + tp.findPair(11));
        System.out.println("Confirming if sum for 20 exists: " + tp.findPair(20));
    }

    private static void callSlidingWindow(){
        List<Integer> test = new ArrayList<>(Arrays.asList(1,4,6,9,2,4,10));
        SlidingWindow sw = new SlidingWindow(test);
        System.out.println("Test array " + test.toString());
        System.out.println("Finding max window of size 3: " + sw.slidingWindow(3));
        System.out.println("Finding max window of size 2: " + sw.slidingWindow(2));
        System.out.println("Finding max window of size 20: " + sw.slidingWindow(20));
    }

    private static void callLinkedLists(){
        LinkedLists ll = new LinkedLists(3);
        ll.add(2);
        ll.add(0);
        ll.add(-4);
        ll.printList();
        System.out.println("Linked list has cycle: " + ll.linkedListHasCycle());
        // Create a cycle for testing
        ll.add(2, ll.head); // Adding a node with value 2 that points to head to create a cycle
        System.out.println("Linked list has cycle: " + ll.linkedListHasCycle());
    }

    private static void callHeapArray() {
        HeapArray heap = new HeapArray(10);
        // Additional heap operations can be called here
        heap.insert(5);
        heap.insert(20);
        heap.insert(15);
        System.out.print("Heap elements after insertions: ");
        heap.printHeap();
    }
}