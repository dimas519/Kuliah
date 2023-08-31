/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radix;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.lang.Math;


public class Radix{
    
    public static void main(String[] args){
        RadixSort rad =new RadixSort();
        Scanner sc =new Scanner (System.in);
        
        int banyak=sc.nextInt();
        int panjang=sc.nextInt();
        
        
        int[] array=new int[banyak];
        
        int i=0;
        
        while (i<banyak){
            array[i]=sc.nextInt();
            i++;
        }
        rad.Rm(array,banyak,panjang);
        
        i=0;
        while (i<banyak){
            System.out.println(array[i]);
            i++;
        }       
        
    }
    
}


















class RadixSort {
    public int[] Rm (int[] array, int banyak,int panjang) {
        insert sort=new insert();

        
        int angka[]=new int[banyak];
        int i=0;
        
        
        
        while (i<banyak){
            angka[i]=array[i];
            i++;
        }
        
        
        
        i=0;
        while (i<panjang){
            
            
            int j=0;          
            while (j<banyak){
            angka[j]=angka[j]%10;
            j++;
            }
            
            
            
            array=sort.insertion(array,angka, banyak);            
            j=0;          
            while (j<banyak){
                j++;
            } 
            i++;
            j=0;          
            while (j<banyak){
                int pembagi=1;
                if (i>=0){
                    pembagi=(int)Math.pow(10,i);
            }
            angka[j]=array[j]/pembagi;

                
                
                
                
            j++;
            }
            
            
            
            return array;
            
           
        }
    }
    
}

class insert{
   
    public  int[] insertion (int[] array,int[] angka ,int panjang){
        int i=0;

        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(angka [u-1] >angka[u])){
                temp=angka[u-1];
                angka[u-1]=angka[u];
                angka[u]=temp;
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