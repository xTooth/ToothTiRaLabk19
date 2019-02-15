/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generalizer;

/**
 * An interface to generalize the different types of game states to allow for a
 * single BinaryHeap implementation.
 *
 * @author Toothy
 */
public interface GameState {

    /**
     *
     * @return current state of a game
     */
    int[] getState();

    /**
     *
     * @return score of the state
     */
    int getScore();

    /**
     *
     * @return location of the empty slot
     */
    int getZeroPos();

    /**
     *
     * @return  amount of moves that has been made
     */
    int getNrMovesMade();

    /**
     *
     * @return the moves made so far ( U,D,R,L )
     */
    char[] getMoves();
    
    /**
     *
     * @param other gamestate to compare to
     * @return negative if other gamestate has larger score, otherwise positive.
     */
    int compareTo(GameState other);

}
