
package MySolver;


class MyGameState implements Comparable<MyGameState>{
    
    private int score;
    private int[] state;
    private char[] madeMoves;
    private int movesMade;
    private int zeroPosition;

    public MyGameState(int score, int[] state, char[] madeMoves, int movesMade, int zeroPosition) {
        this.score = score;
        this.state = state;
        this.madeMoves = madeMoves;
        this.movesMade = movesMade;
        this.zeroPosition = zeroPosition;
    }

    public int getZeroPosition() {
        return zeroPosition;
    }

    public int getScore() {
        return score;
    }

    public int[] getState() {
        return state;
    }

    public char[] getMadeMoves() {
        return madeMoves;
    }

    public int getMovesMade() {
        return movesMade;
    }

    @Override
    public int compareTo(MyGameState other) {
        return this.score - other.score;
    }
    
    
}
