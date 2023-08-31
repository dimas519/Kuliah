/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koin1;
 
/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class Koin1 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int jumlahKoin=sc.nextInt();
        long start;
        long end;
        long waktu;
        int angkaDicari=sc.nextInt();
        int[] arrayKoin=new int [jumlahKoin];
        int i=0;
                while (i<jumlahKoin){
                    arrayKoin[i]=sc.nextInt();
                    i++;
                }
        start=System.currentTimeMillis();
        boolean hasil =logicKuadrat(arrayKoin,jumlahKoin,angkaDicari);
        end=System.currentTimeMillis();
        waktu= (end-start);
        if (hasil==true){
                System.out.println("ditemukan!");
            }
            else {
                System.out.println("tidak ditemukan!");
            }
            System.out.printf("%d\n",waktu);
            }
            
           
        
                
        
       
    
    public static boolean logicLinear (int[] array, int jumlah ,int nominal) {
             boolean hasil=false;
             Arrays.sort(array);
             int koin=0;
             while (  (jumlah>=0) && (nominal >0) &&(koin <2 ) ) {
                 if(nominal >= array [jumlah-1]){
                     nominal-=array[jumlah-1];
                     koin++;
                 }
                 jumlah--;
             }
                 if(nominal==0){
                     hasil=true;
                 }
                 
                 return hasil;
             }
    
    
    
                
                  
        
    public static boolean logicKuadrat (int[] array, int jumlah ,int nominal){
        boolean hasil=false;
        
        int i=0;
        while (i<jumlah){
            int o=i+1;
            while (o<jumlah){
            if(array[o]+array[i]==nominal){
                hasil=true;
            }
            o++;
        }
        i++;
        }
        return hasil;
    }
 
}