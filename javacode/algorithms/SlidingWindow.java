package javacode.algorithms;

import java.util.List;

public class SlidingWindow {
    private List<Integer> list;

    public SlidingWindow(List<Integer> list){
        this.list = list;
    }

    /*
    * This algo runs a sliding window over a list to find a goal.
    * Consider using the sliding window pattern for questions that 
    * involve searching for a continuous subarray/substring in an array 
    * or string that satisfies a certain constraint.
    * 
    * Time complexity: O(n)
    * Size complexity: O(1)
    * 
    * Steps:
    * 1. Initialize your list with a left and right value
    * 2. Increment the right value until you've reached the desired window width
    *  a. now also increment the left value
    * 3. Update your window total each time you increment (only sum it iteratively once)
    * 
    * @param k width of the window
    * @return int 
    */
    public int slidingWindow(int k){
        int maxSum = Integer.MIN_VALUE;
        int window = 0;
        int left = 0;
        if (list.size() < k) return maxSum;

        for(int i = 0; i < list.size(); i++){
            if(i - left + 1 == k){
                if(maxSum == Integer.MIN_VALUE){
                    for(int j = left; j <= i; j++){
                        window += list.get(j);
                    }
                    maxSum = window;
                } else{
                    window = window + list.get(i) - list.get(left - 1);
                    maxSum = Math.max(window, maxSum);
                }
                left++;
            }
        }

        return maxSum;
    }
}
