
package SolverBFS;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FifteenSolverBFSTest {
    private final int[] solved = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
    private FifteenSolverBFS solver;
    
    @Test
    public void FifteenSolverWorksWithSolvedArray(){
        this.solver = new FifteenSolverBFS();
                
        Assert.assertArrayEquals(solver.solve(solved), new char[80]);
    }
    
    @Test
    public void findZeroWorksWithInCorrectTypeInput(){
        this.solver = new FifteenSolverBFS();               
        Assert.assertArrayEquals(solver.solve(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}), new char[80]);
    }
    
    @Test
    public void FifteenSolverBFSWorksWithUnSolvedArray(){
        FifteenSolverBFS solver = new FifteenSolverBFS();
        char[] solversResult = solver.solve(new int[]{5, 2, 7, 3, 6, 1, 0, 4, 9, 10, 11, 8, 13, 14, 15, 12});
        char[] moves = new char[]{'D', 'R', 'U', 'R', 'D', 'L', 'L', 'L', 'U', 'U', 'U'};
        boolean works = true;
        for (int i = 0; i < moves.length; i++) {
            if (moves[i] != solversResult[i]) {
                works = false;
                break;
            }
        }
        if (solversResult[moves.length] != '\u0000') {
            works = false;
        }
        assertTrue(works);
    }
}
