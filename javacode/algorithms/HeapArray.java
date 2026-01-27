package javacode.algorithms;

import java.util.Arrays;

public class HeapArray {
    /*
    * Heap in array representation (min-heap example here).
    * Heap is a complete binary tree that satisfies the heap property.
    * 
    * Note:
    * By default, PriorityQueue is a min-heap in Java HeapQ is the python version
    * 
    * Java example:
    * import java.util.PriorityQueue;
    * PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    * minHeap.offer(1); // inserts element
    * minHeap.poll(); // removes and returns the smallest element
    * minHeap.peek(); // returns the smallest element without removing it
    * 
    * Python example:
    * import heapq
    * heap = [1,2,3,4,5,6]
    * heapq.heapify(heap) # transforms list into a heap in-place
    * heapq.heappop(heap) # pops the smallest element
    * heapq.heappush(heap, 0) # pushes a new element onto the heap
    * 
    * Time complexity for insert and poll is O(log n)
    * Space complexity is O(n) for storing n elements
     */

    private int[] heapArray;
    private int size;

    public HeapArray (int parent){
        heapArray = new int[100];
        heapArray[0] = parent;
        size = 1;
    }

    private void resize(){
        heapArray = Arrays.copyOf(heapArray, heapArray.length * 2);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Insert element into the heap.
     * Steps:
     * 1. Add the element to the end of the array.
     * 2. Compare the added element with its parent; if it's smaller, swap them.
     * 3. Repeat step 2 until the element is in the correct position or it becomes the root.
     * 
     * Time Complexity: O(log n) - due to the potential need to traverse the height of the heap.
     * Space Complexity: O(1) - as it uses a fixed amount of space.
     * 
     * @param element
     * @return void
     */
    public void insert(int element){
        // also called "offer" in Java PriorityQueue
        if(heapArray.length + element == size){
            resize();
        }
        size++;
        int trackingIndex = size - 1;
        heapArray[trackingIndex] = element;
        while (heapArray[parent(trackingIndex)] > element && trackingIndex != 0){
            heapArray[trackingIndex] = heapArray[parent(trackingIndex)];
            heapArray[parent(trackingIndex)] = element;
            trackingIndex = parent(trackingIndex);
        }
    }

    /**
     * Remove and return the top element of the heap (the smallest element in a min-heap).
     * Steps:
     * 1. Replace the root of the heap with the last element in the array.
     * 2. Compare the new root with its children; if it's larger than either child, swap it with the smaller child.
     * 3. Repeat step 2 until the element is in the correct position or it becomes a leaf.
     * 
     * Time Complexity: O(log n) - due to the potential need to traverse the height of the heap.
     * Space Complexity: O(1) - as it uses a fixed amount of space.
     * 
     * @return The top element of the heap.
     */
    public int poll(){
        int output = heapArray[0];
        heapArray[0] = heapArray[size-1];
        size--;

        int trackingIndex = 0;
        if (size == 2){
            if (heapArray[0] > heapArray[1]){
                int temp = heapArray[0];
                heapArray[0] = heapArray[1];
                heapArray[1] = temp;
            }
            return output;
        }
        while (trackingIndex < size && (leftChild(trackingIndex) < size && rightChild(trackingIndex) < size) &&
            (heapArray[trackingIndex] > heapArray[leftChild(trackingIndex)] || heapArray[trackingIndex] > heapArray[rightChild(trackingIndex)])){
                int temp = heapArray[trackingIndex];
                if (heapArray[trackingIndex] - heapArray[leftChild(trackingIndex)] > heapArray[trackingIndex] - heapArray[rightChild(trackingIndex)]){
                    heapArray[trackingIndex] = heapArray[leftChild(trackingIndex)];
                    heapArray[leftChild(trackingIndex)] = temp;
                    trackingIndex = leftChild(trackingIndex);
                } else{
                    heapArray[trackingIndex] = heapArray[rightChild(trackingIndex)];
                    heapArray[rightChild(trackingIndex)] = temp;
                    trackingIndex = rightChild(trackingIndex);
                }
        }
        return output;
    }

    /**
     * Return the top element of the heap without removing it.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     * 
     * @return The top element of the heap.
     */
    public int peek(){
        return heapArray[0];
    }

    /**
     * Convert an arbitrary array into a valid heap.
     * Steps:
     * 1. Start from the index of the last non-leaf node and move upwards to the root.
     * 2. For each node, compare it with its children; if it's larger than either child, swap it with the smaller child.
     * 3. Repeat step 2 until the element is in the correct position or it becomes a leaf.
     * 4. Decrement the index and repeat steps 2-4 until the root is processed.
     * 
     * Time Complexity: O(n) - building a heap from an array is linear in the number of elements.
     * Space Complexity: O(1) - as it uses a fixed amount of space.
     * @param newArray
     */
    public void heapify(int[] newArray){
        heapArray = newArray;
        size = newArray.length;

        if (size == 1){
            return;
        } else if (size == 2){
            if (heapArray[0] > heapArray[1]){
                int temp = heapArray[0];
                heapArray[0] = heapArray[1];
                heapArray[1] = temp;
            }
            return;
        }
        int indexOfFirstNonLeaf = parent(size - 1);
        for (int i = indexOfFirstNonLeaf; i >= 0; i--){
            int trackingIndex = i;
            while (trackingIndex < size && (leftChild(trackingIndex) < size && rightChild(trackingIndex) < size) &&
            (heapArray[trackingIndex] > heapArray[leftChild(trackingIndex)] || heapArray[trackingIndex] > heapArray[rightChild(trackingIndex)])){
                int temp = heapArray[trackingIndex];
                if (heapArray[trackingIndex] - heapArray[leftChild(trackingIndex)] > heapArray[trackingIndex] - heapArray[rightChild(trackingIndex)]){
                    heapArray[trackingIndex] = heapArray[leftChild(trackingIndex)];
                    heapArray[leftChild(trackingIndex)] = temp;
                    trackingIndex = leftChild(trackingIndex);
                } else{
                    heapArray[trackingIndex] = heapArray[rightChild(trackingIndex)];
                    heapArray[rightChild(trackingIndex)] = temp;
                    trackingIndex = rightChild(trackingIndex);
                }
            }
        }
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println("");
    }

    public void prettyPrintHeap(){
        int elementsInLevel = 1;
        int centerSpace = 4;
        int index = 0;
        while (index < size){
            for (int i = 0; i < elementsInLevel && index < size; i++){
                for (int j = 0; j < centerSpace; j++){
                    System.out.print(" ");
                }
                System.out.print(heapArray[index] + " ");
                index++;
                for (int j = 0; j < centerSpace; j++){
                    System.out.print(" ");
                }
            }
            System.out.println("");
            elementsInLevel *= 2;
            centerSpace = Math.max(1, centerSpace / 2);
        }
    }

    // Example problems using heap

    /**
     * Find the top K largest elements in an array.
     * Steps:
     * 1. Create a min-heap with the first K elements of the array.
     * 2. Iterate through the remaining elements of the array.
     * 3. For each element, if it's larger than the root of the min-heap, replace the root with this element and heapify.
     * 4. After processing all elements, the min-heap will contain the top K largest elements.
     * 
     * Time Complexity: O(n log k) - where n is the number of elements in the array and k is the number of top elements to find.
     * Space Complexity: O(k) - for storing the top K elements in the heap.
     * @param arr
     * @param k
     * @return
     */
    public int[] topKElements(int[] arr, int k){
        if(arr.length == k) return arr;

        int[] subArray = Arrays.copyOfRange(arr, 0, k);
        heapify(subArray);
        for (int i = k; i < arr.length; i++){
            if (arr[i] > peek()){
                poll();
                insert(arr[i]);
            }
        }
        return heapArray;
    }
}
