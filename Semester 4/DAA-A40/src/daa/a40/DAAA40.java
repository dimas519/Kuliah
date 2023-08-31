/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a40;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        jumlah++;
        int arr[]=new int[jumlah];
        for(int i=1;i<jumlah;i++){
            arr[i]=sc.nextInt();
        }
        Rekursif rek=new Rekursif(arr);
        
        int banyak=sc.nextInt();
        for(int i=0;i<banyak;i++){
        int inKiri=sc.nextInt();
        int inKanan=sc.nextInt();
        
        int kiri=rek.root(inKiri);
        int kanan=rek.root(inKanan);
        
        if(kiri>kanan){
            System.out.println(kiri);
        }else{
            System.out.println(kanan);
        }
        }
    }
}

class Rekursif{
    int arr[];
    int counter=0;
    public Rekursif(int arr[]){
        this.arr=arr;
    }
        
    public int root(int element){
        System.out.println(arr[element]+" "+element);
        if(arr[element]==element){
            int temp=counter;
            counter=1;
            return temp;
            
        }else {
            counter++;
            return root(arr[element]);
        }
    }
    
    
    
}




