/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice2;

/**
 *
 * @author Dimas
 */
import java.util.Random;
import java.util.Scanner;

public class Dice2Tester {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Dice2 dadu = new Dice2();
       Random a = new Random();
       int angka=a.nextInt(6);
       angka++;
       dadu.getKocok(angka);
       
      // System.out.println(angka);
       System.out.println(dadu.setTampilan());
        
        
        
    }
    
}



        
    
    
    
    
    
    
    
    
    
    
