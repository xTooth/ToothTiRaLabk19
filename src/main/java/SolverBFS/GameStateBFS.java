/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SolverBFS;

import java.util.ArrayList;

/**
 *
 * @author tooth
 */
class GameStateBFS implements Comparable<GameStateBFS>{
       
    private int[] state;
    private ArrayList<Character> moves;
    private int zeroPosition;
    /**
     * 
     * @param state Current state of the game as an array, where arr[0] is top left corner.
     * @param moves A list of made moves. "U D L R"
     * @param zeroPosition  The position of the "empty" slot
     */
    public GameStateBFS(int[] state, ArrayList<Character> moves, int zeroPosition) {
        this.state = state;
        this.moves = moves;
        this.zeroPosition = zeroPosition;
    }

    public int getZeroPosition() {
        return zeroPosition;
    }

    public int getNumberOfMadeMoves() {
        return moves.size();
    }

    public int[] getState() {
        return state;
    }

    public ArrayList<Character> getMoves() {
        return moves;
    }

    @Override
    public int compareTo(GameStateBFS o) {
        return this.getNumberOfMadeMoves() - o.getNumberOfMadeMoves();
    }
    
}
