/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverse.kattis;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ReverseKattis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack <Integer> tumpukan=new Stack();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int kasus=-1;
        try {
            kasus=Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            System.err.println("error kasus");    
        }
        
//        System.out.println(kasus);
        for(int i=0;i<kasus;i++){
            int angka=-1;
                    
                    try{
                        angka=Integer.parseInt(br.readLine());
                    }catch(IOException ea){
                        System.err.println("error angka");
                    }
            
            tumpukan.push(angka);
            
            
            
        }
        
        
        while (!tumpukan.isEmpty()){
            System.out.println(tumpukan.pop());
        }
        
        
        
        
        
        
        
    }
    
}
