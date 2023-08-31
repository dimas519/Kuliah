/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tali;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class Tali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int kasus=sc.nextInt();
        
        int i=0;
        
        
        while (i<kasus){
            int hasil=0;
            int banyak=sc.nextInt();
            String[] tali =new String[banyak];
            
            int j=0;
            
            while (j<banyak){
                tali[j]=sc.next();
                j++;
            }
            
            j=0;
            int[] blue = new int[banyak];
            int[] red= new int[banyak];
            

            
            
            
            int jblue=0;
            int jred=0;
            
            while (j<banyak){
                int panjang=tali[j].length();
                if(tali[j].charAt(panjang-1)=='B'){
                    blue[jblue]=Integer.parseInt(tali[j].substring(0,panjang-1));
                    jblue++;
                } else {
                    red[jred]=Integer.parseInt(tali[j].substring(0,panjang-1));
                    jred++;
                }
                j++;
            }
            
            Arrays.sort(blue);           
           Arrays.sort(red);
           
           
           
           
            j=banyak-1;
            int sambung=1;

            if(jred==0 || jblue==0){
                hasil=0;
            } else if(jred>jblue){
                
                while (jblue>0){
                    hasil+=blue[j]+red[j]-sambung;
                    sambung=2;
                    jblue--;
                    j--;
                
                } 
            }else {
                while (jred>0){
                    hasil+=blue[j]+red[j]-sambung;
                    sambung=2;
                    jred--;
                    j--;
                }
                
            }    
                i++;
                if(hasil>0){
                hasil--;
                }
                System.out.printf("Case #%d: %d\n",i,hasil);
        }
        
        
    }
    
}


