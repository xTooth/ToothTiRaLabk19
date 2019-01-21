
import Solver.FifteenSolver;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main {

     public static void main(String[] args) {
         FifteenSolver solver = new FifteenSolver(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,0,15});
         System.out.println("Started Solving");
         System.out.println( solver.solve().toString());
//        SwingUtilities.invokeLater(() -> {         This is NOT written by me, the code is from: https://rosettacode.org/wiki/15_Puzzle_Game#Java
//            JFrame f = new JFrame();
//            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            f.setTitle("Fifteen Puzzle");
//            f.setResizable(false);
//            FifteenPuzzle puzzle = new FifteenPuzzle();
//            f.add(puzzle, BorderLayout.CENTER);
//            f.pack();
//            f.setLocationRelativeTo(null);
//            f.setVisible(true);
//        });
    }
}