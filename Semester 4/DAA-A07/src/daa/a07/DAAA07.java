/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a07;

/**
 *
 * @author Dimas Kurniawan
 */

import java.util.Scanner;
public class DAAA07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        for(int y=0;y<kasus;y++){
                        
            int jumlah= sc.nextInt();
            double arr[]=new double[jumlah];
            
            
            for (int i = 0; i < jumlah; i++) {
                int hari=sc.nextInt();
                int denda=sc.nextInt();
                double count=denda/hari*1.0;
                arr[i]=count;
            }
            
            
            int output=0;
            
            while (output< jumlah){
                double max=0.0;
                int idx=0;
                for (int i = 0; i < jumlah; i++) {
                    double data=arr[i];
                    if(data > max){
                        max=data;
                        idx=i;
                    }
                }
                arr[idx]=-1.0;
                if(output!=0){
                    System.out.print(" ");
                }
                System.out.print(idx+1);
                output++;
            }
            System.out.println();
        }
    } 
}
