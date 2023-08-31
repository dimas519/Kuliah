/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
//package coklat;
 
/**
 *
 * @author USER
 */
import java.util.Scanner;
public class Coklat {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        int total=0;
        int input;
        int i=0;
        while (i<jumlah && i <15){
            input=sc.nextInt();
            total+=input;
            i++;
        }
        
        String a;
        
        if (total%2==0   || jumlah >1 ){
            System.out.println("coklat dapat dibagi sama rata");
    } else if (total >1 ){
            System.out.println("coklat tidak dapat dibagi 2");
} else {
            System.out.println(a);
    }
}
}