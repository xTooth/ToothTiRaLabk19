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
     * clears the current table of trees.
     */
    public void clear() {
        table = new Node[1241];
        size = 0;
    }

    /**
     *
     * @param add the new gameState to be added
     * @param zeroPos location of zero in new gameState
     */
    public void add(int[] add, int zeroPos) {
        if (add != null) {
            if (!contains(add, zeroPos)) {
                int hash = hash(add);
                Node n = table[hash];
                if (n == null) {
                    table[hash] = new Node(add, null, null, zeroPos);
                    size++;
                } else {
                    while (n != null) {
                        if (zeroPos >= n.zeroPos) {
                            if (n.getNextRight() != null) {
                                n = n.getNextRight();
                            } else {
                                n.setNextRight(new Node(add, null, null, zeroPos));
                                break;
                            }
                        } else {
                            if (n.getNextLeft() != null) {
                                n = n.getNextLeft();
                            } else {
                                n.setNextLeft(new Node(add, null, null, zeroPos));
                                break;
                            }
                        }
                    }
                    size++;
                }
            }
        }
    }

    /**
     *
     * @param state GameState that is compared to hashedTable contents.
     * @param zeroPos zeroPosition of node.
     * @return true if the current state has been visited, otherwise false
     */
    public boolean contains(int[] state, int zeroPos) {
        int hash = hash(state);
        Node node = new Node(state, null, null, zeroPos);
        Node n = table[hash];
        if (n == null) {
            return false;
        }
        while (n != null) {
            if (n.equals(node)) {
                return true;
            } else {
                if (zeroPos >= n.getZeroPos()) {
                    n = n.getNextRight();
                } else {
                    n = n.getNextLeft();
                }
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

        private Node nextRight;
        private Node nextLeft;

        private final int[] state;

        private final int zeroPos;

        public Node(int[] state, Node right, Node left, int zeroPos) {
            this.state = state;
            this.nextRight = right;
            this.nextLeft = left;
            this.zeroPos = zeroPos;
        }

        public void setNextRight(Node n) {
            this.nextRight = n;
        }

        public Node getNextRight() {
            return nextRight;
        }

        public Node getNextLeft() {
            return nextLeft;
        }

        public void setNextLeft(Node n) {
            this.nextLeft = n;
        }

        public int getZeroPos() {
            return this.zeroPos;
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
