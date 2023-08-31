/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice3tester;

import java.util.Random;

/**
 *
 * @author Dimas
 */
public class Dice3Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Dice3 dadu = new Dice3();
       Random a = new Random();
       int angka=a.nextInt(6);
       angka++;
       dadu.getKocok(angka);

       
       String kembali=dadu.setTampilan();

       
       switch (kembali){
           case "SATU":
               Dice3.Spot3 dice =Dice3.Spot3.SATU;
               System.out.println(dice.getAngka());
               break;
           case "DUA":
               Dice3.Spot3 dice2 = Dice3.Spot3.DUA;
               System.out.println(dice2.getAngka());
               break;
           case "TIGA":
                Dice3.Spot3 dice3 = Dice3.Spot3.TIGA;
               System.out.println(dice3.getAngka());
               break;
            case "EMPAT":
               Dice3. Spot3 dice4 = Dice3.Spot3.EMPAT;
               System.out.println(dice4.getAngka());
               break;
            case "LIMA":
                Dice3.Spot3 dice5 = Dice3.Spot3.LIMA;
               System.out.println(dice5.getAngka());
               break;
               case "ENAM":
                Dice3.Spot3 dice6 = Dice3.Spot3.ENAM;
               System.out.println(dice6.getAngka());
               break;   
       }

    }

    }
    
    
    
    
    









    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
