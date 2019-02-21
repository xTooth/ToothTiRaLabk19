/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

/**
 *
 * @author Toothy
 */
public class Randomizer {
    
    /**
     * 
     * @param bound upper limit for the generated integer. (the bound itself gets excluded)
     * @return a "randomish" integer between 0 and the upper bound.
     */
    
    public int getRandomInt(int bound){
        
        long seed = System.nanoTime();
        
        int random = (int) seed % 37; // turn long to some randomish integer
        
        if (random < 0){            //make sure its a positive number
            random = random * random;
        }
        
        while(random >= bound){       // make smaller until its within the given bound.
            random = (random / 2) -1;
        }
        
        
        return random;
    }
    
    
    
}
