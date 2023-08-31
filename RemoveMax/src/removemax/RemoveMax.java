/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package removemax;

/**
 *
 * @author USER
 */
import java.util.Stack;
import java.util.Scanner;
public class RemoveMax { // tester
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyFirstADT adt=new MyFirstADT();
        int input=sc.nextInt();
        while (input!=0){
           if (input==-1){
               adt.removeMax();
           }else {
               adt.push(input);
           }
            input=sc.nextInt();
        }
        
    }
    
}


class MyFirstADT{
        Stack<Integer> stackHasil=new Stack<Integer>();
       Stack<Integer> stackTemp=new Stack<Integer>();
       
       
    public void push(int a){
        if(stackHasil.empty()){
            stackHasil.push(a);
//            System.out.println("stack kosong");
        } else {
            if(stackHasil.peek() > a){
//                System.out.println("debug"+stackHasil.peek());
                stackHasil.push(a);
            } else {
                
                
            int size=stackHasil.size();
            
          while (size >0 && stackHasil.peek() < a ){
              int pindah =stackHasil.pop();
              stackTemp.push(pindah);
              size--;
          } 
           stackHasil.push(a);
           
           size=stackTemp.size();
          
            while (size >0){
                int pindah =stackTemp.pop();
                stackHasil.push(pindah);
                size--;
            }
            
            
            
            }
        }
    }
    
    
    void removeMax(){
        
        if(stackHasil.size()==0){
            System.out.println("null");
        }else {
        
        
        
        int size=stackHasil.size();
        
        
        
        while (size>0){
        int pindah=stackHasil.pop();
        stackTemp.push(pindah);
        size--;
    }
        
        System.out.println(stackTemp.pop());
        
        size=stackTemp.size();
            
            
            while (size>0){
            int pindah=stackTemp.pop();          
            stackHasil.push(pindah);        
            size--;
            }
            
            
            
            
            
            
       
        }
        
}
    }
    
    
    
    
    
