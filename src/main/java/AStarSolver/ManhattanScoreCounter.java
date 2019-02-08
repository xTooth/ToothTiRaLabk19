/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarSolver;


/**
 *
 * @author tooth
 */
public class ManhattanScoreCounter {

    /**
     * @scores This table represents the moves required to get the block into
     * its correct position. The way this should be read is int[slot][value of
     * block in slot]. So number 5 in slot 1 would return a value of 1. since it
     * is 1 move away from its correct position. We do not calculate the value
     * of 0.
     *  1  2  3  4 
     *  5  6  7  8
     *  9 10 11 12 
     * 13 14 15  0
     */
    private final int[][] scores = new int[][]{
        //0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 block      
        {0, 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5, 3, 4, 5}, //0 index
        {0, 1, 0, 1, 2, 2, 1, 2, 3, 3, 2, 3, 4, 4, 3, 4}, //1
        {0, 2, 1, 0, 1, 3, 2, 1, 2, 4, 3, 2, 3, 5, 4, 3}, //2
        {0, 3, 2, 1, 0, 4, 3, 2, 1, 5, 4, 3, 2, 6, 5, 4}, //3
        {0, 1, 2, 3, 4, 0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4}, //4
        {0, 2, 1, 2, 3, 1, 0, 1, 2, 2, 1, 2, 3, 3, 2, 3}, //5
        {0, 3, 2, 1, 2, 2, 1, 0, 1, 3, 2, 1, 2, 4, 3, 2}, //6
        {0, 4, 3, 2, 1, 3, 2, 1, 0, 4, 3, 2, 1, 5, 4, 3}, //7
        {0, 2, 3, 4, 5, 1, 2, 3, 4, 0, 1, 2, 3, 1, 2, 3}, //8
        {0, 3, 2, 3, 4, 2, 1, 2, 3, 1, 0, 1, 2, 2, 1, 2}, //9
        {0, 4, 3, 2, 3, 3, 2, 1, 2, 2, 1, 0, 1, 3, 2, 1}, //10
        {0, 5, 4, 3, 2, 4, 3, 2, 1, 3, 2, 1, 0, 4, 3, 2}, //11
        {0, 3, 4, 5, 6, 2, 3, 4, 5, 1, 2, 3, 4, 0, 1, 2}, //12
        {0, 4, 3, 4, 5, 3, 2, 3, 4, 2, 1, 2, 3, 1, 0, 1}, //13
        {0, 5, 4, 3, 4, 4, 3, 2, 3, 3, 2, 1, 2, 2, 1, 0}, //14
        {0, 6, 5, 4, 3, 5, 4, 3, 2, 4, 3, 2, 1, 3, 2, 1}, //15
    };

    /**
     *
     * @param state Current gameState
     * @param moves number of moves made total.
     * @return the new calculated score for the gameState.
     */
    public int countScore(int[] state, int moves){
        int score = 0;
        for(int i = 0;i<state.length;i++){
            score += scores[i][state[i]];
        }
        return score * moves;
    }
}
