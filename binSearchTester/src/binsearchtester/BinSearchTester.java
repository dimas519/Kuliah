/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binsearchtester;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class BinSearchTester { 
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        Sorting urut=new Sorting();
        Searching cari=new Searching();
        
        int jumlah=sc.nextInt();
        int angka=sc.nextInt(); // yg dicari
        int arr[]=new int[jumlah];
        int i=0;
        for (i=0;i<jumlah;i++){
            arr[i]=sc.nextInt();
        }
        
        
        urut.insertion(arr, jumlah);

        
       boolean hasil= cari.binSearch(arr, jumlah, angka);
        
        
        
        
        if(hasil==true){
            System.out.println("Ada");
          } else {
            System.out.println("Tidak ada");
        }
        
        
        
     
   
        
        
    }
    
}


class Searching {

    public boolean binSearch (int[] arr,int panjang,int angka){
        if (panjang<=3){
            if(arr[0]==angka|| arr[1]==angka || arr[2]==angka ){
                return true;
            } else {
                return false ;
            }
            
            
            
            
        } else {
            int bawah=0,atas,batasKiri;
            if (panjang%2==0){
               batasKiri=panjang/2;          
               if(arr[batasKiri]>= angka){
                bawah=0;
                atas=batasKiri-1;
                } else {
                 bawah=batasKiri;
                 atas=panjang-1;
                }
               panjang=panjang/2;
               
            } else {
                
               
                batasKiri=(panjang/2)-1;
                
                if(arr[batasKiri]>=angka){
                    bawah=0;
                    atas=batasKiri;
                    panjang=(panjang/2);
                    
                } else {
                    bawah=(panjang/2);
                    atas=panjang-1;
                    panjang=(panjang/2)+1;
                }
            }

            int salinan[]=new int[panjang];
            
            salin(arr,salinan,atas,bawah,panjang);
            
            return binSearch(salinan,panjang,angka);
            
           
            }
        }
    

    public void salin(int[] arr,int[] salinan,int atas,int bawah,int panjang){

        int i=0;
        while (bawah<=atas){
            salinan[i]=arr[bawah];
            bawah++;
            i++; // lupa
        }     
        
    }
}

class Sorting{
public  int[] insertion (int[] array,int panjang){
        int i=0;

        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(array [u-1] >array[u])){
                temp=array[u-1];
                array[u-1]=array[u];
                array[u]=temp;
                u--;
        }
            i++;
        }
    return array;
    }
}