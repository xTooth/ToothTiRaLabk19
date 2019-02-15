package FifteenSolverMain;

import Generalizer.ParentSolver;
import java.util.Random;

/**
 *
 * @author Toothy
 */
public class Shuffler extends ParentSolver{

    private final char[] moves;
    private final int[] state;
    private final Random random;
    private int zeroPos;

    /**
     *
     * @param amountOfShuffles the number of shuffles made to solved game
     */
    public Shuffler(int amountOfShuffles) {
        moves = new char[amountOfShuffles];
        state = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        random = new Random();
        zeroPos = 15;
    }

    /**
     *
     * @return shuffled gamestate.
     */
    public int[] shuffle() {
        for (int i = 0; i < moves.length; i++) {
            char[] allowedMoves = super.getAllowedMoves(zeroPos);
            int r = random.nextInt(allowedMoves.length);

            switch (allowedMoves[r]) {
                case 'U':
                    moves[i] = 'U';
                    state[zeroPos] = state[zeroPos + 4];
                    state[zeroPos + 4] = 0;
                    zeroPos = zeroPos + 4;
                    break;

                case 'D':
                    moves[i] = 'D';
                    state[zeroPos] = state[zeroPos - 4];
                    state[zeroPos - 4] = 0;
                    zeroPos = zeroPos - 4;
                    break;

                case 'R':
                    moves[i] = 'R';
                    state[zeroPos] = state[zeroPos - 1];
                    state[zeroPos - 1] = 0;
                    zeroPos = zeroPos - 1;
                    break;

                default:
                    moves[i] = 'L';
                    state[zeroPos] = state[zeroPos + 1];
                    state[zeroPos + 1] = 0;
                    zeroPos = zeroPos + 1;
                    break;
            }

        }

        System.out.println("shuffling done");
        for (int i = 0; i < moves.length; i++) {
            System.out.print(moves[i]);
        }
        System.out.println("");
        for (int i = 0; i < 16; i++) {
            if (state[i] > 9) {
                System.out.print(" " + state[i]);
            }else{
                System.out.print("  " + state[i]);
            }
            if (i == 3 || i == 7 || i == 11) {
                System.out.println("");
            }

        }
        System.out.println("");

        return state;
    }

}
