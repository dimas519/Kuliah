/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a04;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAA04 {

    /**
     * @param args the command line arguments
     * 
     * menggunakan bitString jika 1 maka untuk orang pertama koin tersebut
     * dan jika 0 maka koin idex untuk orang kedua
     * kemudian selisihkan orang pertama dan kedua jika
     * setiap baris bitString cari selisih antara orang pertama dan kedua
     * jika selisih 0 maka artinya imbang 
     * dan jika tidak maka minimumya karena sudah dicari diawal
     * 
     * 
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        int arr[]=new int[banyak];
        
        for(int i=0;i<banyak;i++){
            arr[i]=sc.nextInt();
        }
        bitString bs=new bitString(banyak,arr);
        bs.generateBitString();
        
        int hasil=bs.min;
        
        if(hasil==0){
            System.out.println("Dapat dibagi rata.");
        }else {
            System.out.println("Dibagi dengan selisih "+hasil+".");
        }
    }
    
}


class bitString {
    protected int[] result;
    int arr[];
    int min=Integer.MAX_VALUE;
    public bitString(int n,int arr[]){
        this.arr=arr;
        result=new int[n];
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
        int kiri=0;
        int kanan=0;
        for (int i=0;i<result.length;i++){    //keluar 1 dimmensi
            if(result[i]==1){                 
            kiri+=arr[i];
            }else{
                kanan+=arr[i];
            }
        }
        int selisih=Math.abs(kiri-kanan);
        
        if(selisih<min){
            min=selisih;
        }
    }

    
    public void generateBitString()
    {
        generateBitStringRek(result.length-1);
    }    
    
        }