/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generalizer;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Toothy
 */
public class ParentSolverTest {

    ParentSolver p;

    public ParentSolverTest() {
        p = new ParentSolver();
    }

    @Test
    public void GetAllowedThisTimeWorks() {
        assertFalse(p.isAllowedthisTime('U', 'D'));
        assertFalse(p.isAllowedthisTime('L', 'R'));
        assertFalse(p.isAllowedthisTime('D', 'U'));
        assertFalse(p.isAllowedthisTime('R', 'L'));
    }
    
    @Test
    public void findZeroWorks(){
        assertEquals(p.findZero(new int[]{1,2,3,4,5,6,7,8,9,0}),9);
    }
}
