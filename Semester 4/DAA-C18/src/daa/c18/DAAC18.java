/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c18;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.HashMap;
import java.util.Scanner;
public class DAAC18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hash = new HashMap<String, String>();
        while (true){
            String kiri=sc.next();
            if(kiri.equals("\n")){
                break;
            }
            String kanan=sc.next();
            hash.put(kiri, kanan);
        }
        
        while (sc.hasNext()){
            String nama=sc.next();
            String output=hash.get(nama);
            if(output==null){
                System.out.println("eh");
            }else{
                System.out.println(hash.get(output));
            }
            
        }
        
        
        
        
    }
    
}
