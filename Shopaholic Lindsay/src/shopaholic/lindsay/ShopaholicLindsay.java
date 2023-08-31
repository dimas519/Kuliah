/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package shopaholic.lindsay;




/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class ShopaholicLindsay {

   
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        quickSort1 sort=new quickSort1();
        int kasus=sc.nextInt();
        int i=0;
       
        while (i<kasus){
             int total=0;
            int m=sc.nextInt();
            int harga[]=new int[m];
            int y=0;
            while (y<m){
                harga[y]=sc.nextInt();
            y++;
            }
            sort.sort(harga);
            int x=m-3;
            while (x>=0){
               total+= harga[x];
                x-=3;
            }
            i++;
            System.out.println(total);
    }
    
}
}
    
    

class quickSort1{
    
    private void quickSort(int[] inputArray,int left,int right){
        if(left<right){
            int pivotIndex = lomutoPartition(inputArray,left,right);
            quickSort(inputArray,left,pivotIndex-1);
            quickSort(inputArray,pivotIndex+1,right);
        }
    }
private int lomutoPartition(int[] inputArray,int left, int right){
        int pivot = inputArray[right];
        int i = left-1;
        for(int j=left;j<right;j++){
            if(inputArray[j]<=pivot){
                i = i+1;
                int temp = inputArray[i];
                inputArray[i]=inputArray[j];
                inputArray[j]=temp;
            }
        }
        i++;
        int temp = inputArray[i];
        inputArray[i]=inputArray[right];
        inputArray[right]=temp;
        return i;
    }

    public void sort(int[] inputArray){
        quickSort(inputArray,0,inputArray.length-1);
    }


}