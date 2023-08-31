/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adifferentproblem;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class ADifferentProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        while (sc.hasNextLong()){
        Long satu=sc.nextLong();
        Long dua=sc.nextLong();
        
        System.out.println(Math.abs(dua-satu));
        }
        
    }
    
}
