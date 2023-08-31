/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d11;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAD11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        int mod=sc.nextInt();
        for(int i=0;i<input;i++){
            String output=sc.next();
            output=output.toLowerCase();
            int dpn=output.charAt(0)-'a';
            int blkg=Integer.parseInt(output.substring(3,6));
            System.out.println((dpn+blkg)%mod);
        }
    }
    
}
