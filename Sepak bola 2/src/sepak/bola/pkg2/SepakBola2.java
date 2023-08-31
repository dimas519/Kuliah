/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sepak.bola.pkg2;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class SepakBola2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int jumlah= sc.nextInt();
         bola2[] bola21=new bola2[jumlah];
        int banyak= sc.nextInt(); 
        int i=0;
  
        
        while(i<jumlah){
       String Inama=sc.next();
       int Ikekuatan=sc.nextInt();
       int Ikelincahan=sc.nextInt();
      int Ikesalahan=sc.nextInt();
       bola21[i]=new bola2 (Inama,Ikekuatan,Ikelincahan,Ikesalahan);
       i++;
        }
     i=0;
     Arrays.sort(bola21);
             while (i<banyak){
                 System.out.println(bola21[i]);
                 i++;
             }
    }
}

        
        
        
        
  
class bola2 implements Comparable<bola2>{
    private String nama;
    private int kekuatan;
    private int kelincahan;
    private int kesalahan;
    
    
public bola2(String nama,int kekuatan, int kelincahan,int kesalahan){
    this.nama=nama;
    this.kekuatan=kekuatan;
    this.kelincahan=kelincahan;
    this.kesalahan=kesalahan;
    
}
@Override
  public int compareTo(bola2 bola21){
      if(this.kekuatan<bola21.kekuatan){
            return 1;
        }else if (this.kekuatan==bola21.kekuatan){
            if(this.kelincahan<bola21.kelincahan){
                return 1;
            }else if(this.kelincahan==bola21.kelincahan){
                if(this.kesalahan>bola21.kesalahan){
                    return 1;
                }else if(this.kesalahan==bola21.kesalahan){
                    return 0;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
  @Override
   public String toString() {
       String output=this.nama+" "+this.kekuatan+" "+this.kelincahan+" "+this.kesalahan;
       return output;
   }



}