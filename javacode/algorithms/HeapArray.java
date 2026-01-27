package javacode.algorithms;

import java.util.Arrays;

public class HeapArray {
    // Heap in Node setup and array representation
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

    public void insert(int element){
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


    public int poll(){
        int output = heapArray[0];
        heapArray[0] = heapArray[size-1];
        size--;

        int trackingIndex = 0;

        
        while (trackingIndex < size && 
            (heapArray[trackingIndex] > heapArray[leftChild(trackingIndex)] || heapArray[trackingIndex] > heapArray[leftChild(trackingIndex)])){
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

    public int peek(){
        return heapArray[0];
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            System.out.print(heapArray[i] + " ");
        }
        System.out.println("");
    }
}
