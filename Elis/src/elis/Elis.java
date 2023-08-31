/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package elis;

/**
 *
 * @author USER
 */
import java.util.Scanner;
public class Elis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
        int jumlah=sc.nextInt();
        int arr[]=new int [jumlah];
        
        for (int i=0;i<jumlah;i++){
            arr[i]=sc.nextInt();
        }
        

        
        bitString bs =new bitString (jumlah,arr);
              bs.generateBitString();
                
        System.out.println(bs.max);
        }
    }
    
}


class bitString {
    protected int[] result;
    int size;

    int max=Integer.MIN_VALUE;
    int arr[];
    public bitString(int n,int [] arr){
        result=new int[n];
        this.size=n;
        this.arr=arr;
    }
    
    protected void generateBitStringRek(int curIdx){
        if(curIdx==-1){
        process();
    }
        else {
        result[curIdx]=0;
        generateBitStringRek(curIdx-1);
        result[curIdx]=1;
        generateBitStringRek(curIdx-1);
    }  
    }
    
    public void process(){
        int count =0;
        int i=0;
        int temp=0;
        
        int kecil=0;
        while (i<result.length ){
               if(result[i]==1){
                   
                   if(kecil==0){
                    if(arr[i]  >  temp){
                    temp=arr[i];
                    count++;
                    } else {
                        kecil=1; //ambil masuk ke yg mengecil terus
                    }
                   }
                   
                   if(kecil==1){

                        if(arr[i]<temp){
                            temp=arr[i];
                            count++;
                        }else{
                            break; //dinamic programming jika sudah turun naik lagi maka stop
                        }
                    }
               }
               
               
            i++;
        }
        
         max(count);
    }

    
    public void generateBitString()
    {
        generateBitStringRek(result.length-1);
    }    
    

        


public void max(int bil){
    if(bil> this.max){
    this.max=bil;
    }


  
}
}