package Solver;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FifteenSolver {

    private final int[] solved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private PriorityQueue<GameState> states;

    public FifteenSolver(int[] unsolved) {
        states = new PriorityQueue<>();
        states.add(new GameState(unsolved, new ArrayList<>(), findZero(unsolved)));
    }

    public ArrayList<Character> solve() {

        while (!states.isEmpty()) {

            GameState current = states.poll();
            System.out.println(current.getState().toString());
            
            if (solved(current)) {
                return current.getMoves();
            }

            char[] allowedMoves = getAllowedMoves(current);
            makeAllowedMoves(allowedMoves, current);
          
        }

        return null;
    }

    private boolean solved(GameState state) {

        return state.getState().equals(solved);
    }

    private char[] getAllowedMoves(GameState current) {

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

            case 15:
                return new char[]{'D', 'R'};
        }

        return null;
    }

    private int findZero(int[] unsolved) {

        for (int i = 0; i < 16; i++) {
            if (unsolved[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private void makeAllowedMoves(char[] allowedMoves, GameState current) {

        for (int i = 0; i < allowedMoves.length; i++) {

            ArrayList<Character> madeMoves = (ArrayList<Character>) current.getMoves().clone();
            madeMoves.add(allowedMoves[i]);
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

                case 'L':
                    newState[current.getZeroPosition()] = current.getState()[current.getZeroPosition() + 1];
                    newState[current.getZeroPosition() + 1] = 0;
                    newZeroPos = current.getZeroPosition() + 1;
                    break;
            }
            
            states.add(new GameState(newState,madeMoves,newZeroPos));
        }
    }

}
