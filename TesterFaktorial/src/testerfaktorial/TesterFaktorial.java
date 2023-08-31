/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testerfaktorial;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class TesterFaktorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       PenghitungFaktorial Faktorial=new PenghitungFaktorial();
       int angka=sc.nextInt();
       System.out.println(Faktorial.hitungFaktorial(angka));
    }
    
}

class PenghitungFaktorial{
    public int hitungFaktorial(int angka){
    if(angka==0){
        return 1;
    }
    else {
        return angka*hitungFaktorial(angka-1);
    }
    }
    
    
}
