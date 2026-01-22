package javacode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        callDFSMethods();
        System.out.println("");
        callBFS();
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
        System.out.println("Depth-First Search starting from node 0:");
        dfs.dfs(0);
        System.out.println("");
        System.out.println("\nPath exists between 0 and 5: " + dfs.dfsPathCheck(0, 5));
        System.out.println("");
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
    }
}