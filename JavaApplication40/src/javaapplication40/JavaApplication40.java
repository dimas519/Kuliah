/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication40;

/**
 *
 * @author Dimas
 */
public class JavaApplication40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
     int panjang=5;
     panjang--;
     int count=0;
    int hasil =COUNT_PRIME(count,panjang);
     
     System.out.println(hasil);
     
     
            
        }
    
                
    static int COUNT_PRIME(int count,int panjang){
      int[] n = {1,2,3,4,5};
        if (panjang==0){
            return count;
        } else {
            int j=panjang-1;
            while (j>=0){
            int selisih=n[panjang]-n[j];
            
            
            System.out.println(panjang);
            System.out.println(j);
            System.out.println(selisih);
            System.out.println("----");
            if (selisih<0){
                selisih=selisih*-1;
            }
            System.out.println(isPrime(selisih));
            if (isPrime(selisih)){
                count=count+1;
            } else {
            }
            j--;
            }
            
            
            
                return COUNT_PRIME(count,panjang-1);
            
        }
        
    }
        
        static boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
  
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
  
        return true; 
    } 
        
        
        
        
        
        
        
        
        
        
    }
    
    
    

        
        
        
        
        
        
}      
                
                
        
        
        
        
        
    
    
    

