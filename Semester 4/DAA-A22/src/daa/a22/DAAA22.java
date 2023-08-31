/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a22;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAA22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int topping=sc.nextInt();
        int peserta=sc.nextInt();
        int harga[]=new int[topping];
        for(int i=0;i<topping;i++){
            harga[i]=sc.nextInt();
        }
        int pesanan[][]=new int[peserta][topping];     
        
        for(int i=0;i<peserta;i++){
        int mau=sc.nextInt();
        for(int j=0;j<mau;j++){
            int top=sc.nextInt();
            top=top-1;
            pesanan[i][top]=1;
            }
        }
        
        int i=1;
        boolean logic=true;

        
        while (logic && i<=topping){
        Kombinasi k=new Kombinasi (topping,i,peserta,harga,pesanan);
        k.generateKombinasi();
        int banding=Integer.MAX_VALUE;
        
        if(k.min!=banding){
            logic=false;
            System.out.println(1000+k.min);
            }
        i++;
        }
        
        
    }
    
}

class Kombinasi {

    protected int[] result;
    protected int n;
    int harga[];
    int peserta;
    boolean logic=false;
    int [][] pesanan;
    int total=0;
    
    int min=Integer.MAX_VALUE;
    public Kombinasi(int n, int length,int peserta,int harga[],int [][]pesanan) {
        this.harga=harga;
        this.result = new int[length];
        this.n = n;
        this.peserta=peserta;
        this.harga=harga;
        this.pesanan=pesanan;

    }

    protected void process() {
        boolean isComplete[]=new boolean[peserta];
        total=0;
        for (int i = 0; i < this.result.length; i++) {
            int bil=result[i]-1;
//            System.out.println(bil);
                total+=harga[bil];
                for(int j=0;j<peserta;j++){
                    if(pesanan[j][bil]==1){
                        isComplete[j]=true;
                    }
                }
                
        }

            boolean check=true;
            for (boolean x:isComplete){
                if(!x){
                    check=false;
                }
            }

            if(check){
                if(total<min){
                    min=total;
                }
            }
            
            
        

    }

    public void generateKombinasi() {
        generateKombinasiRek(1, 0);
    }

    public void generateKombinasiRek(int start, int idx) {

        if (idx == this.result.length) {
            process();
        } else {
            for (int i = start; i <= n - this.result.length + idx + 1; i++) {
                this.result[idx] = i;
                generateKombinasiRek(i + 1, idx + 1);
            }
        }

    }
}
