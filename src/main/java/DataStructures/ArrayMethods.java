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
public class ArrayMethods {

    public String charArrayToString(char[] array) {
        String ans = "Path:";
        for (char c : array) {
            if (c == '\u0000') {
                break;
            }
            ans += " " + c;
        }
        return ans;
    }

}
