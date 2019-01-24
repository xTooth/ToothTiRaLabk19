
package SolverBFS;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FifteenSolverBFSTest {
    private final int[] solved = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
    private FifteenSolverBFS solver;
    
    @Test
    public void FifteenSolverWorksWithSolvedArray(){
        this.solver = new FifteenSolverBFS(solved);
        ArrayList<Character> moves = new ArrayList<>();        
        assertEquals(solver.solve(), moves);
    }
    
    @Test
    public void findZeroWorksWithInCorrectTypeInput(){
        this.solver = new FifteenSolverBFS(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        ArrayList<Character> moves = new ArrayList<>();        
        assertEquals(solver.solve(), moves);
    }
    
    @Test
    public void FifteenSolverBFSWorksWithUnSolvedArray(){
        FifteenSolverBFS solver = new FifteenSolverBFS(new int[]{5,2,7,3,6,1,0,4,9,10,11,8,13,14,15,12});
        ArrayList<Character> moves = new ArrayList<>(Arrays.asList('D', 'R', 'U', 'R', 'D', 'L', 'L', 'L', 'U', 'U', 'U'));        
        assertEquals(solver.solve(), moves);
    }
}
