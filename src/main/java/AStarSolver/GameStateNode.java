package AStarSolver;

import java.util.Arrays;

/**
 *
 * @author tooth
 */
public class GameStateNode implements Comparable<GameStateNode> {

    private final int[] state;
    private final int score;
    private final int zeroPos;
    private final int nrMovesMade;
    private final char[] moves;

    /**
     *
     * @param state Current gameState as int[].
     * @param score Current calculated ManhattanScore as an integer.
     * @param zeroPos Position of the empty slot.
     * @param nrMovesMade The amount of made moves.
     * @param moves A char[] of the moves made at this point in time.
     */
    public GameStateNode(int[] state, int score, int zeroPos, int nrMovesMade, char[] moves) {
        this.state = state;
        this.score = score;
        this.zeroPos = zeroPos;
        this.nrMovesMade = nrMovesMade;
        this.moves = moves;
    }

    @Override
    public int compareTo(GameStateNode other) {
            return this.score - other.score;
    }

    /**
     *
     * @return the current gameState
     */
    public int[] getState() {
        return state;
    }

    /**
     *
     * @return Current score for this state.
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return Location for the empty block to avoid searching for it every time.
     */
    public int getZeroPos() {
        return zeroPos;
    }

    /**
     *
     * @return The amount of moves made at this state.
     */
    public int getNrMovesMade() {
        return nrMovesMade;
    }

    /**
     *
     * @return The moves "U D L R" that have been made.
     */
    public char[] getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "moves made =  " + nrMovesMade + " score= " + score + " moves = " + Arrays.toString(moves);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.hashCode(this.state);
        return hash;
    }

    /**
     *
     * @param obj other GameStateNode
     * @return True if the state of the game is identical. DOES NOT COMPARE
     * NODES.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameStateNode other = (GameStateNode) obj;
        for(int i = 0; i<this.state.length;i++){
            if(state[i] != other.getState()[i]){
                return false;
            }
        }
        
        return true;
    }

}
