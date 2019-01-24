package MySolver;

import java.util.PriorityQueue;

public class MySolver {

    private final int[] solved = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    private PriorityQueue<MyGameState> states;
    private ScoreCounter counter;

    public MySolver() {
        states = new PriorityQueue<>();
        counter = new ScoreCounter();
    }

    public char[] solve(int[] unsolved) {

        char[] madeMoves = new char[80];
        states.add(new MyGameState(counter.getInitialScore(unsolved), unsolved, madeMoves, 0, getZeroPosition(unsolved)));

        while (!states.isEmpty()) {

            MyGameState current = states.poll();

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

    private int getZeroPosition(int[] unsolved) {

        for (int i = 0; i < 16; i++) {
            if (unsolved[i] == 0) {
                return i;
            }
        }

        return -1;

    }

    private boolean solved(MyGameState state) {

        boolean isSolved = true;

        for (int i = 0; i < 16; i++) {
            if (state.getState()[i] != solved[i]) {
                isSolved = false;
            }
        }

        return isSolved;

    }

    public void makeAllowedMoves(char[] moves, MyGameState state) {
        
    }

    public char[] getAllowedMoves(MyGameState state) {
        int zero = state.getZeroPosition();

        if (zero == 0) {
            return new char[]{'U', 'L'};

        } else if (zero == 1 || zero == 2) {
            return new char[]{'U', 'L', 'R'};

        } else if (zero == 3) {
            return new char[]{'U', 'R'};

        } else if (zero == 4 || zero == 8) {
            return new char[]{'U', 'D', 'L'};

        } else if (zero == 5 || zero == 6 || zero == 9 || zero == 10) {
            return new char[]{'U', 'D', 'R', 'L'};

        } else if (zero == 7 || zero == 11) {
            return new char[]{'U', 'D', 'R'};

        } else if (zero == 12) {
            return new char[]{'D', 'L'};

        } else if (zero == 13 || zero == 14) {
            return new char[]{'D', 'R', 'L'};

        } else {
            return new char[]{'D', 'R'};
        }
    }

}
