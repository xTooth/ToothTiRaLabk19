package MySolver;

class ScoreCounter {

    public ScoreCounter() {
    }

    /**
     *
     * @param state Displays the current state of the game as an array, where
     * state[0] is the top left square of the game
     * @return The "value" of the current state of the game. The bigger the
     * value, the further from solved it is.
     */
    public int getInitialScore(int[] state) {
        int score = 0;
        for (int i = 0; i < state.length - 1; i++) {
            score += Math.abs(state[i] - (i + 1));
        }
        score += state[state.length - 1];
        return score;
    }
    
    /**
     * 
     * @param move Character representing the move being handled
     * @param zeroPosition Integer, Current position of zero (before the move)
     * @param state int[], State of the game (before the move)
     * @param currentScore Integer, Score before the move.
     * @param madeMoves Integer, amount of made moves after the move.
     * @return 
     */
    public int getNewScore(char move, int zeroPosition, int[] state, int currentScore, int madeMoves) {
        int newScore = currentScore;
        switch (move) {
            case 'U':             
                newScore -= Math.abs(state[zeroPosition + 4] - (zeroPosition + 5));
                newScore += Math.abs(state[zeroPosition + 4] - (zeroPosition + 1));             
                break;
            case 'D':     
                newScore -= Math.abs(state[zeroPosition - 4] - (zeroPosition - 3));
                newScore += Math.abs(state[zeroPosition - 4] - (zeroPosition + 1));             
                break;
            case 'R':            
                newScore -= Math.abs(state[zeroPosition - 1] - (zeroPosition));
                newScore += Math.abs(state[zeroPosition - 1] - (zeroPosition + 1));              
                break;
            default:              
                newScore -= Math.abs(state[zeroPosition + 1] - (zeroPosition + 2));
                newScore += Math.abs(state[zeroPosition + 1] - (zeroPosition + 1));              
        }
        return newScore + madeMoves;
    }

}
