package SolverBFS;

import DataStructures.BinaryHeapThingy;
import DataStructures.HashingishTable;
import Generalizer.GameState;
import Generalizer.ParentSolver;


/**
 *
 * @author Toothy
 */
public class FifteenSolverBFS extends ParentSolver{

    
    private final BinaryHeapThingy states;
    private final HashingishTable visited;

    /**
     *
     * initializes new BFS solver
     */
    public FifteenSolverBFS() {
        states = new BinaryHeapThingy();
        visited = new HashingishTable();

    }

    /**
     *
     * @return Returns an ArrayList of the made moves (as characters) to solve
     * the given gameState.
     * @param unsolved the initial state of the game, as an array of size 16.
     */
    public char[] solve(int[] unsolved) {
        states.clear();
        visited.clear();
        GameStateBFS newState = new GameStateBFS(unsolved, new char[80], super.findZero(unsolved),0);
        states.add((GameState) newState);
        System.out.println("BFS peek zeroPos:" + states.peek().getZeroPos());
        if (states.peek().getZeroPos() == -1) {
            System.out.println("UNSOLVABLE, NO EMPTY SPACE");
            states.poll();
        }
        int test = 0;
        while (!states.isEmpty()) {
            test++;
            GameStateBFS current = (GameStateBFS) states.poll();

            if (super.solved(current.getState())) {
                System.out.println("Vertices searched: " + test);
                return current.getMoves();
            }

            char[] allowedMoves = super.getAllowedMoves(current.getZeroPos());
            makeAllowedMoves(allowedMoves, current);

        }
        
        return new char[80];
    }

    /**
     *
     * @param allowedMoves Array of allowed moves, that can be made. ( char[])
     * @param current The current "node" gameStateBFS object that is to be
     * handled.
     */
    private void makeAllowedMoves(char[] allowedMoves, GameStateBFS current) {

        for (int i = 0; i < allowedMoves.length; i++) {

            char[] madeMoves = current.getMoves().clone();
            madeMoves[current.getNrMovesMade()] = allowedMoves[i];
            int[] newState = current.getState().clone();
            int newZeroPos;

            switch (allowedMoves[i]) {

                case 'U':
                    newState[current.getZeroPos()] = current.getState()[current.getZeroPos() + 4];
                    newState[current.getZeroPos() + 4] = 0;
                    newZeroPos = current.getZeroPos() + 4;
                    break;

                case 'D':
                    newState[current.getZeroPos()] = current.getState()[current.getZeroPos() - 4];
                    newState[current.getZeroPos() - 4] = 0;
                    newZeroPos = current.getZeroPos() - 4;
                    break;

                case 'R':
                    newState[current.getZeroPos()] = current.getState()[current.getZeroPos() - 1];
                    newState[current.getZeroPos() - 1] = 0;
                    newZeroPos = current.getZeroPos() - 1;
                    break;

                default:
                    newState[current.getZeroPos()] = current.getState()[current.getZeroPos() + 1];
                    newState[current.getZeroPos() + 1] = 0;
                    newZeroPos = current.getZeroPos() + 1;
                    break;
            }
            if(!visited.contains(newState)){
            states.add((GameState) new GameStateBFS(newState,madeMoves,newZeroPos,current.getNrMovesMade()+1));
            visited.add(newState);
            }
        }
    }

}
