/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolverBFS;

import Generalizer.GameState;
import java.util.ArrayList;

/**
 *
 * @author tooth
 */
class GameStateBFS implements Comparable<GameStateBFS>, GameState{
       
    private int[] state;
    private char[] moves;
    private int zeroPosition;
    private int movesMade;
    /**
     * 
     * @param state Current state of the game as an array, where arr[0] is top left corner.
     * @param moves A list of made moves. "U D L R"
     * @param zeroPosition  The position of the "empty" slot
     * @param nmbr The current number of moves made.
     */
    public GameStateBFS(int[] state,char[] moves, int zeroPosition, int nmbr) {
        this.state = state;
        this.moves = moves;
        this.zeroPosition = zeroPosition;
        this.movesMade = nmbr;
    }

    @Override
    public int[] getState() {
        return state;
    }

    @Override
    public char[] getMoves() {
        return moves;
    }

    @Override
    public int compareTo(GameStateBFS o) {
        return this.getScore() - o.getScore();
    }

    @Override
    public int getScore() {
        return movesMade;
    }

    @Override
    public int getZeroPos() {
        return zeroPosition;
    }

    @Override
    public int getNrMovesMade() {
        return movesMade;
    }

    @Override
    public int compareTo(GameState other) {
        return movesMade - other.getNrMovesMade();
    }
    
}
