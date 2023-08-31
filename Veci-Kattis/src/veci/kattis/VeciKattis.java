/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veci.kattis;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class VeciKattis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input=sc.next();
        int temp=Integer.parseInt(input);
        
        Permutasi per=new Permutasi(input.length(),input);
        per.generatekAryString();
        
        int o[]=per.per;
        Arrays.sort(o);
        
        
        int print=0;
      for(int x:o){
          if(x>temp){
              System.out.println(x);
              print=1;
              break;
          }
          
          
      }
      
      
      if(print==0){
          System.out.println(print);
          
      }
        
        
    }
    
}



class Permutasi{
    protected int[] result;
    protected boolean[] mark;
    String arr;   
    int per[];
    int pos=0;
    
    public Permutasi(int n, String arr){
        this.result=new int [n];
        this.mark=new boolean[n];
        this.arr=arr; 
        this.per=new int[1000];
    }
    
    protected void generatePermutasiRek(int curIdx){
       if(curIdx==-1){
           process();
       } else {
           for (int i=0;i<result.length;i++){
               if(this.mark[i]==true){
                   this.mark[i]=false;
                   result[curIdx]=i;
                   generatePermutasiRek(curIdx-1);
                   this.mark[i]=true;
               }
           }
       }
    }
        
       public void process(){
           String temp="";
           
        for (int i=0;i<result.length;i++){
            int idx=result[i];
            temp+=arr.charAt(idx)+"";
        }
        
         
        int check=Integer.parseInt(temp);
        per[pos]=check;
        this.pos++;
        
        
        
        
    } 
        
        public void generatekAryString()
    {
        for(int i=0;i<this.mark.length;i++){
            this.mark[i]=true;
        }
        generatePermutasiRek(this.result.length-1);
    }
        
        
    }
