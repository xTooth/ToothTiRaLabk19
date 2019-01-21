/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solver;

import java.util.ArrayList;

/**
 *
 * @author tooth
 */
class GameState implements Comparable<GameState>{
       
    private int[] state;
    private ArrayList<Character> moves;
    private int zeroPosition;

    public GameState(int[] state, ArrayList<Character> moves, int zeroPosition) {
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
    public int compareTo(GameState o) {
        return this.getNumberOfMadeMoves()-o.getNumberOfMadeMoves();
    }
    
}
