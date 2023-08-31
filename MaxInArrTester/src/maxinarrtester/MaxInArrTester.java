/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxinarrtester;

/**
 *
 * @author USER
 */
import java.util.Scanner;
public class MaxInArrTester {

  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        int i=1;
        
        while (i<=kasus){
            int jumlah=sc.nextInt();
            int arr[]=new int [jumlah];
            int j=0;
            
            for (j=0;j<jumlah;j++){
                arr[j]=sc.nextInt();
            }
            
            
            MaximumInArray max=new MaximumInArray(arr);
            
            int hasil=max.Max();
            
            System.out.printf("Kasus ke-%d: %d\n",i,hasil);
            
            
            
            
            
            
        }    
    }
    
}


class MaximumInArray{
    int [] arr;
    
    public MaximumInArray(int[] arr){
        this.arr=arr;
    }
    
    
public int MaxRec(int[] arr,int awal,int akhir){
    if(awal==akhir){
        return arr[awal];
    } else {
        int tengah=(awal+akhir)/2;
        int maxKiri=MaxRec(arr,awal,tengah);
        int maxKanan=MaxRec(arr,tengah+1,akhir);
        if (maxKiri>maxKanan){
            return maxKiri;
        } else {
            return maxKanan;
        }
    }
    
    
    
    
        
}    
        
        public int Max (){
            return MaxRec(arr,0,arr.length-1);
        }
        
        
}


