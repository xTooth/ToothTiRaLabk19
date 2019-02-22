package MySolver;

import Generalizer.ParentSolver;
import DataStructures.BinaryHeapThingy;

/**
 * this is supposed to solve the game using something "like" an A* algorithm.
 *
 * @author Toothy
 */
public class MySolver extends ParentSolver{

    
    private final BinaryHeapThingy states;
    private final ScoreCounter counter;

    /**
     * Creates new puzzle Solver.
     */
    public MySolver() {
        states = new BinaryHeapThingy();
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
            MyGameState current = (MyGameState) states.poll();

            if (current.getZeroPos() == -1) {
                break;
            }

            if (super.solved(current.getState())) {
                System.out.println("Vertices searched: " + test);
                return current.getMoves();
            }

            if (current.getNrMovesMade() < 80) {
                makeAllowedMoves(super.getAllowedMoves(current.getZeroPos()), current);
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

            char[] madeMoves = (char[]) state.getMoves().clone();
            madeMoves[state.getNrMovesMade()] = moves[i];
            int[] newState = state.getState().clone();
            int newZeroPos = 0;
            if (super.isAllowedthisTime(moves[i], state.getPreviousMove())) {
                switch (moves[i]) {

                    case 'U':
                        newState[state.getZeroPos()] = state.getState()[state.getZeroPos() + 4];
                        newState[state.getZeroPos() + 4] = 0;
                        newZeroPos = state.getZeroPos() + 4;
                        break;

                    case 'D':
                        newState[state.getZeroPos()] = state.getState()[state.getZeroPos() - 4];
                        newState[state.getZeroPos() - 4] = 0;
                        newZeroPos = state.getZeroPos() - 4;
                        break;

                    case 'R':
                        newState[state.getZeroPos()] = state.getState()[state.getZeroPos() - 1];
                        newState[state.getZeroPos() - 1] = 0;
                        newZeroPos = state.getZeroPos() - 1;
                        break;

                    default:
                        newState[state.getZeroPos()] = state.getState()[state.getZeroPos() + 1];
                        newState[state.getZeroPos() + 1] = 0;
                        newZeroPos = state.getZeroPos() + 1;
                        break;
                }

                states.add(new MyGameState(counter.getNewScore(
                        moves[i], state.getZeroPos(), state.getState(), state.getScore(), state.getNrMovesMade() + 1),
                        newState, madeMoves, state.getNrMovesMade() + 1, newZeroPos, state.getPreviousMove()));
            }
        }
    }




}
