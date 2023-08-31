/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package siswa.tk;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class SiswaTk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int kasus =sc.nextInt();
        int i=0;
        
        int[] hasil=new int[kasus];
        
        while (i<kasus){
            int[] tinggi=new int[20];
            int kelas=sc.nextInt();
            
            int j=0;
            while (j<20){
                tinggi[j]=sc.nextInt();
                j++;
            }
            j=0;
            hasil[kelas-1]=insertion (tinggi,20);
            
            i++;
        }
        
        for (i=0;i<kasus;i++){
            System.out.print((i+1)+" ");
            System.out.println(hasil[i]);
        }
        
        
    }
    
    
    
    
        static  int insertion (int[] array,int panjang){
        int i=0;
        int count=0;
        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(array [u-1] >array[u])){
                temp=array[u-1];
                array[u-1]=array[u];
                array[u]=temp;
                u--;
                count++;
        }
            i++;
        }
    return count;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
}
