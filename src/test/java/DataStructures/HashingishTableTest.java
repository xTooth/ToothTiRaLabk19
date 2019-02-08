/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Toothy
 */
public class HashingishTableTest {

    private HashingishTable table;

    public HashingishTableTest() {
        this.table = new HashingishTable();
    }

    @Test
    public void emptyTableContainsWorks() {
        assertTrue(!this.table.contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
    }

    @Test
    public void emptyTableAddingAndContainsWorks() {
        this.table.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        assertTrue(this.table.contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}));
    }

    @Test
    public void clearingTableWorks() {
        this.table.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        this.table.clear();
        assertTrue(!this.table.contains(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0}) && table.getSize() == 0);
    }
    
    @Test
    public void cantAddSameStateTwice(){
        this.table.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        this.table.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        assertTrue(table.getSize()==1);
        table.clear();
    }
    
    @Test
    public void addingNullDoesntBrakeStuff(){
        table.clear();
        this.table.add(null);
        assertTrue(table.getSize() == 0);
    }
    
    @Test
    public void hashCollisionHandledWell(){
        this.table.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        this.table.add(new int[]{9, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0});
        assertTrue(table.getSize() == 2);
        table.clear();
    }
   
}
