/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package so2;

/**
 *
 * @author Kurni
 */


import java.util.Random;
import java.util.Scanner ;

public class SO2 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran=new Random();
        
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Math.abs(ran.nextInt());
        }
        
        int numThread=split.numOfThreads(n);
        
        Producer[] p=new Producer[numThread];
        Consumer[] c=new Consumer[numThread];
        
        int bagian=n/numThread;
        
        int bawah=0;
        int atas=n/numThread;
        
        for (int i=0;i<numThread;i++){
            indexing idx=new indexing();
            p[i]=new Producer(idx,arr,bawah,atas);
            c[i]=new Consumer(idx,bawah,atas);
            
            bawah=atas;
            atas=(bagian*(i+1));
            
        }
        
        
        long timeKeseluruhan=0;
        int hasil=0;
        
        for (int i=0;i<numThread;i++){
            p[i].start();
            c[i].start();
            
        }
        
        
        try{
            for (int i=0;i<numThread;i++){
            p[i].join();
            c[i].join();
            long waktuIterasi=(long)(c[i].getLength()* 0.000001);
            int hasilIterasi=c[i].getHasil();
                System.out.println("Total nilai penjumlahan Thread "+(i+1)+" adalah "+hasilIterasi+" Penjumlahan memiliki durasi "+waktuIterasi);
            hasil+=hasilIterasi;
            timeKeseluruhan+=waktuIterasi;
            
        }
        }catch (Exception x){
            
        }
        
        
        System.out.println("Total waktu keselruhan yang dibutuhkan "+timeKeseluruhan+" dengan hasil "+hasil);
        
    }
    
}
