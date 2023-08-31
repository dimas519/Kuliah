/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harsadnumber;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class HarsadNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bilangan=sc.nextInt();
        
        boolean ketemu=true;
        
        while (ketemu){
            int num=getNum(bilangan);
            
            if(bilangan%num==0){
                ketemu=false;
            } 
            bilangan++;
        }
        
        bilangan--;
        System.out.println(bilangan);
        
        
        
    }
    
    
    public static int getNum(int bilangan){
            String masuk=bilangan+"";
            int panjang=masuk.length();
        
            int hasil=0;
            for(int i=0;i<panjang;i++){
                hasil+=Character.getNumericValue(masuk.charAt(i));
            }
        
//        if(hasil>9){
//            return getNum(hasil);
//        }else {
            return hasil;
//        }
        
        
    }
    
    
    
}
