/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.c25;

/**
 * 
 * 
 * ada sedikit perbedaan dari yg dikelas
 * untuk yg kelas yg pertama masuk tapi malah masuk terkahir untuk yg ini 0 didepan diikuti
 * dengan nomor yang akan dihash
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAC25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bagi=sc.nextInt();  //berapa banyak kolom yang akan digunakan   
        while (bagi!=0){
        String idx=sc.next(); //apa key yang akan dimasukan
        int panjang=idx.length(); //ada berapa banyak isi yang akan dimasukan
        int baris=(panjang/bagi); //berapa banyak baris yang dibutuhkan scara minimal
        int kurang=0; // variabel yang akan menghitung apakah ia pas jika tidak maka berapa banyak yang diperlukan;
           if(panjang%bagi!=0){ //untuk jika tidak pas maka perlu 1 baris yg mana depan nya ada 0* ( 0 sebanyak yang dibutuhkab)
            baris++; //jika tidak pas maka perlu tambahan 1 baris lagi untuk /agar bisa menampung semua nya
            kurang=(bagi*baris)-panjang; //menghitung berapa banyak 0 dibutuhkan untuk mengepaskan
        }
        int arr[][]=new int[baris][bagi];  //menyimpan dengan terbalik dengan yg dikelas        
        int x=0;
        int y=0;
        while (kurang>0){ //memasukan 0 sebanyak yang dibutuhkan agar array( dan tahu dimana kita dapat mulai masukan nomor karena terbalik (dengan yg kelas))
            arr[y][x]=0; //masukan 0 di depannya yg menandakan bahwa kekurangan
            x++; // geser kesamping terus menerus untuk sebagai kita tahu dimana angka asli harus dimulai
            kurang--; //kekurangan dapat dikurangi agar menjadi 0 (pas)
        }      
        int i=0;
        for(y=y;y<baris;y++){ //memasukan angka yang dinput kan
            for(x=x;x<bagi;x++){ //y=y dan x=x untuk mengantisipasi bahwa sudah ada 0 lebih dahulu didepannya sehingga baris plg atas harus melanjutkan baru setelah pindah baris di 0kan lagi
                arr[y][x]=idx.charAt(i)-48; //setiap char diubah kedalam bentuk int dengan cara mengurangi 48 karena ascii dari 0 itu 48
                i++;
            }          
            x=0;
        }           

//            System.out.println(  );
        System.out.println();
        bagi=sc.nextInt();
        }      
    }   
}
