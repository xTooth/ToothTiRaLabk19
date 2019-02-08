package SolverBFS;

import DataStructures.HashingishTable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class FifteenSolverBFS {

    private final int[] solved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private PriorityQueue<GameStateBFS> states;
    private HashingishTable visited;

    /**
     *
     * 
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
        states.add(new GameStateBFS(unsolved, new char[80], findZero(unsolved),0));
        if (states.peek().getZeroPosition() == -1) {
            System.out.println("UNSOLVABLE, NO EMPTY SPACE");
            states.poll();
        }
        int test = 0;
        while (!states.isEmpty()) {
            test++;
            GameStateBFS current = states.poll();

            if (solved(current)) {
                System.out.println("Vertices searched: " + test);
                return current.getMoves();
            }

            char[] allowedMoves = getAllowedMoves(current);
            makeAllowedMoves(allowedMoves, current);

        }
        
        return new char[80];
    }

    /**
     *
     * @param state Array that depicts the current state of the game.
     * @return True if the game is solved.
     */
    private boolean solved(GameStateBFS state) {
        boolean isSolved = true;
        for (int i = 0; i < 16; i++) {
            if (state.getState()[i] != solved[i]) {
                isSolved = false;
            }
        }
        return isSolved;
    }

    /**
     *
     * @param current GameState argument. (see GameStateBFS)
     * @return Returns array of allowed moves based on the position of the
     * "empty" ( 0 ) slot.
     */
    private char[] getAllowedMoves(GameStateBFS current) {

        switch (current.getZeroPosition()) {
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
     *
     * @param unsolved Array that depicts the current state of the game.
     * @return The index of the empty ( 0 ) block.
     */
    private int findZero(int[] unsolved) {

        for (int i = 0; i < 16; i++) {
            if (unsolved[i] == 0) {
                return i;
            }
        }
        return -1;
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
