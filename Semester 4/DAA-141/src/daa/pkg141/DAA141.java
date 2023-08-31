/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.pkg141;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAA141 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        mod m= new mod ();
        for (int i = 0; i < jumlah; i++) {
        Long a=sc.nextLong();
        Long b=sc.nextLong();
        Long c=sc.nextLong();
        
        long test=m.abmodc(a, b, c);
            System.out.println(test);
        }

        
    }
    
    
    
    
}


class mod{
    
    /*gunakan yg ke tiga (x * y) mod n = ((x mod) * (y mod n)) mod n  
    kita simpan terus karena kalau pangkat berati dikali terus
    misal 2^3 maka
    2 * 2 *2 jadi 
    (2 mod c) dapat simpan -> dnc sekaligus menyimpan yg sudah dihitung
    tiap iterasi di mod c sesuai rumus
    */
    
    
    int temp=0;
    
public long abmodc(long a, long b, long c) {
        if(a==0){
            return 0;
        }
        
        
        if(b==0){
            return 1;
        }
         long hasil;
        if(b==1){
            return a%c;
        }else {
            long mod=a%c;
            hasil=abmodc(mod,b/2,c);
            long res=(hasil*hasil) %c;
            
            
            
            if(b %2==1){

               res=(res*mod)%c;
               
            }
            return res;
        }
        
        
    }
    
    



        

        
        
        
  
    
    
    
    
}