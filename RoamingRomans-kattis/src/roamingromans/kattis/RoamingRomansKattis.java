/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roamingromans.kattis;

/**
 *
 * @author Dimas Kurniawan
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RoamingRomansKattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        double angka=0;
        
        try{
            angka=Double.parseDouble(br.readLine());
        }catch (IOException es){
                System.err.println("error");
         }

        
        
        angka*=5280000;
        angka/=4854;
        
//        System.out.println(angka);
        
        int print=(int) Math.round1(angka);
        
        System.out.println(print);
        
        
    }
    
}
