/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akar3;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import java.lang.Math;
public class Akar3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        int i=0;
        int bilangan=0;
        double akar=0;
        for(i=0;i<kasus;i++){
        bilangan=sc.nextInt();    
        akar=Math.pow(bilangan,0.3333333333333333);
            System.out.printf("Akar kubik dari %d adalah %.2f\n",bilangan,akar);
        }
    }
    
}
