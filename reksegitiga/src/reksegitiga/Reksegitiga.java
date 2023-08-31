/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reksegitiga;

/**
 *
 * @author Dimas
 */
public class Reksegitiga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int n=2;
       int x=0;
       
       int hasil=segitiga(x,n);
       
       
       System.out.println("Hasil" +hasil);
    }
    
    static int segitiga(int x,int n){
        
        if(n==0){
            return x+1;
            
        } else {
            int tambah=(n-1)*3;
            x=x+tambah;
            System.out.println(x);
            return segitiga(x,n-1);
        }
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
