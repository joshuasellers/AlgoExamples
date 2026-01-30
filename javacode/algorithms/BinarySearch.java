package javacode.algorithms;

import java.util.Arrays;

public class BinarySearch {
    private int[] inputList;

    public BinarySearch(int[] inputList){
        this.inputList = inputList;
    }

    /*
    * Binary search runs on an input list.
    * The list must be sorted for this alorithm to work.
    * 
    * Time complexity is O(log n) - assuming you get a sorted list
    * Space complexity is O(1) - since you make no new data types
    * 
    * Steps:
    * 1. Get the middle of the array, its length and 0 (set those final two numbers to low and high)
    * 2. While low <= high
    *   a. If arr[mid] equals the goal int, return that index
    *   b. If arr[mid] is less than the goal, update low to mid + 1 and loop again
    *   c. If arr[mid] is greater than the goal, update high to mid - 1 and loop again
    */
    public int binarySearch(int target){
        int low = 0;
        int high = inputList.length - 1;
        while (low <= high){
            int mid = (high + low)/2;
            if (inputList[mid] == target){
                return mid;
            } else if(inputList[mid] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Given an array of integers representing the number of apples on each tree,
     * and an integer h representing the number of hours available to harvest,
     * return the minimum integer k such that all apples can be harvested within h hours.
     * You can harvest k apples from a tree in one hour. If a tree has less than k apples,
     * you can only harvest all the apples from that tree in one hour.
     * 
     * Steps:
     * 1. Set left to 1 and right to the maximum number of apples on the largest tree.
     * 2. While left is less than right:
     *    a. Calculate mid as the average of left and right.
     *    b. Calculate the total time taken to harvest all apples at rate mid.
     *    c. If the time taken is greater than h, set left to mid + 1.
     *    d. Otherwise, set right to mid. -> this will allow us to center at the point where timeTaken == h and anything less than that is too slow
     * 3. Return mid as the minimum harvest rate.
     * 
     * Time Complexity: O(n log m) - where n is the number of trees (length of apples array) and m is the maximum number of apples on a tree
     * Space Complexity: O(1) - no additional data structures used
     * @param apples
     * @param h
     * @return
     */
    public Integer minHarvestRate(int[] apples, Integer h) {
        int left = 1;
        int right = Arrays.stream(apples).max().getAsInt();
        int mid = (left + right) / 2;


        while (left < right){
            int t = timeTaken(mid, apples);
            if (t > h){
                left = mid + 1;
                mid = (left + right) / 2;
            } else {
                right = mid;
                mid = (left + right) / 2;
            }
            
        }
        return mid;
    }

    /**
     * Helper function to calculate time taken to harvest all apples at a given rate.
     * 
     * Steps:
     * 1. Initialize time to 0.
     * 2. For each tree in apples:
     *    a. Calculate the time taken to harvest that tree at the given rate.
     *     1. If apples[i] is divisible by rate, add apples[i]/rate to time.
     *     2. Otherwise, add (apples[i]/rate) + 1 to time.
     * 3. Return the total time.
     * 
     * Time Complexity: O(n) - where n is the number of trees (length of apples array)
     * Space Complexity: O(1) - no additional data structures used
     * 
     * @param rate
     * @param apples
     * @return
     */
    public int timeTaken(int rate, int[] apples){
        int time = 0;
        for (int i = 0; i < apples.length; i++){
            time += (apples[i] % rate == 0) ? (apples[i]/rate) : ((apples[i]/rate) + 1);
        }
        return time;
    }
}
