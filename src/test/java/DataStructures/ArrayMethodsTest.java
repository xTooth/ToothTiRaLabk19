/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Toothy
 */
public class ArrayMethodsTest {
    
    private ArrayMethods methods;
    
    @Test
    public void toStringWorks(){
        methods = new ArrayMethods();
        String  string = methods.charArrayToString(new char[1]);
        assertEquals("Path:",string);
    }
    
    @Test
    public void toStringWorksWithContent(){
        methods = new ArrayMethods();
        String  string = methods.charArrayToString(new char[]{'W','O','O','P'});
        assertEquals("Path: W O O P",string);
    }
    
}
