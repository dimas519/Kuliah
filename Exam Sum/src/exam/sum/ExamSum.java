/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package exam.sum;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class ExamSum {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int kasus=sc.nextInt();
        int p=0;
        for(p=0;p<kasus;p++){
            int n=sc.nextInt();
            int arr[]=new int[n];
            int i=0;
            for (i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int cari=sc.nextInt();
                    
            cari(arr,n,cari);
            System.out.println("");
        }
    }
    
    
    
    static void cari (int []arr,int n,int cari){
        
        int j=0,k=0;
        int print=0;
        
        int pas1 []=new int[n];
        int pas2 []=new int [n];
        
        
        for(j=0;j<n;j++){
            for(k=j+1;k<n;k++){
                if(arr[k]+arr[j]==cari){
                    
                    pas1[print]=arr[j];
                    pas2[print]=arr[k];
                    print++;
                    
                    
                    
                    
                }
            }
        }
        if(print==0){
           System.out.println("tidak dapat membeli");
        } else if (print==1){
                    System.out.print("Peter harus membeli buku dengan harga ");
                    System.out.print(pas1[0]);
                    System.out.print(" dan ");
                    System.out.println(pas2[0]);
        } else {
            for(j=0;j<print;j++){
                    System.out.print("Peter dapat membeli buku dengan harga ");
                    System.out.print(pas1[j]);
                    System.out.print(" dan ");
                    System.out.println(pas2[j]);
            }
            
        }
        
        
        
        
        
        
        
    }
    
}
