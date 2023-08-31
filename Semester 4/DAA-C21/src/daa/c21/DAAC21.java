/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c21;

import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */

public class DAAC21 {

    /**
     * 
     * logikanya tambahkan yg pertama kemudian kedua sampai akhir lakukan pengecekan
     * apakah sudah ada ?. jika sudah maka cukup tambahkan counter saja jika tidak 
     * maka tambahkan ada dengan 1. kemudian pada akhirnya hitung jumlah acara /jumlah total
     * 
     * setelah itulakukan sorting dengan abjad terkecil dan hasil rationya cukup mengikuti saja
     *  terakhir print semua element dengan nama program ratio dengan ketelitian 3 dibelakang koma
     * 
     * 
     * 
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] arr = new String[10000];
        int[] counter = new int[10000];

        int isi = 0;

        int banyak = 0;
        while (input.equals("-") == false) {

            boolean in = true;
            for (int i = 0; i < isi; i++) {
                String banding = arr[i];

                if (input.equals(banding)) {
                    in = false;
                    counter[i]++;
                }

            }

            if (in) {

                arr[isi] = input;
                counter[isi]++;
                isi++;
            }

            banyak++;
            input = sc.nextLine();
        }
            sorting(arr,counter,isi-1);
            
            
        for (int i = 0; i < isi; i++) {
            double atas = counter[i] * 1.0;
            double size = (atas / banyak) * 100;
           
            System.out.printf("%s %.3f",arr[i],size);
            System.out.println("%");

        }

        
        
        

    }

    public static void sorting(String[] kata, int banyak[], int isi) {
        for (int i = 0; i < isi; i++) {
            for (int j = 0; j < isi - i; j++) {
                if ((kata[j].compareTo(kata[j + 1])) > 0) {
                    String tukar = kata[j];
                    kata[j] = kata[j + 1];
                    kata[j + 1] = tukar;

                    int tukarInt = banyak[j];
                    banyak[j] = banyak[j + 1];
                    banyak[j + 1] = tukarInt;
                }
            }
        }

    }

}
