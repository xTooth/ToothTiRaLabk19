/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarSolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 *
 * @author tooth
 */
public class AStarSolver {

    private HashSet<GameStateNode> visited;
    private PriorityQueue<GameStateNode> nodes;
    private ManhattanScoreCounter scorer;
    private int[] solved;

    /**
     *
     */
    public AStarSolver() {
        nodes = new PriorityQueue<>();
        visited = new HashSet<>();
        scorer = new ManhattanScoreCounter();
        solved = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    }

    /**
     *
     * @param beginningState initial unsolved input (puzzle state)
     * @return char[] of required moves to solve puzzle
     */
    public char[] solve(int[] beginningState) {

        nodes.clear();
        visited.clear();

        int zeroPos = findZero(beginningState);

        if (zeroPos < 0) {
            return new char[]{'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
        }

        nodes.add(new GameStateNode(beginningState, scorer.countScore(beginningState, 0), zeroPos, 0, new char[80]));
        int test = 0;
        while (!nodes.isEmpty()) {
            test++;
            GameStateNode current = nodes.poll();
            if (current.getNrMovesMade() < 80) {
                if (current.getScore() == 0) {
                    if (isSolved(current)) {
                        System.out.println("Vertices searched: " + test);
                        //System.out.println(current);
                        return current.getMoves();
                    }
                }
                addAllowedMoves(getAllowedMoves(current.getZeroPos()), current);

            }
        }

        return new char[]{'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
    }

    private int findZero(int[] beginningState) {
        for (int i = 0; i < beginningState.length; i++) {
            if (beginningState[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean isSolved(GameStateNode current) {
        for (int i = 0; i < current.getState().length; i++) {
            if (current.getState()[i] != solved[i]) {
                return false;
            }
        }
        return true;
    }

    private char[] getAllowedMoves(int zeroPos) {
        switch (zeroPos) {
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

    private void addAllowedMoves(char[] allowedMoves, GameStateNode current) {
        for (int i = 0; i < allowedMoves.length; i++) {

            char[] madeMoves = (char[]) current.getMoves().clone();
            madeMoves[current.getNrMovesMade()] = allowedMoves[i];
            int[] newState = current.getState().clone();
            int newZeroPos = 0;

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
            GameStateNode newN = new GameStateNode(newState, scorer.countScore(newState, current.getNrMovesMade() + 1), newZeroPos, current.getNrMovesMade() + 1, madeMoves);
            if (!visited.contains(newState)) {
                visited.add(newN);
                nodes.add(newN);
            }
        }

    }
}
