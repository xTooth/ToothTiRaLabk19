/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Generalizer.GameState;

/**
 * A binary heap to replace the default priorityQueue. This is specifically used
 * to store gameStates, and will not work using other inputs.
 * source for the concept of the code: https://www.sanfoundry.com/java-program-implement-binary-heap/
 * @author Toothy
 */
public class BinaryHeapThingy {
    private final int nmbrOfChildren;
    private GameState[] states;
    private int heapSize;

    /**
     * initializes new BinaryHeap for gamestates.
     */
    public BinaryHeapThingy() {
        states = new GameState[10];
        heapSize = 0;
        nmbrOfChildren = 2;
    }
    

    /**
     *
     * @param newState the game state to be added
     */
    public void add(GameState newState) {
        if (heapSize >= states.length - 1) {
            doubleHeapSize();
        }
        heapSize++;
        states[heapSize-1] = newState;
        heapifyUp(heapSize - 1);
    }
   
    /**
     *
     * @return the "smallest" element in the list. (the element with the lowest score)
     */
    public GameState poll() {
        if (heapSize < 1) {
            return null;
        }
        if (heapSize == 1) {
            heapSize--;
            GameState tmp = states[0];
            states[0] = null;
            return tmp;
        }

        GameState tmp = states[0];
        states[0] = states[heapSize - 1];
        heapSize--;
        heapifyDown(0);

        if (heapSize <= (states.length - 1) / nmbrOfChildren) {
            splitHeapSize();
        }
        return tmp;

    }
    
    public GameState peek(){
        return states[0];
    }

    /**
     * empties and resets heap.
     */
    public void clear() {
        states = new GameState[10];
        heapSize = 0;
    }

    /**
     *
     * @return returns true if heap is empty
     */
    public boolean isEmpty(){
        return heapSize == 0;
    }
    
    /**
     * Handles overflow situations, by doubling size of the heap.
     */
    private void doubleHeapSize() {
        GameState[] newStates = new GameState[states.length * nmbrOfChildren];
        for (int i = 0; i < states.length; i++) {
            newStates[i] = states[i];

        }
        states = newStates;
    }
    
    /**
     * Handles memory halving if excess space is found.
     */
    private void splitHeapSize() {
        GameState[] newStates = new GameState[states.length / nmbrOfChildren];
        for (int i = 0; i < newStates.length; i++) {
            newStates[i] = states[i];
        }
        states = newStates;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / nmbrOfChildren;
    }

    private int getNthChildIndex(int parentIndex, int n) {
        return nmbrOfChildren * parentIndex + n;
    }

    private void heapifyDown(int startIndex) {
        int child;
        GameState tmp = states[startIndex];
        while (getNthChildIndex(startIndex, 1) < heapSize) {
            child = minChild(startIndex);
            if (states[child].getScore() < tmp.getScore()) {
                states[startIndex] = states[child];
            } else {
                break;
            }
            startIndex = child;
        }
        states[startIndex] = tmp;
    }

    private void heapifyUp(int childIndex) {
        GameState tmp = states[childIndex];
        while (childIndex > 0 && tmp.getScore() < states[getParentIndex(childIndex)].getScore()) {
            states[childIndex] = states[getParentIndex(childIndex)];
            childIndex = getParentIndex(childIndex);
        }
        states[childIndex] = tmp;
    }

    private int minChild(int index) {
     int bestChild = getNthChildIndex(index, 1);
        int k = nmbrOfChildren;
        int pos = getNthChildIndex(index, k);
        while ((k <= nmbrOfChildren) && (pos < heapSize)) 
        {
            if (states[pos].getScore() < states[bestChild].getScore()) 
                bestChild = pos;
            pos = getNthChildIndex(index, k++);
        }    
        return bestChild;
    }
    
    /**
     *
     * @return the amount of elements in the heap.
     */
    public int size(){
        return heapSize;
    }
}
