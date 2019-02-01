/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AStarSolver;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Toothy
 */
public class AStarSolverTest {

    AStarSolver solver;
    private final int[] solved = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};

    public AStarSolverTest() {
        solver = new AStarSolver();

    }

    @Test
    public void AStarCatchesUnsolvables() {
        char[] result = solver.solve(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        System.out.println("is run");
        Assert.assertArrayEquals(result, new char[]{'U', 'N', 'S', 'O', 'L', 'V', 'A', 'B', 'L', 'E'});
    }

    @Test
    public void AStarHandlesSolvedCorrectly() {
        assertEquals(solver.solve(solved)[0], '\u0000');
    }

    @Test
    public void AStarSolverWorksWithUnSolvedArray() {
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
