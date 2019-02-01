/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FifteenSolverMain;

import MySolver.MySolver;
import SolverBFS.FifteenSolverBFS;
import AStarSolver.AStarSolver;

/**
 *
 * @author Toothy
 */
class Solvers {

    private MySolver mySolver;
    private FifteenSolverBFS bFS;
    private AStarSolver aStar;

    public Solvers() {
        mySolver = new MySolver();
        bFS = new FifteenSolverBFS();
        aStar = new AStarSolver();
    }

    public char[] solve(int[] unsolved, int choise) {
        switch (choise) {
            case 1: {
                return bFS.solve(unsolved);
            }
            case 2: {
                return mySolver.solve(unsolved);
            }
            case 3: {
                return aStar.solve(unsolved);
            }
            default: {
                System.out.println("INVALID CHOISE");
                return new char[0];
            }
        }

    }
}
