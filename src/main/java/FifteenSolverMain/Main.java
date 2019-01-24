package FifteenSolverMain;

import MySolver.MySolver;
import SolverBFS.FifteenSolverBFS;

public class Main {

    public static void main(String[] args) {

        FifteenSolverBFS solver = new FifteenSolverBFS(new int[]{
            5, 2, 7, 3,
            6, 1, 0, 4,
            9, 10, 11, 8,
            13, 14, 15, 12
        });
        MySolver secondSolver = new MySolver();
        System.out.println("Started Solving with BFS");

        long startTime = System.nanoTime();
        System.out.println(solver.solve().toString());
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000;
        System.out.println("Time Required " + duration + " ms");

        System.out.println("Started Solving with MySolver");

        long startTime2 = System.nanoTime();
        System.out.println(secondSolver.solve(new int[]{
            5,2,7,3,
            6,1,0,4,
            9,10,11,8,
            13,14,15,12
        }));
        long endTime2 = System.nanoTime();

        long duration2 = (endTime2 - startTime2) / 1000000;
        System.out.println("Time Required " + duration2 + " ms");
    }
}
