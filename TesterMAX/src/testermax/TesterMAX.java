/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testermax;

/**
 *
 * @author Dimas
 */

import java.util.Scanner;
public class TesterMAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        PencariNilaiMax pencari=new PencariNilaiMax();
        
        int ukuran=sc.nextInt();
        int[] array=new int[ukuran];
        int i=0;
        while(i<ukuran){
            
            array[i]=sc.nextInt();
            i++;
        }
        System.out.println(pencari.cariNilai(array));
        
        
        
    }
    
}

class PencariNilaiMax{
    private int cariNilaiRek(int[] array, int n){
        if(n==0){
            return array[0];
        } else {
            int t=cariNilaiRek(array,n-1);
            if(t>array[n]){
                return t;
                
            }
            else {
                return array[n];
            }
        }
        
    }
    public int cariNilai(int[] array){
        return cariNilaiRek(array,array.length-1);
    }
    
}
