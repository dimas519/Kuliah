/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package subsetsum;

/**
 *
 * @author USER
 */
import java.util.Scanner;
import java.lang.Math;
public class SubsetSUm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s=sc.nextInt();
        int arrS[]=new int [s];
        int i=0;
        for (i=0;i<s;i++){
            arrS[i]=sc.nextInt();
        }
        int t=sc.nextInt();
        int arrT[]=new int[t];
        for (i=0;i<t;i++){
            arrT[i]=sc.nextInt();
        }

       int size=(int)Math.pow(2,s);
        bitString bit=new bitString(s,size);
        bit.generateBitString();
        
        String arr[] =new String [size];
        arr=bit.getHasil();
        
        int j,k,l;
        int bil,temp=0, counter=0;
        
        for (k=0;k<t;k++){  // untuk menjaring semua t
            counter=0;
            bil=arrT[k];
            
            
            
            
        
            for (j=0;j<size;j++){   // untuk mengambil semua kemungkinan nya
                temp=0;
        
                
                for (i=0;i<s;i++){  //loop perbaris
                    if (arr[j].charAt(i) == '1' ){
                        temp+=arrS[i];                      
                    }
                }
        
                if(bil==temp){
                counter++;
                }
            }
            
            
            
            System.out.println(counter);
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
    }
    
}


class bitString {
    protected int[] result;
    protected String[] gabungan;
    protected int size;
    public bitString(int n,int size){
        result=new int[n];
        this.size=size;
       gabungan =new String[size];
       
      
    }
    
    public void process(){
       String a="";

        for (int i=0;i<result.length;i++){
        a=a+(result[i]+"");
        }
        
        for (int i=0;i<size;i++){
            if (gabungan[i]==null){
            gabungan[i]=a;
            break;
            }
        }

} 
    public String[] getHasil(){
        return gabungan;
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
    
    
    public void generateBitString()
    {
        generateBitStringRek(result.length-1);
    }    
    

        }


