package pscproject;

/**
 *
 * @author Kurni
 */


import java.util.Scanner;

public class PSCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int population = 32; //NANTI DI SCANNER
        double mutationRate=0.693;
                
                
                
                
        //proses baca inputan dan buat puzzlenya
       InputOutput io = new InputOutput();
       String path="C:\\Users\\Kurni\\Documents\\NetBeansProjects\\PSCProject\\src\\pscproject\\input.txt";
       char[][] input = io.reader(path);
       Puzzle lightUp=new Puzzle(input);
       
       
       GenericsAlgorithm GA=new HeuristikSearch();
       Population pop=GA.GASearch(population, io.seed(), lightUp,mutationRate); //PROSES PERTAMA yaitu buat populasi awal
      // GA.CountFitnessGA(pop); //kemudian hitung dulu berapa fitnessnya
       
       
     
        
        
    }
    
}
