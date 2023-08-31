/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraystack;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
class ArraysStack {
        private int[] elements;
        private int top;
        
        public void ArraysStack(int maxCapacity){
            this.elements=new int[maxCapacity];
        }
        
        public boolean push(int newElement){
            if(this.top<elements.length){
                this.elements[top]=newElement;
                top++;
                return true;
            } else {
                return false;
            }
        }
        
        public int pop(){
            int pop=0;
            if(this.top>0){
                pop=this.elements[top-1];
                top--;
            }
                return pop;
        }
    
        public boolean isEmpty(){
            if(this.top==0){
                return true;
            } else {
                return false;
            }
            
        }
    
}


public class ArraysStackTester{
    public static void main (String[] args){
        Scanner sc =new Scanner (System.in);
        ArraysStack stack=new  ArraysStack();
        stack.ArraysStack(10); // ukuran 10
        
        boolean kosong=stack.isEmpty();
        System.out.println("kosong :" +kosong);
        int i=0;
        for (i=0;i<11;i++){
            int angka=sc.nextInt();
            
            boolean masuk=stack.push(angka);
            
            System.out.println(masuk);

        }
        
        

        for (i=i;i>-5;i--){
            int angka=(int)stack.pop();
            
            System.out.println(angka);

        }
        
        
        
        
        
        
    }
}
