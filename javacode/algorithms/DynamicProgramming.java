package javacode.algorithms;

import java.util.Arrays;

public class DynamicProgramming {
    /**
     * Dynamic programming refers to a method for solving complex problems by breaking them down into simpler subproblems.
     * It is applicable when the subproblems overlap, meaning that the same subproblems are solved multiple times.
     * 
     * A common technique is called memoization, where you store the results of 
     * expensive function calls and reuse them when the same inputs occur again.
     */
    public DynamicProgramming() {
    }

    /**
     * Dynamic programming approach to calculate Fibonacci numbers using memoization. Naive recursive approach 
     * has exponential time complexity due to repeated calculations.
     * 
     * Steps:
     * 1. Create an array to store computed Fibonacci values (memoization).
     * 2. Initialize the array with a sentinel value (e.g., -1) to indicate uncomputed values.
     * 3. Use a recursive helper function that checks if the value is already computed:
     *   a. In recursive function:
     *      1. If not computed, calculate it using the Fibonacci formula
     *      2. Store the computed value in the memoization array.
     *      3. Return the computed value once you reach the desired depth.
     * 
     * Time Complexity: O(n) where n is the depth of the Fibonacci number to compute.
     * Space Complexity: O(n) for the memoization array.
     * 
     * @param depth
     * @return int Fibonacci number at the given depth
     */
    public int fibonacci(int depth){
        int[] memo = new int[depth];
        for (int i = 0; i < memo.length; i++){
            memo[i] = -1;
        }
        int out = fibRecursive(0, depth, memo);
        System.out.println("Memoization array: " + Arrays.toString(memo));
        return out;
    }

    public int fibRecursive(int currDepth, int depth, int[] memo){
        if (currDepth >= depth){
            return memo[depth-1];
        }
        else {
            if (memo[currDepth] == -1){
                if(currDepth == 0){
                    memo[currDepth] = 0;
                } else if(currDepth == 1){
                    memo[currDepth] = 1;
                } else{
                    memo[currDepth] = memo[currDepth-1] + memo[currDepth-2];
                }
            }
            return fibRecursive(currDepth+1, depth, memo);
        }
    }
    
}
