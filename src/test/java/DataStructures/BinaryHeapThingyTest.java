/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import AStarSolver.GameStateNode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Toothy
 */
public class BinaryHeapThingyTest {

    BinaryHeapThingy heap;

    public BinaryHeapThingyTest() {
        heap = new BinaryHeapThingy();
    }
    
    @Test
    public void heapReturnsNullWhenEmptyPoll(){
        assertEquals(heap.poll(), null);
    }
    
    @Test
    public void addingAndPollingWorks(){
        heap.add(new GameStateNode(new int[1],5,3,0,new char[1]));
        System.out.println("heap size : " + heap.size());
        assertEquals(heap.size() , 1);
        assertEquals(heap.poll().getScore(),5);
        assertEquals(heap.size(),0);
    }
    
    @Test
    public void sortsCorrectly(){
        heap.add(new GameStateNode(new int[0],11,3,0,new char[0]));
        assertFalse(heap.isEmpty());
        heap.add(new GameStateNode(new int[0],5,3,0,new char[0]));
        heap.add(new GameStateNode(new int[0],7,3,0,new char[0]));
        
        assertEquals(heap.poll().getScore(),5);
        assertEquals(heap.poll().getScore(),7);
        assertEquals(heap.poll().getScore(),11);
        assertTrue(heap.isEmpty());
    }
    
    

}
