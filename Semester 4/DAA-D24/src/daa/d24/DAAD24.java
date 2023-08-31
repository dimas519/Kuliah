/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d24;
import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAD24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int panjang=sc.nextInt();
        int batas=(int)Math.pow(10,panjang/2);
        for(int kiri=0;kiri<batas;kiri++){ 
            for(int kanan=0;kanan<batas-kiri;kanan++){
                String con=""+kiri;
                while (con.length()<panjang/2){

                    con="0"+con;
                }
                
                String skanan=""+kanan;
                while (skanan.length()<panjang/2){
                    
                    skanan="0"+skanan;
                }
                
                con+=skanan;
        

                long pow=(long)Math.pow(kiri+kanan,2);
               
                String data=pow+"";
                 if(data.length()>panjang){
                    break;
                }
                while(data.length()<panjang){
                    data="0"+data;
                }
                
//                System.out.println(con);
                
                if(con.equals(data)){
                    System.out.println(con);
                }
            }
        }
    }
    
}



