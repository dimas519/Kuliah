/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package kelereng;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;   
public class Kelereng {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        
        while ((n!=0)&&(k!=0)){
            int kelereng[]=new int[n];
            int i=0;
            while (i<n){
                
                kelereng[i]=sc.nextInt();
                i++;
            }
            insertion(kelereng,n);
             i=0;
            while (i<k){
                int angka=sc.nextInt();
                int j=0;
                int print=0;
                while ((j<n)&&(print==0)){
                    if (angka==kelereng[j]){
                        System.out.printf("%d ditemukan di %d\n",angka,j+1);
                                print=1;
                    }
                    j++;
                } 
                if(print==0){
                    System.out.printf("%d tidak ditemukan\n",angka);
                }
                i++;
            }
            
            
            
            n=sc.nextInt();
            k=sc.nextInt();
            
        }
    }
    
    
    
   static void insertion (int[] array,int panjang){
        int i=0;

        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(array [u-1] >array[u])){
                temp=array[u-1];
                array[u-1]=array[u];
                array[u]=temp;
                u--;
        }
        i++;
        }
   }
    
}
