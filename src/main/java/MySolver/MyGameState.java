
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
     * @param score
     * @param state
     * @param madeMoves
     * @param movesMade
     * @param zeroPosition 
     * @param previousMove
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
