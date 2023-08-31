/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c20;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAC20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   HashMap<String, Integer> pr = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        int kalimat=sc.nextInt();
        for(int i=0;i<banyak;i++){
            pr.put(sc.next(),sc.nextInt());
        }
        
        for(int i=0;i<kalimat;i++){
            int biaya=0;
            for(int j=0;j<=100;j++){
                String kata=sc.next();
                if(kata.equals(".")){
                    break;
                }              
                if(pr.get(kata)!=null){
                    biaya+=pr.get(kata);
                }
            }
            System.out.println(biaya);
        }
        
        
    }
}
