/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package wolimpiade;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class Wolimpiade {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int banyak=sc.nextInt();
        String nama[]=new String[banyak];
        double speed[]=new double[banyak];
        int satu[]=new int[banyak];
        int dua[]=new int[banyak];
    
        int i=0;
        while (i<banyak){
            nama[i]=sc.next();
            speed[i]=sc.nextDouble();
            i++;
        }
        poin poin2=new poin();
        poin2.hitungScore(speed,satu,dua);
        
        i=0;
        while(i<banyak){
        System.out.printf("%s ",nama[i]);
        System.out.printf("%d %d\n",satu[i],dua[i]);
        i++;
        
        
    }
    
}
    
}


class poin{
    
    static void hitungScore(double[] inputArray, int[] emas, int[] perak){
        bagi(inputArray,0,inputArray.length-1, emas, perak);
    }
    
    
    
    
    
    
    
    
    static void score(double[] arr, int kiri, int tengah, int kanan, int[] satu, int[] dua){
        int lSize =  tengah-kiri+1;
        int rSize =  kanan-tengah;
        double [] temp = new double[lSize+rSize];
        for(int i= 0; i<(lSize+rSize);i++){
            temp[i]=arr[kiri+i];
        }
        Arrays.sort(temp);
        int a = lSize+rSize-1;
        int b = lSize+rSize-2;
        for(int i= 0; i<(lSize+rSize);i++){
            if(temp[a]==arr[kiri+i]){
                satu[kiri+i]++;
            }
        }
        for(int i= 0; i<(lSize+rSize);i++){
            if(temp[b]==arr[kiri+i]){
                dua[kiri+i]++;
            }
        }
    }
    static void bagi(double[] inputArray,int kiri,int right, int[] emas, int[] perak){
        if(kiri<right){
            int middle = (kiri+right)/2;
            bagi(inputArray,kiri,middle,emas,perak);
            bagi(inputArray, middle+1, right, emas,perak);
            score(inputArray, kiri, middle, right,emas,perak);
        }
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

