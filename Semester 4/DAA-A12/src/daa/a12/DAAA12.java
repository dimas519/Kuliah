/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a12;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        for(int x=0;x<banyak;x++){
        String kata=sc.next();
        hashing h=new hashing(kata);
        System.out.println(h.hasil());
        }
    }
    
}



class hashing{
    String kata;
    int panjang;
    public hashing(String kata){
        this.kata=kata;
        this.panjang=kata.length();
        panjang--;
    }
    
   long hasil=0;
   
   public long hasil(){
       int pos=0;
       int mod=1;
      while (panjang>=0){
          char x=this.kata.charAt(pos);
          int ascii=x;
          long hitung=(x%31991)*(long)((Math.pow(256,panjang)%31991));

          mod++;
          this.hasil+=hitung;
          panjang--;
          pos++;
      }      
       return this.hasil%31991;
   }
}
