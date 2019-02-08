/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FifteenSolverMain;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Toothy
 */
public class TextBasedUI {

    private final Scanner scanner;
    private final Solvers solver;

    /**
     *
     */
    public TextBasedUI() {
        scanner = new Scanner(System.in);
        solver = new Solvers();
    }

    /**
     * Runs the text based UI, its terrible but it does the job.(for now)
     */
    public void run() {
        boolean keepGoing = true;
        System.out.println("Welcome to the textbased solver! \n"
                + " This is just a simple application designed to speed up testing of the application before it has a graphics based UI.\n");
        while (keepGoing) {
            System.out.println(" Commands:\n"
                    + " 1 -> Run demo cases \n"
                    + " 2 -> Input own case \n"
                    + " 3 -> Quit \n"
                    + " 4 -> Test randomly shuffled case");
            int command;

            while (true) {
                try {
                    System.out.println("command:");
                    command = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command, try again");
                }
            }
            switch (command) {
                case 1: {
                    runDemos();
                    break;
                }
                case 2: {
                    runUserInput();
                    break;
                }
                case 3: {
                    System.out.println("Good bye");
                    keepGoing = false;
                    break;
                }
                default: {
                    runRandom();
                    break;
                }

            }

        }

    }

    private void runDemos() {
        System.out.println("Game being solved:" + "\n" + " 5  2  7  3\n"
                + " 6  1 11  4\n"
                + " 9 10  0  8\n"
                + "13 14 15 12\n");

        System.out.println("Started Solving with BFS");
        long startTime = System.nanoTime();
        System.out.println(Arrays.toString(solver.solve(new int[]{
            5, 2, 7, 3,
            6, 1, 11, 4,
            9, 10, 0, 8,
            13, 14, 15, 12
        }, 1)));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("Time Required " + duration + " ms\n");

        System.out.println("Started Solving with MySolver");
        startTime = System.nanoTime();
        System.out.println(solver.solve(new int[]{
            5, 2, 7, 3,
            6, 1, 11, 4,
            9, 10, 0, 8,
            13, 14, 15, 12
        }, 2));
        endTime = System.nanoTime();

        long duration2 = (endTime - startTime) / 1000000;
        System.out.println("Time Required " + duration2 + " ms");
        System.out.println("");
        System.out.println("Started  Solving with A*");
        startTime = System.nanoTime();
        System.out.println(Arrays.toString(solver.solve(new int[]{
            5, 2, 7, 3,
            6, 1, 11, 4,
            9, 10, 0, 8,
            13, 14, 15, 12
        }, 3)));

        endTime = System.nanoTime();

        duration = (endTime - startTime) / 1000000;
        System.out.println("Time Required " + duration + " ms");
    }

    private void runUserInput() {
        System.out.println("WARNING: Algorithms are far from optimal, the code might not catch wonky inputs,\n"
                + " and I dont yet know where the points of failure lie.\n"
                + " The A* algorithm should perform just fine atleast up to 15 moves.");
        System.out.println("Think of the gameboard like this: Each position is numbered from 0 -15.\n"
                + "0 represents the top left corner and 15 the bottom right ->\n"
                + " 0  1  2  3\n"
                + " 4  5  6  7\n"
                + " 8  9 10 11\n"
                + "12 13 14 15\n"
                + "Each tile is also represented by its corresponding number where 0 is the empty space.\n"
                + "Please give the current gameState as integers from 0 - 15");
        int[] state = new int[16];
        int i = 0;
        while (i < 16) {
            System.out.println("Give the number for index " + i + ": ");
            try {
                state[i] = Integer.parseInt(scanner.nextLine());
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
        }
        System.out.println("Choose algorithm to run: 1 -> BFS , 2-> My solver, 3 -> A*, 4-> All solvers");
        while (true) {
            try {
                System.out.println(Arrays.toString(solver.solve(state, Integer.parseInt(scanner.nextLine()))));

                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }

        }
    }

    private void runRandom() {
        
        Shuffler shuffler = new Shuffler(40);
        int[] state = shuffler.shuffle();
        
        System.out.println("Choose algorithm to run: 1 -> BFS , 2-> My solver, 3 -> A*, 4-> All solvers");
        while (true) {
            try {
                System.out.println(Arrays.toString(solver.solve(state, Integer.parseInt(scanner.nextLine()))));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }

        }
    }

}
