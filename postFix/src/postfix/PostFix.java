/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfix;

/**
 *
 * @author Dimas Kurniawan
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class PostFix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack <Character> antri=new Stack<>();
        String input="(((3+2)^2)+((3-4)/3))";
        
        int panjang=input.length();
        
        
        for(int i=0;i<panjang;i++){
            char idx=input.charAt(i);
            if(operasi(idx)){
                antri.add(idx);
 
            }else if (idx==')') {
                System.out.print(antri.pop());
            } else if( idx=='('){
                
            } else {
                System.out.print(idx);
            }
            
            
            
            
        }
        
//        System.out.println(antri.pop());
        
        
    }
    
    
    public static boolean operasi(char a){
        if(a=='-' || a=='*' || a=='+'|| a=='/' || a=='^'){
            return true;
        }else {
            return false;
        }
       
        
        
    }
    
}


