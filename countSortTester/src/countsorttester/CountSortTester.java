/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countsorttester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class CountSortTester {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        CountSort sort=new CountSort();
        int n=sc.nextInt();
        int arrayA[]=new int[n];
        int arrayB[]=new int[n];
        int i=0;
        int max=Integer.MIN_VALUE;
        while (i<n){
            int angka=sc.nextInt();
            arrayA[i]=angka;
            if(angka>max){
                max=angka;
            }
            i++;
        }
      arrayB=sort.internalSort(arrayA,arrayB,max);
        i =0;

            
        for (i=0;i<n;i++){
            System.out.println(arrayB[i]);
        }
        
    }
    
}


class CountSort{
   public static int[] internalSort(int[] arrayA, int arrayB[],int k) {
       int[] arrayC=new int[(2*(k+1))];
       int i,j;
       int n=arrayA.length;
       for (j=0;j<n;j++){  //untuk menentukan jumlah muncul
           arrayC[k+arrayA[j]]+=1;
        }
       
       
       
       
       for (i=1;i<=(2*k);i++){  // untuk menentukan kumulatif
           arrayC[i]+=arrayC[i-1];
           System.out.print(i + " ");
           System.out.println(arrayC[i]);
       }
       
       
       for(j=n-1;j>=0;j--){ //untuk menggeser array 
           arrayB[             arrayC      [    k+arrayA[j] ]      -1]            =arrayA[j];
           arrayC[k+arrayA[j]]--;
           
       }
       
       return arrayB;
   }
}
