package MySolver;

import java.util.PriorityQueue;

/**
 * this is supposed to solve the game using something "like" an A* algorithm.
 *
 * @author Toothy
 */
public class MySolver {

    private final int[] solved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private PriorityQueue<MyGameState> states;
    private ScoreCounter counter;

    /**
     * Creates new puzzle Solver.
     */
    public MySolver() {
        states = new PriorityQueue<>();
        counter = new ScoreCounter();
    }

    /**
     *
     * @param unsolved The initial unsolved state of a puzzle
     * @return Character array of needed moves to solve a puzzle
     */
    public char[] solve(int[] unsolved) {
        states.clear();

        states.add(new MyGameState(counter.getInitialScore(unsolved), unsolved, new char[80], 0, getZeroPosition(unsolved), 'S'));
        while (!states.isEmpty()) {

            MyGameState current = states.poll();

            if (current.getZeroPosition() == -1) {
                break;
            }

            if (solved(current)) {
                return current.getMadeMoves();
            }

            if (current.getMovesMade() < 80) {
                makeAllowedMoves(getAllowedMoves(current), current);
            }
        }

        char[] unsolvable = {'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
        return unsolvable;

    }

    /**
     *
     * @param unsolved State of game
     * @return The position of the empty ( 0 ) block
     */
    public int getZeroPosition(int[] unsolved) {

        for (int i = 0; i < 16; i++) {
            if (unsolved[i] == 0) {
                return i;
            }
        }

        return -1;

    }

    /**
     *
     * @param state Current state of the game.
     * @return True if the game is solved.
     */
    private boolean solved(MyGameState state) {

        for (int i = 0; i < 16; i++) {
            if (state.getState()[i] != solved[i]) {
                return false;
            }
        }

        return true;

    }

    /**
     *
     * @param moves Char[] of the moves to be made ( [U,D,R,L] )
     * @param state Current state of the game as an array.
     */
    private void makeAllowedMoves(char[] moves, MyGameState state) {

        for (int i = 0; i < moves.length; i++) {

            char[] madeMoves = (char[]) state.getMadeMoves().clone();
            madeMoves[state.getMovesMade()] = moves[i];
            int[] newState = state.getState().clone();
            int newZeroPos = 0;
            if (isAllowedthisTime(moves[i], state.getPreviousMove())) {
                switch (moves[i]) {

                    case 'U':
                        newState[state.getZeroPosition()] = state.getState()[state.getZeroPosition() + 4];
                        newState[state.getZeroPosition() + 4] = 0;
                        newZeroPos = state.getZeroPosition() + 4;
                        break;

                    case 'D':
                        newState[state.getZeroPosition()] = state.getState()[state.getZeroPosition() - 4];
                        newState[state.getZeroPosition() - 4] = 0;
                        newZeroPos = state.getZeroPosition() - 4;
                        break;

                    case 'R':
                        newState[state.getZeroPosition()] = state.getState()[state.getZeroPosition() - 1];
                        newState[state.getZeroPosition() - 1] = 0;
                        newZeroPos = state.getZeroPosition() - 1;
                        break;

                    default:
                        newState[state.getZeroPosition()] = state.getState()[state.getZeroPosition() + 1];
                        newState[state.getZeroPosition() + 1] = 0;
                        newZeroPos = state.getZeroPosition() + 1;
                        break;
                }

                states.add(new MyGameState(counter.getNewScore(
                        moves[i], state.getZeroPosition(), state.getState(), state.getScore(), state.getMovesMade() + 1),
                        newState, madeMoves, state.getMovesMade() + 1, newZeroPos, state.getPreviousMove()));
            }
        }
    }

    /**
     *
     * @param state Current gameState as an array
     * @return A Character array of the allowed moves ( U,D,R,L)
     */
    private char[] getAllowedMoves(MyGameState state) {
        int zero = state.getZeroPosition();

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
     * @param move new move being handled
     * @param previousMove move made before this one
     * @return True if not moving backwards.
     */
    private boolean isAllowedthisTime(char move, char previousMove) {

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

}
