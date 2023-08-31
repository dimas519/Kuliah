/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
//package fillthecontainers;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class FillTheContainers {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int kasus = sc.nextInt();
        int l=0;
        
        for(l=0;l<kasus;l++){
            
            int n=sc.nextInt();
            int m=sc.nextInt();
            
            int arr[]=new int [n];

            
            int kapasitas=0;
            
            int i=0;
            for (i=0;i<n;i++){
                int angka=sc.nextInt();
                arr[i]=angka;
               kapasitas+=angka;
                
            }
            
            boolean bagi= cukup(kapasitas,arr,m,n,wadah);
            
            int wadah[]=new int[m]; 
            
            while (bagi){
             kapasitas--;
             bagi=cukup(kapasitas,arr,m,n,wadah);
            
            
            }
         
            int max=Integer.MIN_VALUE;
            for(i=0;i<m;i++){
                max=Math.max(max, wadah[i]);
            }
            
            System.out.println(max);
            
            
 
        }
        
    }
        

public static boolean cukup(int kapasitas,int[] arr,int m,int n,int[] wadah){
    int pakai=0;
    int vol=0;
    
    int i=0;
    
    while ( pakai+1 <m && i < n){
        int gelas=arr[i];
        
        if(vol+gelas <= kapasitas){
            vol+=gelas;
            
        } else {
            pakai++;
            vol=gelas;
        }
        i++;
        
        wadah[pakai] =vol;
    }
    
    if(pakai+1 < m){
        return true;
    } else {
        return false;
    }
    
}



}