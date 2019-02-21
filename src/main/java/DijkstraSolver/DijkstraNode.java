/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DijkstraSolver;

import Generalizer.GameState;

/**
 *
 * @author Toothy
 */
public class DijkstraNode implements GameState{
    
    private int[] state;
    private int score;
    private int zeroPos; 
    private int nrMovesMade;
    private char[] movesMade;

    /**
     *
     * @param state current GameState
     * @param score current custom weighted score for this gamestate ( based on current distance from goal)
     * @param zeroPos location of empty space
     * @param nrMovesMade amount of moves made
     * @param movesMade the moves made represented by U;D;R;L;
     */
    public DijkstraNode(int[] state, int score, int zeroPos, int nrMovesMade, char[] movesMade) {
        this.state = state;
        this.score = score;
        this.zeroPos = zeroPos;
        this.nrMovesMade = nrMovesMade;
        this.movesMade = movesMade;
    }
    
    

    @Override
    public int[] getState() {
        return this.state;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public int getZeroPos() {
        return this.zeroPos;
    }

    @Override
    public int getNrMovesMade() {
        return nrMovesMade;
    }

    @Override
    public char[] getMoves() {
        return movesMade;
    }

    @Override
    public int compareTo(GameState other) {
        return this.score-other.getScore();
    }
    
}
