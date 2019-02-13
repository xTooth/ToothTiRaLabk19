/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParentSolver;

/**
 * The solver superclass for generic methods.
 *
 * @author Toothy
 */
public class ParentSolver {

    private final int[] solved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    
    public char[] getAllowedMoves(int zero) {
        switch (zero) {
            case 0:
                return new char[]{'U', 'L'};
            case 1:
            case 2:
                return new char[]{'U', 'L', 'R'};
            case 3:
                return new char[]{'U', 'R'};
            case 4:
            case 8:
                return new char[]{'U', 'D', 'L'};
            case 5:
            case 6:
            case 9:
            case 10:
                return new char[]{'U', 'D', 'R', 'L'};
            case 7:
            case 11:
                return new char[]{'U', 'D', 'R'};
            case 12:
                return new char[]{'D', 'L'};
            case 13:
            case 14:
                return new char[]{'D', 'R', 'L'};
            default:
                return new char[]{'D', 'R'};
        }
    }

    /**
     * To stop going backwards
     *
     * @param move new move being handled
     * @param previousMove move made before this one
     * @return True if not moving backwards.
     */
    public boolean isAllowedthisTime(char move, char previousMove) {

        if (move == 'U' && previousMove == 'D') {
            return false;
        }
        if (move == 'D' && previousMove == 'U') {
            return false;
        }
        if (move == 'L' && previousMove == 'R') {
            return false;
        }
        if (move == 'R' && previousMove == 'L') {
            return false;
        }
        return true;
    }
    
        /**
     *
     * @param state Current state of the game.
     * @return True if the game is solved.
     */
    public boolean solved(int[] state) {

        for (int i = 0; i < 16; i++) {
            if (state[i] != solved[i]) {
                return false;
            }
        }

        return true;

    }
    
        /**
     *
     * @param unsolved Array that depicts the current state of the game.
     * @return The index of the empty ( 0 ) block.
     */
    public int findZero(int[] unsolved) {

        for (int i = 0; i < 16; i++) {
            if (unsolved[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
