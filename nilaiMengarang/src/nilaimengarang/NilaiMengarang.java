/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 


/**
 *
 * @author Dimas
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NilaiMengarang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x=0;
        try {
            x=Integer.parseInt(br.readLine());
        }
        catch(IOException e) { 
            System.out.println("Error!");
        }
        int kasus=1;
        while (kasus<=x){
        CountSort sort=new CountSort();
        int n=0;
        try{
            n=Integer.parseInt(br.readLine());
        }
        catch(IOException o) {   
            System.out.println("Error!");
        }
        int arrayA[]=new int[n];
        int arrayB[]=new int[n];
        int i=0;
        int max=Integer.MIN_VALUE;
        while (i<n){
            int angka=0;
             try{
                 angka=Integer.parseInt(br.readLine());
            }
             catch(IOException j) {   
                 System.out.println("Error!");
                }
            arrayA[i]=angka;
            if(angka>max){
                max=angka;
            }
            i++;
        }
      arrayB=sort.internalSort(arrayA,arrayB,max);
           
      System.out.printf("Kasus ke-%d:\n",kasus);
      int index=0;
      try{
          index=Integer.parseInt(br.readLine());}
        catch(IOException j) {   
            System.out.println("Error!");}
          while (index!=0){
              
          System.out.println(arrayB[n-index]);
          try{
          index=Integer.parseInt(br.readLine());}
        catch(IOException j) {   
            System.out.println("Error!");}
          }
      
      
      
      
      
      
      
      
      
        kasus++;
        }
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