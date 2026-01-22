package javacode.algorithms;

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
    * 1. Get the middle of the array from it's length and 0 (set those to low and high)
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
}
