/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.uas04;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAUAS04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
       while(sc.hasNextInt()){
        int jumlah=sc.nextInt();
        int arr[]=new int [jumlah];
        
        for (int i=0;i<jumlah;i++){
            arr[i]=sc.nextInt();
        }
        

        
        looping bs =new looping (jumlah,arr);
              bs.generateBitString();
                
        System.out.println(bs.max);
        }
        
    }
    
}


class looping{
    int jumlah=0;
    int arr[];
    
    public looping (int jumlah, int arr[]){
        this.jumlah=jumlah;
        this.arr=arr;
    }
    
    
    public int list(){
        int lis[]=new int[jumlah];
        int max=Integer.MIN_VALUE;
        
        
        for (int i = 0; i < jumlah; i++) {
         lis[i]=1;   
        }
        
        for (int i = 1; i < jumlah; i++) {
            for (int j = 0; j < jumlah; j++) {
                
            }
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
