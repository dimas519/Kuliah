/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergetester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class MergeTester {

    /**
     * @param args the command line argnts
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        MergeSort sort =new MergeSort();
        int n=sc.nextInt();
        int[] arr=new int[n];
        int i=0;
        while (i<n){
            arr[i]=sc.nextInt();
            i++;
        }
        sort.sort(arr);
        for(i=0;i<n;i++){
        System.out.print(arr[i]);
    }
        
    }
}
class MergeSort{
    
    
    
    
    public void  mergeSort(int arr[],int left,int right){
        
        
        
        
         if (left < right){
             int mid = (left+right)/2;
             mergeSort(arr, left, mid);
             mergeSort(arr, mid+1, right);
             merge(arr, left, mid, right);
             

         }
    }
    
    
    public void merge(int[]arr, int left, int mid, int right){
        int lSize=mid-left+1;
        int rSize=right-mid;
     int i=0;
     
     
    int tempL[]=new int[lSize+1];
    int tempR[]=new int[rSize+1];
    
    for(i=0;i<lSize;i++){
        tempL[i]=arr[left+i];
    }
 
    
    for( i=0;i<rSize;i++){
        tempR[i]=arr[mid+i+1];

    }    
    
    
        tempL[lSize]=Integer.MAX_VALUE;
        tempR[rSize]=Integer.MAX_VALUE;
        
        
        
        
        
        
    int idxL=0;
    int idxR=0;
    i=left;
    
    
    
    for(i=left;i<=right;i++){
        
        
        
        if (tempL[idxL] <= tempR[idxR]){
            arr[i] = tempL[idxL];
            
            idxL++;
        }
        
        
        
        else{
            arr[i] = tempR[idxR];
            idxR++;
        }
        
        
        
        
     //   System.out.println(arr[i]);
        
    }
    }
    
    public void sort(int arr[]){
        
        mergeSort(arr,0,arr.length-1);
              
        
        
        
    } 
}

        
        
        
    
    
    
    
    
    
    
    
    
