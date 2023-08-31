/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.kuispq;

/**
 *
 * @author Dimas Kurniawan
 */


import java.util.Scanner;
import java.util.TreeMap;

public class DAAKuisPQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         TreeMap<String, Integer> hmap = new TreeMap<String, Integer>();//pakai hash map
        
        
        int jumlah=0; //jumlah awal nya 0
        while (1==1){
            String kata=sc.nextLine(); //ambil kata secara full
            if(kata.equals(".")){ //jika ketemu titik hentikan loop forever
                break; //untuk berenti
            }
            
            
            if(hmap.get(kata)==null){ //jika belum ada maka
                hmap.put(kata,1); // insert atau put kata dengan value 1 karena dia pertama
            }else {
                hmap.replace(kata, hmap.get(kata)+1); //jika sudah ada maka cukup tambahkan 1 dari yg terakhir tadi
            }
            
            
            jumlah++; //tambahkan jumlah karena sudah berhasil dimasukan
            
            
        }       
        
        for (String x : hmap.keySet()){ // untuk setiap key
            System.out.print(x+" "); // print keynya
            System.out.printf("%.4f\n",hmap.get(x)*100.0/jumlah); //kemudian value dari key tersebut dikali 100.0 untuk persentase floating dan juga dibagi banyak input
        }

    }
    
}
