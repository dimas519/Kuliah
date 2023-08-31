/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a05;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Arrays;
public class DAAA05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()){
            int sum=0;
            int ukuran=sc.nextInt();
            int lagu=sc.nextInt();
            int arr[]=new int[lagu];
            
            for(int i=0;i<lagu;i++){
                arr[i]=sc.nextInt();
            }
            
            Arrays.sort(arr);
            
                lagu--;
            while (lagu>=0){
                if(ukuran>arr[lagu]){
                    ukuran-=arr[lagu];
                    sum+=arr[lagu];
                }
                lagu--;
            }
            
            
            System.out.println("sum: "+sum);
            
        }
        
        
        
        
    }
    
}
