/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quality.aly_kattis;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class QualityAly_kattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int angka=sc.nextInt();
        double hasil=0;
        
        for(int i=0;i<angka;i++){
            double persen=sc.nextDouble();
            double bil=sc.nextDouble();
            
            
            hasil+=(persen*bil);
        }
        
        
        System.out.printf("%.3f\n",hasil);
        
    }
    
}
