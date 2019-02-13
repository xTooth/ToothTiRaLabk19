package MySolver;

import ParentSolver.ParentSolver;
import java.util.PriorityQueue;

/**
 * this is supposed to solve the game using something "like" an A* algorithm.
 *
 * @author Toothy
 */
public class MySolver extends ParentSolver{

    
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

        states.add(new MyGameState(counter.getInitialScore(unsolved), unsolved, new char[80], 0, super.findZero(unsolved), 'S'));
        int test = 0;
        while (!states.isEmpty()) {
            test++;
            MyGameState current = states.poll();

            if (current.getZeroPosition() == -1) {
                break;
            }

            if (super.solved(current.getState())) {
                System.out.println("Vertices searched: " + test);
                return current.getMadeMoves();
            }

            if (current.getMovesMade() < 80) {
                makeAllowedMoves(super.getAllowedMoves(current.getZeroPosition()), current);
            }
        }

        char[] unsolvable = {'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
        return unsolvable;

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
            if (super.isAllowedthisTime(moves[i], state.getPreviousMove())) {
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




}
