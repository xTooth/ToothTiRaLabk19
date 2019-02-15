/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Toothy
 */
public class HashingishTable {

    private Node[] table;
    private int size;

    /**
     * Size is determined by largest possible hash for an array in a 4x4 puzzle.
     * This is very use case specific.
     */
    public HashingishTable() {
        table = new Node[1241];
        size = 0;
    }

    /**
     * clears the current table of linkedlists.
     */
    public void clear() {
        table = new Node[1241];
        size = 0;
    }

    /**
     *
     * @param add the new gameState to be added
     */
    public void add(int[] add) {
        if (add != null) {
            if (!contains(add)) {
                int hash = hash(add);
                Node n = table[hash];
                if (n == null) {
                    table[hash] = new Node( add, null);
                    size++;
                } else {
                    while (n.getNext() != null) {
                        n = n.getNext();
                    }
                    n.setNext(new Node( add, null));
                    size++;
                }
            }
        }
    }

    /**
     *
     * @param state GameState that is compared to hashedTable contents.
     * @return true if the current state has been visited, otherwise false
     */
    public boolean contains(int[] state) {
        int hash = hash(state);
        Node node = new Node(state, null);
        Node n = table[hash];
        if (n == null) {
            return false;
        }
        while (n != null) {
            if (n.equals(node)) {
                return true;
            } else {
                n = n.getNext();
            }
        }
        return false;
    }

    private int hash(int[] state) {
        int hash = 0;
        for (int i = 0; i < state.length; i++) {
            hash = hash + (state[i] * i);
        }
        return hash;
    }

    /**
     *
     * @return returns current amount of stored states.
     */
    public int getSize() {
        return size;
    }

    private class Node {

        private Node next;
        
        private final int[] state;

        public Node(int[] state, Node next) {
            this.state = state;
            this.next = next;
        }

        public void setNext(Node n) {
            this.next = n;           
        }

        public Node getNext() {
            return next;
        }

        public boolean equals(Node other) { 
            for (int i = 0; i < 16; i++) {
                if (this.state[i] != other.state[i]) {
                    return false;
                }
            }

            return true;
        }

    }

}
