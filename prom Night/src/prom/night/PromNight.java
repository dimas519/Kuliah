/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package prom.night;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class PromNight {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        quickSort1 sort=new quickSort1();
        int kasus=sc.nextInt();
        int i=0;
       
        while (i<kasus){
             boolean logika=true;
            int m=sc.nextInt();
            int n=sc.nextInt();
            int Mahasiswa[]=new int[m];
            int Mahasiswi[]=new int[n];
            int y=0;
            while (y<m){
            Mahasiswa[y]=sc.nextInt();
            y++;
            }
            y=0;
             while (y<n){
            Mahasiswi[y]=sc.nextInt();
            y++;
            }         
            sort.sort(Mahasiswa);
            sort.sort(Mahasiswi);
            y=0;
            while ((y<m)&&(logika==true)){
                if(Mahasiswa[y]<Mahasiswi[y]){
                    logika=false;
                }
                y++;
            }
            if(logika==true){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            i++;
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