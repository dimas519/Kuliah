/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c19;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class DAAC19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        HashMap<String, Integer> all = new HashMap<String, Integer>();
        sc.nextLine();
        
        for(int i=0;i<banyak;i++){
            String kata=sc.nextLine();
            
            int panjang=kata.length();
            kata=kata.toLowerCase();
            for(int j=0;j<panjang;j++){
                char x=kata.charAt(j);
                int b=x;
                if( (b>=97 && b<=122)){
                if(all.get(x+"")==null){
                    all.put(x+"", 1);
                }else {
                    all.put(x+"", all.get(x+"")+1);
                }
                }
                
                
                
            }
        }
        
        List<String> keys = new ArrayList(all.keySet());
        Collections.sort(keys);
        
        
        
        for (String x : keys){
            System.out.println(x+" "+all.get(x));
        }
    }
    
}
