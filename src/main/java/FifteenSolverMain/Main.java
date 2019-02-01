package FifteenSolverMain;

/**
 *
 * @author Toothy
 */
public class Main {

    public static void main(String[] args) {

        TextBasedUI ui = new TextBasedUI();
        ui.run();
    }
}
//        FifteenSolverBFS solver = new FifteenSolverBFS();
//        MySolver secondSolver = new MySolver();
//        System.out.println("Started Solving with BFS");
//
//        long startTime = System.nanoTime();
//        System.out.println(Arrays.toString(solver.solve(new int[]{
//            5, 2, 7, 3,
//            6, 1, 11, 4,
//            9, 10, 0, 8,
//            13, 14, 15, 12
//        })));
//        long endTime = System.nanoTime();
//
//        long duration = (endTime - startTime) / 1000000;
//        System.out.println("Time Required " + duration + " ms");
//
//        System.out.println("Started Solving with MySolver");
//
//        long startTime2 = System.nanoTime();
//        System.out.println(secondSolver.solve(new int[]{
//            5,2,7,3,
//            6,1,11,4,
//            9,10,0,8,
//            13,14,15,12
//        }));
//        long endTime2 = System.nanoTime();
//
//        long duration2 = (endTime2 - startTime2) / 1000000;
//        System.out.println("Time Required " + duration2 + " ms");
//        AStarSolver s = new AStarSolver();
//        System.out.println("started a*");
//        long startTime3 = System.nanoTime();
//        System.out.println(Arrays.toString(s.solve(new int[]{
//            5,2,7,3,
//            6,1,11,4,
//            9,10,0,8,
//            13,14,15,12
//        })));
//        
//        long endTime3 = System.nanoTime();
//
//        long duration3 = (endTime3 - startTime3) / 1000000;
//        System.out.println("Time Required " + duration3 + " ms");

