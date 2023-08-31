 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoaretester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class HoareTester {




    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        quickSort1 sort =new quickSort1();
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




class quickSort1{
    private int hoarePartition(int[] inputArray, int left, int right){
        int pivot = inputArray[left];
        int i= left-1;
        int j= right+1;
        while (true)
        {
            do
            {
                j--;
            }
            while(inputArray[j]>pivot);
            
            
            do{
                
                
                i++;
            }while(inputArray[i]<pivot);

            if (i<j)
            {
                int temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
            else;
            {
            return j;
            }
        }
    }

    private void quickSort(int[] arr, int kiri, int kanan){
        if(kiri<kanan){
            int pivotIndex = hoarePartition(arr, kiri, kanan);
            quickSort(arr, kiri, pivotIndex);
            quickSort(arr, pivotIndex+1, kanan);
        }
        }

    public void sort(int[] array){
         quickSort(array, 0, array.length-1);
    }
}