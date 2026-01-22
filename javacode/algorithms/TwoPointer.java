package javacode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class TwoPointer {
    private List<Integer> list;

    public TwoPointer(List<Integer> list){
        this.list = list;
    }
    
    /*
    * Using the Two POinter technique, you can find if a pair is in a list.
    * 
    * Steps:
    * 1. Sort list (you can also assume list is sorted, but I want to sort)
    * 2. Start at 0 and the end of the list (left and right)
    * 3. While left is less than right
    *  a. If they sum to the goal ammount, return the pair
    *  b. if the sum is less than the goal, increment left (since the list is sorted)
    *  c. Else decrement right
    * 
    * This algo can also work with triplets to reduce time complexity to O(n^2)
    * 
    * Time complexity: O(n)
    * Space complexity: O(1)
    * 
    * @param k Goal sum
    * @return int[] the pair of values that sum to k
     */
    public List<Integer> findPair(int k){
        List<Integer> output = new ArrayList<>();

        if (list.size() < 2) return output;

        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            if ((list.get(left)+list.get(right)) == k){
                output.add(list.get(left));
                output.add(list.get(right));
                return output;
            } else if ((list.get(left)+list.get(right)) > k){
                right--;
            }
            else{
                left++;
            }
        }
        return output;
    }
}
