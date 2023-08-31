/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d29;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAD29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> stock = new HashMap<String, Integer>();
        int jumlah=sc.nextInt();
        int kasus=sc.nextInt();
        int uang=sc.nextInt();
        
        for (int i = 0; i < jumlah; i++) {
            String bahan=sc.next();
            int harga=sc.nextInt();
            stock.put(bahan,harga);
        }
        
        for (int s = 0; s < kasus; s++) {
            int beli=sc.nextInt();
            boolean tersedia=false;
            int harga=0;

            for(int u=0;u<beli;u++){
                String bahan=sc.next();
                if(stock.get(bahan)==null){
                   
                    tersedia=true;
                }else{
                    harga+=stock.get(bahan);
                }
            }

            if(tersedia){
                System.out.println("Bahan kurang");
            }else if(harga >uang){
                System.out.println("Uang tidak cukup");
            }else{
                System.out.println("Syarat terpenuhi");
            }
        }
    } 
}
