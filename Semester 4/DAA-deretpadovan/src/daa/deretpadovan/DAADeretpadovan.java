/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.deretpadovan;

/**
 *
 * @author Dimas Kurniawan
 */

import java.math.BigInteger;
import java.util.Scanner;
public class DAADeretpadovan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        Padovan p= new Padovan();
        for (int i = 0; i < banyak; i++) {
            System.out.println(p.run(sc.nextInt())); //keluarkan hasilnua
        }        
    }  
}

class Padovan{ //kelas nya
    BigInteger arr[];
    int hitung=3; //langsung start dari ke 3 karena 2 sudah diketahui
    public Padovan(){
        arr=new BigInteger[164]; //soal, tidak lebih dari 163
        arr[0]=BigInteger.valueOf(1);// inisalisasi sesuai soal
        arr[1]=BigInteger.valueOf(0);
        arr[2]=BigInteger.valueOf(0);
    }
    
    public BigInteger run(int req){
         if(hitung>req){ //kalau sudah dihitung
            return arr[req]; //langsung keluarkan
        }else{ //kalau belum
            while(hitung<=req+1){ //hitung dahulu sampai 1 setelahnya
                this.arr[hitung]=arr[hitung-2].add(arr[hitung-3]); //lakukan perhitungan sesuai rumus dan simpan ke array
                this.hitung++;//counter brp yg sudah dihitung
            }
            return arr[req]; //kembalikan nilai hitung idx yg diminta
        }
    }
}
