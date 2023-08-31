/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.uas03;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAUAS03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        int arr[]=new int[jumlah];
        
        for (int i = 0; i < jumlah; i++) {
            int angka=sc.nextInt();
            if(angka==0){
                angka=-1;
            }
            arr[i]=-1;
        }
        
        //dodo 1 point
        // kapibara 2 point 
        
        
        
        //ide utama gunakan k arry string 3 jika sudah sama dengan 0 maka yg sisi satunya tidak boleh
        
        kAryString k=new kAryString(3);
        k.generatekAryString(arr);
        System.out.println(k.jumlah);
        
        
    }
    
}




class kAryString{
    protected int[] result;
    protected int k;
    protected int jumlah=4;
    
    
    public kAryString(int k){
        result=new int[k];
        this.k=k;

    }
    
    protected void generatekAryStringrek(int curIdx,int arr[]){
        if(curIdx==-1){
            
            boolean checker=true;
            for(int i=0;i<k;i++){
               
                
                if(i>0){
                    if(arr[i-1]-result[i]<0){
                        checker=false;
                        break;
                    }
                }else if(i<3){
                    if(arr[i+1]-result[i]<0){
                        checker= false;
                        break;
                    }
                }
                
                
            }
            if(checker){
                jumlah++;
                
            }
        }
        else {
            for(int i=0;i<k;i++){
                result[curIdx]=i;
                generatekAryStringrek(curIdx-1,arr);
            }
        }
    }
    
    public void generatekAryString(int arr[]){
        generatekAryStringrek(k-1,arr);
    }    
}
