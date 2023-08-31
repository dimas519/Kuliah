/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the temlate in the editor.
 */
//package daa.dododantebu;

/**
 *
 * @author Dimas KurniawanAccept': 'application/json',
 */
import java.util.Scanner;
public class DAADododantebu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); // ini scanner
        int rumah=sc.nextInt();// jumlah rumahnya
        int saatIni=0; // jumlah saat ini yang dibawa karena berlebih atau kurang
        int bobot=0; // energi yang sudah dikeluarkan
        int i=1; //penghitung jumlah berapa rumah yg sidah dilalui
        int angka=sc.nextInt(); // rumah pertama
            while (i<rumah){ //dari 1 setelah pertama sampai 1 terakhir
               bobot +=Math.abs(saatIni+angka); //tambahkan energi dengan angka saatIni dipegang ditambah dengan yg batu
                saatIni+=angka; // jumlah saat ini ditambah kelebihan atau kekurangannya
                angka=sc.nextInt(); //ambil rumah berikutnya
                i++; // ini counter rumah
            } //tutup while 
        System.out.println(bobot); //print energi yg dikeluarkan
    } // tutup method mai
}
