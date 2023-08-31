/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//package daa.c01;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;

public class DAAC01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        int batas=sc.nextInt();
        int lembur=sc.nextInt();
        
                
        while ((kasus>0 &&kasus <=100)&& (batas>0 && batas <=10000)&&(lembur>0 &&lembur <=5)){
            
                long biaya=0;
                
            long totalRoute=0;
            int banyak=kasus*2; //2 x karena pagi malam
            
            for(int i=0;i<banyak;i++){
                long angka=sc.nextLong();
                if(angka>0){
                totalRoute+=angka; 
                }
            }
            
            int batasPO=kasus*batas;
            
            if(batasPO<totalRoute){
                biaya=(totalRoute-batasPO)*lembur;
            }
            
            
            
            
            System.out.println(biaya);
            
            
            
            kasus=sc.nextInt();
            batas=sc.nextInt();
            lembur=sc.nextInt();
            
            
            
            
            
            
        }
        
        
        
    }
    
}
