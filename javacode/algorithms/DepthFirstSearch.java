package javacode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepthFirstSearch {

    private Map<Integer, ArrayList<Integer>> adjacencyList;

    public DepthFirstSearch(Map<Integer, ArrayList<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    /*
    * Perform depth-first search (DFS) on the graph.
    * A graph traversal algorithm that starts at a node and
    * explores as far away as possible along each branch recursively.
    * 
    * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
    * Space Complexity: O(V) for the recursion stack in the worst case.
    * 
    * Steps:
    * 1. Initialize a hashset to track visited nodes.
    * 2. Create a recursuive DFS function that also takes the visited set as a parameter.
    * 3. Add the current node to the visited set
    * 4. For its neighbors: recursively call the function if they have not been visited.
    * 5. Continue until all reachable nodes have been visited.
    * 
    * @param node The starting node for the DFS traversal.
    * 
    * @return void
    */
    public void dfs(int node){
        Map<Integer, Boolean> visited = new HashMap<>();
        dfsRecursive(node, visited);
    }

    private void dfsRecursive(int node, Map<Integer, Boolean> visited){
        // Mark the current node as visited
        visited.put(node,true);
        System.out.print(node + " ");
        // Now recurse on all neighbor nodes
        for (Integer neighbor: adjacencyList.get(node)){
            if(!visited.getOrDefault(neighbor, false)){
                dfsRecursive(neighbor, visited);
            }
        }
    }

    /*
    * Use DFS to check if a path exists between two nodes in a graph
    * To modify the standard DFS setup, have a start and end node
    * and in the dfs recursion, check if they equal each other.
    * If they do, return true. If the recursion ends without finding it,
    * return false.
    * 
    * @param start The starting node
    * @param end The target node
    * @return boolean True if a path exists, false otherwise
     */
    public boolean dfsPathCheck(int start, int end) {
        Map<Integer, Boolean> visited = new HashMap<>();
        return dfsPathCheckRecursive(start, end, visited);
    }

    private boolean dfsPathCheckRecursive(int node, int end, Map<Integer, Boolean> visited) {
        if(node == end) {
            return true;
        }
        System.out.println("Visiting node: " + node);
        System.out.println("Neighbors: " + adjacencyList.get(node));
        // Mark the current node as visited
        visited.put(node,true);
        // Now recurse on all neighbor nodes
        boolean foundPath = false;
        for (Integer neighbor: adjacencyList.get(node)){
            if(!visited.getOrDefault(neighbor, false)){
                foundPath = foundPath ||dfsPathCheckRecursive(neighbor, end, visited);
            }
        }
        return foundPath;
    }
}
