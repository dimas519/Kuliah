/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rangesorting;

/**
 *
 * @author Dimas
 */

import java.util.Arrays;
import java.util.Scanner;
public class RangeSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int banyak=sc.nextInt();
        int[] arr=new int[banyak];
        
        
         int i=0;
         while (i<banyak){
             arr[i]=sc.nextInt();   
           i++;
       }

        
         int bawah=sc.nextInt(); 
         int atas=sc.nextInt();

        int banyakSort=(atas-bawah)+1;
        
        System.out.println("baaa"+banyakSort);
        
        int[] print =new int[banyakSort];

        i=0;
        int l=0;
        
        while (i<banyak){
            if (i+1 >=bawah && i < atas){
               print[l]=arr[i];
                       l++;
            }           
            
            i++;
        }
        
        
        
        
        
        
         for (i=0;i<banyakSort;i++){
             System.out.println("haha");
             System.out.println("aaaaa"+print[i]);
         }
        
        
        
        Arrays.sort(print);

        
       
    
        int idx=sc.nextInt();
    


     System.out.println(print[idx-1]);
    
    
    
    }
    
}
