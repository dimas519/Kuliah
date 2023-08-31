/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d02;

/**
 * 1 hari ada 1440 menit (24*60)
 * ambil kapan waktu mulai dan kapan waktu akhir
 * tambahkan 1 dari wktu mulai-waktu akhir
 * kemudian sorting yg paling besar pasti berada dipaling belakang (1440)
 * 
 * 
 * 
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Arrays;
public class DAAD02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int waktu[]=new int[1441];
        
        int banyak=sc.nextInt();
        
        for(int i=0;i<banyak;i++){
            int jamPagi=sc.nextInt();
            int menitPagi=sc.nextInt();
            
            int jamMalam=sc.nextInt();
            int menitMalam=sc.nextInt();
            
            int mulai=(jamPagi*60)+menitPagi;
            int selesai=(jamMalam*60)+menitMalam;
            
            while(mulai<=selesai){
                waktu[mulai]++;
                mulai++;
            }
            
            
        }
        Arrays.sort(waktu);
        
        System.out.println(waktu[1440]);
        
    }
    
}
