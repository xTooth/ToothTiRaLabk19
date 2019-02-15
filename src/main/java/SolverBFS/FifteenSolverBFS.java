package SolverBFS;

import DataStructures.HashingishTable;
import Generalizer.ParentSolver;
import java.util.PriorityQueue;

/**
 *
 * @author Toothy
 */
public class FifteenSolverBFS extends ParentSolver{

    
    private PriorityQueue<GameStateBFS> states;
    private HashingishTable visited;

    /**
     *
     * initializes new BFS solver
     */
    public FifteenSolverBFS() {
        states = new PriorityQueue<>();
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
        states.add(new GameStateBFS(unsolved, new char[80], super.findZero(unsolved),0));
        if (states.peek().getZeroPosition() == -1) {
            System.out.println("UNSOLVABLE, NO EMPTY SPACE");
            states.poll();
        }
        int test = 0;
        while (!states.isEmpty()) {
            test++;
            GameStateBFS current = states.poll();

            if (super.solved(current.getState())) {
                System.out.println("Vertices searched: " + test);
                return current.getMoves();
            }

            char[] allowedMoves = super.getAllowedMoves(current.getZeroPosition());
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
            madeMoves[current.getNumberOfMadeMoves()] = allowedMoves[i];
            int[] newState = current.getState().clone();
            int newZeroPos = 0;

            switch (allowedMoves[i]) {

                case 'U':
                    newState[current.getZeroPosition()] = current.getState()[current.getZeroPosition() + 4];
                    newState[current.getZeroPosition() + 4] = 0;
                    newZeroPos = current.getZeroPosition() + 4;
                    break;

                case 'D':
                    newState[current.getZeroPosition()] = current.getState()[current.getZeroPosition() - 4];
                    newState[current.getZeroPosition() - 4] = 0;
                    newZeroPos = current.getZeroPosition() - 4;
                    break;

                case 'R':
                    newState[current.getZeroPosition()] = current.getState()[current.getZeroPosition() - 1];
                    newState[current.getZeroPosition() - 1] = 0;
                    newZeroPos = current.getZeroPosition() - 1;
                    break;

                default:
                    newState[current.getZeroPosition()] = current.getState()[current.getZeroPosition() + 1];
                    newState[current.getZeroPosition() + 1] = 0;
                    newZeroPos = current.getZeroPosition() + 1;
                    break;
            }
            if(!visited.contains(newState)){
            states.add(new GameStateBFS(newState,madeMoves,newZeroPos,current.getNumberOfMadeMoves()+1));
            visited.add(newState);
            }
        }
    }

}
