/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koin;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class KoinMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random =new Random();
        Scanner sc =new Scanner (System.in);
        long startLinear;
        long endLinear;
        long waktuLinear;
        long startKuadrat;
        long endKuadrat;
        long waktuKuadrat;
        int jumlahKoin=sc.nextInt();
        int angkaDicari=sc.nextInt();
        
        int b =0;
         int[] arrayKoin=new int [jumlahKoin];
        while (b<jumlahKoin){
        
                    arrayKoin[b]=random.nextInt(5000);
                    b++;
                }
        startLinear=System.currentTimeMillis();
        boolean hasilLinear =logicLinear(arrayKoin,jumlahKoin,angkaDicari);
        endLinear=System.currentTimeMillis();
        
        
        startKuadrat=System.currentTimeMillis();
        boolean hasilKuadrat =logicKuadrat(arrayKoin,jumlahKoin,angkaDicari);
        endKuadrat=System.currentTimeMillis();
        
        
        
        waktuLinear= (endLinear-startLinear);
        waktuKuadrat=(endKuadrat-startKuadrat);
         
         
        if (hasilLinear==true){
                System.out.println("hasil Linear: Ditemukan");
        }else {
                System.out.println("hasil Linear: tidak ditemukan!");
            }
            System.out.printf("%d\n",waktuLinear);
        
             
       if (hasilKuadrat==true){
                System.out.println("hasil Kuadrat: Ditemukan");
       } else {
                System.out.println("hasil Kuadrat: tidak ditemukan!");
            }
            System.out.printf("%d\n",waktuKuadrat);
    
        
                
        }     
    
    public static boolean logicLinear (int[] array, int jumlah ,int nominal) {
             boolean hasil=false;
             Arrays.sort(array);
             int koin=0;
             while (  (jumlah>0) && (nominal >0) &&(koin>2 ) ) {
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