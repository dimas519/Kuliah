/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.m11;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Arrays;
import java.util.Scanner;
public class DAAM11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ukuran=sc.nextInt();
        int wombat=sc.nextInt();
        int dodo=sc.nextInt();
        
        int arr[][]=new int[ukuran][ukuran];
        
//        for(int i=0;i<ukuran;i++){
//            for(int j=0;j<ukuran;j++){
//                arr[i][j]=sc.nextInt();
//            }
//        }
//        

        kAryString k=new kAryString(ukuran,wombat ,dodo);
        k.generatekAryStringrek(arr,ukuran);
        int i=k.total;
        System.out.println(1);
    }
    
}

class kAryString{
    protected int[] result;
    protected int k;
    int total=0;
    int cpy[][];
    int wombat;
    int kapibara;

    
    
    public kAryString(int k,int wombat,int kapibara){
        result=new int[k];
        this.wombat=wombat;
        this.kapibara=kapibara;


        this.cpy=new int[k][k];
       

    }
    
    public void generatekAryStringrek(int[][] arr,int k){
        int jwom=0;
        int jkap=0;
        int total=0;
        int loop=0;
k--;
       for(int i=0;i<k;i++){
           for(int j=0;j<k;j++){
               if(arr[i][j]==0){
                   cpy[i][j]=result[loop];
                   if(result[k]!=0) total++;
                   if(result[k]==1) jwom++;
                   if(result[k]==2) jkap++;
                   loop++;
                   
                
                   
                   
                   
               }
           }
       }
        System.out.println(Arrays.deepToString(cpy));
        
        
        
        
    }
    
//    
//    public void loop(int[][] arr,int k){
//        while(k>0){
//            k--;
//            generatekAryStringrek(arr,k);
//        }
//    }
    
}