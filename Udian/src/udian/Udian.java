/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package udian;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class Udian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc =new Scanner (System.in);
        Searching cari=new Searching();
        
        int jumlah=sc.nextInt();
        
        String arr[]=new String[jumlah];
        int i=0;
        for (i=0;i<jumlah;i++){
            arr[i]=sc.next();
        }
        
        
        Arrays.sort(arr);

        String menang=sc.next();
        int index=0;
        
        index=cari.pencarian(arr, jumlah, menang);

        
        
        if (index==jumlah-1){
        System.out.println(arr[index-2]);
        System.out.println(arr[index-1]);
        System.out.println(arr[index]);  
        } else if(index==0){
            System.out.println(arr[index]);
        System.out.println(arr[index+1]);
        System.out.println(arr[index+2]);  
        } else {
        System.out.println(arr[index-1]);
        System.out.println(arr[index]);
        System.out.println(arr[index+1]);
        }
    }
    
}

class Searching {

    public int pencarian(String[] arr,int jumlah,String menang){
        int j=0;
        int temu=0;
            for(j=0;j<jumlah;j++){
            if(arr[j].equals(menang)){
                temu=j;
                break;
            }
        }
        
        return temu;
        
    }
   
}