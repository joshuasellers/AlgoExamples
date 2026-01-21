package javacode.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BredthFirstSearch {
    private Map<Integer, ArrayList<Integer>> adjacencyList;

    public BredthFirstSearch(Map<Integer, ArrayList<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    /*
    * Perform breadth-first search (BFS) on the graph.
    * This algorithm starts at a node and explores all its neighbos.
    * 
    * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    * Space Complexity: O(V) for the queue in the worst case.
    * 
    * Steps:
    * 1. Initialize an empty queue and a set for tracking visited nodes
    * 2. Add the starting node to tthe queue and add it to the visited set
    * 3. While the queue is not empty:
    *  a. Dequeue a node from the queue and mark it as current
    *  b. Iterate through its neightbors:
    *   i. If a neighbor is not visited, mark it as visited and add it to the queue
    *  4. Go until all nodes are visited (the queue is empty again)
    * 
    * @param startNode The starting node for the BFS traversal.
    * @return void
     */
    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while(!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current + " ");
            for (Integer neighbor : adjacencyList.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
