/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c15;

/**
 *
 * @author Dimas Kurniawan
 */

import java.util.HashMap;
import java.util.Scanner;
public class DAAC15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Integer> pr = new HashMap<String, Integer>();
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        
        for(int i=0;i<banyak;i++){
            pr.put(sc.next(),sc.nextInt());
        }
        
        int batas=sc.nextInt();
        int jumlahpr=sc.nextInt();
        int butuh=0;
        boolean tidak=false;
        for(int i=0;i<jumlahpr;i++){
            String materi=sc.next();
            if(pr.get(materi)!=null){
            butuh+=pr.get(materi);
            }else {
                tidak=true;
            }
        }
        
        if(butuh-5>batas || tidak){
            System.out.println("Kerjakan sendiri");
        }else if(butuh<=batas){
            System.out.println("Yaayyy");
        }else{
            System.out.println("Terlambat");
        }
        
        
    }
    
}
