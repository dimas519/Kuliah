/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchstring;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class BinarySearchString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr[]={"aaaa","bbbb","cccc","dddd","eeee"};
        
        
        binSearch bs=new binSearch(arr,5);
        
        System.out.println(bs.binsearchGenerator("aaaa"));
        System.out.println(bs.binsearchGenerator("bbbb"));
        System.out.println(bs.binsearchGenerator("cccc"));
        System.out.println(bs.binsearchGenerator("dddd"));
        System.out.println(bs.binsearchGenerator("eeee"));
        System.out.println(bs.binsearchGenerator("eeef"));
        
        
    }
    
}


class binSearch{
    String arr[];
    int banyak;
    String cari;
    
    public binSearch(String arr[],int banyak){
        this.arr=arr;
        this.banyak=banyak;
    }
    
    private int binSearchRek(int kiri,int kanan){
        
 
        
        
        if(kanan-kiri<=1){
            if(arr[kanan].equals(cari) || arr[kiri].equals(cari)){
                if(arr[kanan].equals(cari)){
                    return kanan;
                }
                return kiri;
            }else {
                return -1;
            }
        
            
        } else {
            int tengah=(int)(kanan-kiri)/2;
            if( (kanan-kiri) %2==0){
                tengah++;
            }
            
             if(arr[tengah].compareTo(cari)<=0){
                return binSearchRek(tengah,kanan);
            } else {
                return binSearchRek(kiri,tengah);
            }
 
        } 
    }
    
    
    public int binsearchGenerator(String Cari){
        this.cari=Cari;
        return binSearchRek(0,banyak-1);
        
    }
    
    
    
    
}
