package FifteenSolverMain;
import SolverBFS.FifteenSolverBFS;



public class Main {

     public static void main(String[] args) {
         
         FifteenSolverBFS solver = new FifteenSolverBFS(new int[]{5,2,7,3,6,1,0,4,9,10,11,8,13,14,15,12});
         
         System.out.println("Started Solving");
         
         long startTime = System.nanoTime();        
         System.out.println( solver.solve().toString());
         long endTime = System.nanoTime();
         
         long duration = (endTime - startTime)/1000000; 
         System.out.println("Time Required " + duration + " ms");
    }
}




