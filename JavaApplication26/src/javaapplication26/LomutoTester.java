/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class LomutoTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        QuicksortLomuto sort =new QuicksortLomuto();
        int n =sc.nextInt();
        int[] arr=new int[n];
        int i=0;
        while (i<n){
            arr[i]=sc.nextInt();
            i++;
        }
        sort.sort(arr);
        for(i=0;i<n;i++){
        System.out.println(arr[i]);
    }
    
}
}
class QuicksortLomuto{
    
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