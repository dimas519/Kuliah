/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a14;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA14 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        int arr[]=new int[banyak];
        
        for(int i=0;i<banyak;i++){
            arr[i]=sc.nextInt();
        }
        
        int berapa=sc.nextInt();
        for(int i=0;i<berapa;i++){
        int cari=sc.nextInt();
        bitString bs=new bitString(banyak,arr,cari);
        bs.generateBitString();
        System.out.println(bs.jumlah);
        }
        
    }
    
}


class bitString {
    protected int[] result;
    protected int[] arr;
    protected int jumlah=0;
    protected int cari=0;
    
    public bitString(int n,int [] arr,int cari){
        result=new int[n];
        this.arr=arr;
        this.cari=cari;
    }
    
    protected void generateBitStringRek(int curIdx){
        if(curIdx==-1){
            int i=1;
            if(i==1){
                
            
        process();
        
        i++;
            }
    }
        else {
        result[curIdx]=0;
        generateBitStringRek(curIdx-1);
        result[curIdx]=1;
        generateBitStringRek(curIdx-1);
    }  
    }
    
    protected void process(){
        int counter=0;
        for (int i=0;i<result.length;i++){    //keluar 1 dimmensi
            if(result[i]==1){
                counter+=arr[i];
            }
        }
        
        if(counter==this.cari){
            this.jumlah++;
        }
        
        
        
    }

    
    public void generateBitString()
    {
        generateBitStringRek(result.length-1);
    }    
    

        }