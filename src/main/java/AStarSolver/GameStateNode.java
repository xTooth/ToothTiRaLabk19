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
        if(this.score -other.score == 0){
            return this.nrMovesMade - other.nrMovesMade;
        }
        return this.score - other.score;
    }

    public int[] getState() {
        return state;
    }

    public int getScore() {
        return score;
    }

    public int getZeroPos() {
        return zeroPos;
    }

    public int getNrMovesMade() {
        return nrMovesMade;
    }

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
        if (!Arrays.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

}
