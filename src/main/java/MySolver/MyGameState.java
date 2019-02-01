
package MySolver;

/**
 * Depicts the state of the game, listing a weighed score based on the amount of moves made and the current state of the game.
 * @author Toothy
 */
class MyGameState implements Comparable<MyGameState>{
    
    private int score;
    private int[] state;
    private char[] madeMoves;
    private int movesMade;
    private int zeroPosition;
    private char previousMove;
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

    public int getZeroPosition() {
        return zeroPosition;
    }

    public int getScore() {
        return score;
    }

    public int[] getState() {
        return state;
    }

    public char[] getMadeMoves() {
        return madeMoves;
    }

    public int getMovesMade() {
        return movesMade;
    }

    @Override
    public int compareTo(MyGameState other) {
        return this.score - other.score;
    }
    
    
}
