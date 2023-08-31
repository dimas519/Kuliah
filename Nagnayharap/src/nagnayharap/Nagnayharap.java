/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nagnayharap;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class Nagnayharap{

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        int i=0;
        for (i=0;i<n;i++){
            arr[i]=sc.next();
        }
        
        
        int test=sc.nextInt();
        
        for(i=0;i<test;i++){
        int temu=-1;
        String cari=sc.next();
        
        int j=0;
        
        for(j=0;j<n;j++){
            if(arr[j].equals(cari)){
                temu=j;
                break;
            }
        }
 
        
        
        
        
        
        System.out.println(temu);
        }
    }
    
}
