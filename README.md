## Contents
This is a package of misc algorithm problems in Java and Python. This is used to provide example code for various algorithmic challenges and solutions. The problems covered include string manipulation, array processing, sorting algorithms, and other common algorithmic tasks.

The goal is to be better prepared for coding interviews, competitive programming, and general algorithmic problem solving by having a repository of solved problems and code examples in both Java and Python.

## Interview Preparation
This package is designed to help with interview preparation by providing solved examples of common algorithmic problems.

Things to look for from an interview question:
1. Problem constraints and requirements -> this can help indicate which algorithms or data structures to use
  a. Example: if you need to find the shortest path in a graph with non-negative weights, Dijkstra's algorithm is a good choice.
2. Input and output formats -> understanding how data is represented can help with parsing and processing
  a. Example: if the input is a list of integers, you can use array-based algorithms.
3. Edge cases and examples -> considering edge cases can help ensure your solution is robust
  a. Example: if the input can be empty or contain duplicates, make sure your algorithm handles those cases.
4. Optimal solutions and their trade-offs -> understanding the trade-offs between different algorithms can help you choose the best one for the problem
  a. Example: if you need a fast solution, you might choose a greedy algorithm over a dynamic programming approach.
5. Time and space complexity analysis -> analyzing the time and space complexity of your solution can help you understand its efficiency
  a. Example: if your algorithm has a time complexity of O(n log n), it may not be suitable for very large inputs.

What each of the algorithms solve (to help with interview prep):
- Binary Search: Efficiently finds the position of a target value within a sorted array.
- Bredth-First Search (BFS): Explores all neighbors at the present depth prior to moving on to nodes at the next depth level in a graph or tree. Good for finding the shortest path in unweighted graphs.
- Depth-First Search (DFS): Explores as far as possible along each branch before backtracking. Useful for pathfinding and topological sorting.
- Dynamic Programming: Solves complex problems by breaking them down into simpler subproblems and storing the results of subproblems to avoid redundant computations.
- Linked Lists: A linear data structure where each element points to the next, allowing for efficient insertions and deletions.
- Heaps: A specialized tree-based data structure that satisfies the heap property, useful for implementing priority queues.
- Sliding Window: A technique for solving problems that involve finding a subarray or substring that satisfies certain conditions, by maintaining a window that slides over the data structure.
- Two Pointers: A technique that uses two pointers to traverse a data structure, often used for problems involving sorted arrays or linked lists.

Data Characteristics:
- Sorted data or the need for efficient searching: This often points towards Binary Search or related techniques.
- Tree or graph problems: Consider Depth-First Search (DFS) or Breadth-First Search (BFS) traversals.
- Optimization or finding a best/maximum/minimum value: Look for problems that can be solved with a Greedy Algorithm, Dynamic Programming, or possibly Dijkstra's/similar pathfinding if a grid is involved.
- Sequence/array problems involving subarrays or contiguous segments: A Sliding Window technique might be appropriate.
- Counting frequencies or checking existence quickly: A Hash Map/Set is usually efficient.
Problem Clues:
- "Find the shortest path" in a grid/graph: Likely a graph algorithm like BFS or A*.
- "Find all permutations/subsets" or problems with many possible combinations: This often requires Backtracking or Recursion.
- "Process elements in a specific order" (e.g., by size/priority): Consider using a Heap/Priority Queue.
- "Modify an array in-place" with pointers: The Two Pointers approach is common.


## License
This code is licensed under the MIT License. You are free to use, modify, and distribute this code as long as you include the original license and copyright notice.
