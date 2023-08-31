/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.mod.m12;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.ArrayList;
import java.util.Scanner;
public class DAAMODM12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int jarak=sc.nextInt();
        int fulltank=sc.nextInt(); 
        int jSPBU=sc.nextInt();
        int tempuh=0; // berapa (satuan) yang sudah ditempuh
        int berhenti=0;//berapa kali berhenti
        int sisa=fulltank;//awalnya fulltank
       
        ArrayList <Integer> arr=new ArrayList();
        
        int i=0;
        while (i<jSPBU) {
            int berikutnya=sc.nextInt(); //dimana letak spbu berikutnya
            int jarakBerikutnya=berikutnya-tempuh; //berapa jarak ke spbu berikutnya
            
            if(sisa<jarakBerikutnya){ //apakah sisa lebih banyak ? (cukup untuk ke spbu berikutnya  kalau tidak(lebih kecil ) maka isidulu
                arr.add(i); //tampung dimana dia berhenti
                sisa=fulltank-jarakBerikutnya; //bensin menjadi fulltank lagi dikurangi dengan jarakkedua karena next loop sudah ada di pom depan
                berhenti++; //pemberhentian nambah 1
            }else{
                sisa-=jarakBerikutnya; //kalau cukup maka kurangi bensin sampai pom berikutnya
            }            
            tempuh=berikutnya; // sesuai yg perhitungan sisa jika kurang posisi iterasi berikutnya sudah sampai dipom depan;
            i++;// i ++ untuk menghitung berapa spbu
        }
        
        
        if(sisa+tempuh >=jarak){ //apakah bisa sampai dengan sisa bensin yg ada dan jarak sisanya
            System.out.println(berhenti);
            for(Integer x: arr){  //dan print dimana saja dia berhenti dengan forEach
                    System.out.println(x);
                }
        }else { //sedangkan kalau cukup maka coba isi dahulu dipom terakhir
                arr.add(i); //masukan dimana letak pom terakhir
                sisa=fulltank-(jarak-tempuh); //coba lakukan perhitungan berapa sisa di jarak dibandingkan jika full tank
                berhenti++; //berhentinya jadi nambah 1 karena berhenti di yg terakhir
           
            if(sisa<0){ //jika terknya iterasi terakhir tidak cukup sisanya tidak ada maka 
                System.out.println(-1); //print -1 sesuai soal
            }else{ //jika cukup print sesuai sooal
                System.out.println(berhenti); 
                for(Integer x: arr){
                    System.out.println(x);
                }
            }
        }

        
        
    }
    
}
