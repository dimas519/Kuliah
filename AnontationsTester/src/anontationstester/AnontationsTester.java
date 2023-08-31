/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anontationstester;

/**
 *
 * @author Dimas
 */
import java.lang.annotation.*;
public class AnontationsTester {
    public static void main(){
    /**
     * @param args the command line arguments
     */
   

        
    }
        
        
        
        
    
    public interface satu {
   
   void print();
   @Deprecated
   void printsatu();

        
        
    }
    
    
    
    public class dua implements satu{
    
    
    
    @Override
    @SuppressWarnings("deprecation")
    public void printsatu(){
        
    }
       
    
    @Override
    @SuppressWarnings("deprecation")
    public void print(){
        System.out.println("Satu");
    }
    
} 
    
    
   
    
    
    
    
}

