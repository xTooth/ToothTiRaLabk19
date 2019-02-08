package FifteenSolverMain;

import java.util.Random;

/**
 *
 * @author Toothy
 */
public class Shuffler {

    private char[] moves;
    private int[] state;
    private Random random;
    private int zeroPos;

    public Shuffler(int amountOfShuffles) {
        moves = new char[amountOfShuffles];
        state = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        random = new Random();
        zeroPos = 15;
    }

    public int[] shuffle() {
        for (int i = 0; i < moves.length; i++) {
            char[] allowedMoves = getAllowedMoves(zeroPos);
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

}
