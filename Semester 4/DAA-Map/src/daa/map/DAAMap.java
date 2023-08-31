/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.map;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.HashMap;
import java.util.Scanner;

public class DAAMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int jumlah = sc.nextInt();

        int max = 0; //0 karena belum ada yg dapat perangko
        int sepupu = 0; // karena belum ada juga orang yg dapat
        HashMap<Integer, Integer> bagi = new HashMap<Integer, Integer>(); //untuk yang kali ini gunakan hashmap
        int counter=0;// counter untuk menghitung ada berapa perangko counter


        for (int i = 0; i < jumlah; i++) {
            
            int perangko = sc.nextInt(); //sebagai input


            if  (bagi.get(perangko) == null) { //jika untuk perangko tersebut tidak ada valuenya maka 
                bagi.put(perangko, 1); //masukan perangko dan beri nilai 1 / apapun bebas karena sebagai penanda bahwa sudah pernah diberikan ke sepupu itu
//                System.out.println(perangko);
                counter++; //tambahkan jumlah perangko yang didapat
            } else if(bagi.get(perangko)==1) { //jika sudah pernah maka
                sepupu++; //lanjut ke sepupu berikutnya
//                System.out.println("jumlah :"+counter);
//                System.out.println();
                if (counter > max) { //jika counter lebih besar dari total yang terbanyak maka
                    max = counter; //ganti value max ke counter
                }
                counter =1; //dan jadikan counter dengan 1
                bagi.clear(); // kemudian kosongkan hashmap karena sudah ke sepupu baru
                bagi.put(perangko, 1); // kemudian masukan tadi yang tidak nerhasil masuk
//                System.out.println(perangko);
            }
            
            if(i==jumlah-1){ // jika sudah terakhir maka hitung 
                sepupu++; //ini untuk sepupu terakhir
                if (counter > max) { //jika lebih besar maka ambil yg terbsar
                    
                    max = counter;
                }                
            }

        }

//        System.out.println();
    
    

    System.out.print (sepupu+" ");  //output sesuai permintaan soal
    System.out.println (max);

}

}
