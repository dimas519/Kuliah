/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author Dimas
 */
import java.util.LinkedList;


public class Vector{
    
    
    
    
    


    
    public static void main(String[] args) {
        LinkedList vek=new LinkedList();
        System.out.println(vek.size());
        vek.add("dfafa");
        System.out.println(vek.size());
        
        
        vek.add("hahaha");
        vek.add("jjjjjj");
        vek.add("dafadfdafad");
        vek.add(1,"dfadfd");
        vek.addFirst("Awal");
        vek.adqqqqqqqqqqqqqqqdLast("Akhir");
        
        
        for (int i=0;i<vek.size();i++){
            System.out.println(vek.get(i));
            
        }
    }
    
}
