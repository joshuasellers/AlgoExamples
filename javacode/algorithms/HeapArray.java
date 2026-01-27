package javacode.algorithms;

import java.util.Arrays;

public class HeapArray {
    // Heap in array representation
    // By default, PriorityQueue is a min-heap in Java HeapQ is the python version
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

    public void heapify(int[] newArray){
        heapArray = newArray;
        size = newArray.length;

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
        int level = 0;
        int elementsInLevel = 1;
        int index = 0;
        while (index < size){
            for (int i = 0; i < elementsInLevel && index < size; i++){
                System.out.print(heapArray[index] + " ");
                index++;
            }
            System.out.println("");
            level++;
            elementsInLevel *= 2;
        }
    }
}
