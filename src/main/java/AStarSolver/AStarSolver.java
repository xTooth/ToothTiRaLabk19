/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarSolver;

import DataStructures.BinaryHeapThingy;
import DataStructures.HashingishTable;
import Generalizer.GameState;
import Generalizer.ParentSolver;

/**
 *
 * @author tooth
 */
public class AStarSolver extends ParentSolver{

    private HashingishTable visited;
    private BinaryHeapThingy nodes;
    private ManhattanScoreCounter scorer;
    

    /**
     * initializes new AStarSolver
     */
    public AStarSolver() {
        nodes = new BinaryHeapThingy();
        visited = new HashingishTable();
        scorer = new ManhattanScoreCounter();
        
    }

    /**
     *
     * @param beginningState initial unsolved input (puzzle state)
     * @return char[] of required moves to solve puzzle
     */
    public char[] solve(int[] beginningState) {

        nodes.clear();
        visited.clear();

        int zeroPos = super.findZero(beginningState);

        if (zeroPos < 0) {
            return new char[]{'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
        }

        nodes.add(new GameStateNode(beginningState, scorer.countScore(beginningState, 0), zeroPos, 0, new char[80]));
        int test = 0;
        while (!nodes.isEmpty()) {
            test++;
            GameState current = nodes.poll();
            if (current.getNrMovesMade() < 80) {
                if (current.getScore() == 0) {
                    if (super.solved(current.getState())) {
                        System.out.println("Vertices searched: " + test);
                        //System.out.println(current);
                        return current.getMoves();
                    }
                }
                addAllowedMoves(getAllowedMoves(current.getZeroPos()),(GameStateNode) current);

            }
        }

        return new char[]{'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'};
    }

    private void addAllowedMoves(char[] allowedMoves, GameStateNode current) {
        for (int i = 0; i < allowedMoves.length; i++) {

            char[] madeMoves = (char[]) current.getMoves().clone();
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
            GameStateNode newN = new GameStateNode(newState, scorer.countScore(newState, current.getNrMovesMade() + 1), newZeroPos, current.getNrMovesMade() + 1, madeMoves);
            if (!visited.contains(newState,newZeroPos)) {
                visited.add(newState,newZeroPos);
                nodes.add(newN);
            }
        }

    }
}
