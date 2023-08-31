/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarraytester;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import java.lang.*;

public class MyArrayTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ukuran=sc.nextInt();
        int arr[]=new int[ukuran];
        for (int i=0;i<ukuran;i++){
            arr[i]=sc.nextInt();
        }
        MyArray ma=new MyArray();
        
        int hasil=ma.sumInArray(arr);
        System.out.println(hasil);
        
        
        
    }
    
}



class MyArray{
    int[] arr;
    
    
    public int sumInArray(int [] arr){
        int panjang=arr.length;
        if(panjang==1){
            return arr[0];
        }
        else {
            int pKiri=panjang/2;
            int pKanan=panjang-pKiri;
            int arrKiri[]= new int[pKiri];
            int arrKanan[]=new int [pKanan];
            System.arraycopy(arr,0,arrKiri,0,pKiri);
            System.arraycopy(arr, pKiri, arrKanan, 0, pKanan);
            
            
            for (int i=0;i<pKiri;i++){
                System.out.print(arrKiri[i]+" ");
            }
            System.out.println("");
            for (int i=0;i<pKanan;i++){
                System.out.print(arrKanan[i]+" ");
            }
            System.out.println("");
            System.out.println("");
 
            
            return sumInArray(arrKiri)+sumInArray(arrKanan);
            
            
            
        }
    }
    
   
}
