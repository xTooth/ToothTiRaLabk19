
package MySolver;

import Generalizer.GameState;

/**
 * Depicts the state of the game, listing a weighed score based on the amount of moves made and the current state of the game.
 * @author Toothy
 */
class MyGameState implements Comparable<MyGameState>, GameState{
    
    private final int score;
    private final int[] state;
    private final char[] madeMoves;
    private final int movesMade;
    private final int zeroPosition;
    private final char previousMove;
    /**
     * 
     * @param score Current score of the state
     * @param state current positions of the blocks in the game as an int[]
     * @param madeMoves Array of what moves have been made so far
     * @param movesMade Amount of moves made so far
     * @param zeroPosition  location of the empty space
     * @param previousMove previous move made.
     */
    public MyGameState(int score, int[] state, char[] madeMoves, int movesMade, int zeroPosition, char previousMove) {
        this.score = score;
        this.state = state;
        this.madeMoves = madeMoves;
        this.movesMade = movesMade;
        this.zeroPosition = zeroPosition;
        this.previousMove = previousMove;
    }

    public char getPreviousMove() {
        return previousMove;
    }
    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int[] getState() {
        return state;
    }
    
    @Override
    public int compareTo(MyGameState other) {
        return this.score - other.score;
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
    public char[] getMoves() {
        return madeMoves;
    }

    @Override
    public int compareTo(GameState other) {
        return this.score - other.getScore();
    }
    
    
}
