/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kombinasiexhaustivesearch;

import java.util.Scanner;
public class KombinasiExhaustiveSearch {

   
    public static void main(String[] args) {
        Kombinasi k=new Kombinasi(4,2);
        k.generateKombinasi();
        Scanner sc = new Scanner(System.in);
        
        
        
    }
    
}

class Kombinasi{
protected int[] result;
protected int n;

public Kombinasi(int n,int length){
    this.result=new int[length];
    this.n=n;
    
}

protected void process(){
        for (int i=0;i<this.result.length;i++){
            System.out.print(this.result[i]+" ");
        }
        System.out.println("");
    } 

public void generateKombinasi(){
    generateKombinasiRek(1,0);
}

public void generateKombinasiRek(int start,int idx){
    
    if (idx==this.result.length){
        process();
    } else {
        for (int i=start;i<=n-this.result.length+idx+1;i++){
            this.result[idx]=i;
            generateKombinasiRek(i+1,idx+1);
        }
    }
}


        }