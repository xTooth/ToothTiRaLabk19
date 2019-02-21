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
public class RandomizerTest {
    Randomizer r = new Randomizer();
    
    
    @Test
    public void RandomizerDoesntReturnValuesSmallerThanZero(){
        boolean works = true;
        for(int i = 0; i<10000;i++){
            if(r.getRandomInt(15)<0){
                works = false;
                break;
            }
        }
        assertTrue(works);
    }
    
    @Test
    public void RandomizerDoesReturnRandomNumbers(){
        int[] numbers = new int[10];
        for(int i = 0; i<10000;i++){
            numbers[r.getRandomInt(10)] = 1;
        }
        boolean works = true;
        for(Integer i : numbers){
            if(i != 1){
                works = false;
                break;
            }
        }
        assertTrue(works);
    }
}
