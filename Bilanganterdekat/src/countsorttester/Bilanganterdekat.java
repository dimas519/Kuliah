/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package countsorttester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class Bilanganterdekat {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        CountSort sort=new CountSort();
        int n=sc.nextInt();
        int arrayA[]=new int[n];
        int arrayB[]=new int[n];
        int i=0;
        int max=Integer.MIN_VALUE;
        while (i<n){
            int angka=sc.nextInt();
            arrayA[i]=angka;
            if(angka>max){
                max=angka;
            }
            i++;
        }
      arrayB=sort.internalSort(arrayA,arrayB,max);
            int min=Integer.MAX_VALUE;
            i=0;
            while (i+1<n){
                int selisih=arrayB[i+1]-arrayB[i];
                if (min>selisih){
                    min=selisih;
                }
                i++;
            }
            System.out.println(min);
    }
    
}

class CountSort{
   public static int[] internalSort(int[] arrayA, int arrayB[],int k) {
       int[] arrayC=new int[(2*(k+1))];
       int i,j;
       int n=arrayA.length;
       for (j=0;j<n;j++){
           arrayC[k+arrayA[j]]+=1;
       }
       for (i=1;i<=(2*k);i++){
           arrayC[i]+=arrayC[i-1];
       }
       for(j=n-1;j>=0;j--){
           arrayB[arrayC[k+arrayA[j]]-1]=arrayA[j];
           arrayC[k+arrayA[j]]--;
       }
       
       return arrayB;
   }
}