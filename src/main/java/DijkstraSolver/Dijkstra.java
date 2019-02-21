/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DijkstraSolver;

import DataStructures.BinaryHeapThingy;
import DataStructures.HashingishTable;
import Generalizer.ParentSolver;


/**
 *
 * @author Toothy
 */
public class Dijkstra extends ParentSolver{
    
    private BinaryHeapThingy states;
    private HashingishTable visited;
    
    /**
     * Initializes new djikstra solver.
     */
    public Dijkstra(){
        states = new BinaryHeapThingy();
        visited = new HashingishTable();
    }
    
    /**
     *
     * @param initialState state to be solved
     * @return  array of charachters representing the moves needed to solve the game.
     */
    public char[] solve(int[] initialState){
        int zeroPos = super.findZero(initialState);
        int initialScore = getScore(initialState);
        return new char[1];
    }

    private int getScore(int[] initialState) {
        return 0;
    }
    
    
    
    
}
