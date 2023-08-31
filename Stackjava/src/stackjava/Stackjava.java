/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackjava;

/**
 *
 * @author Dimas
 */
import java.util.Stack; 
public class Stackjava {
    public static void main(String[] args) {
       Stack<Integer> stack=new Stack<Integer>();
       Stack<Integer> stack2=new Stack<Integer>();


       stack.push(10);
       stack.push(20);
       stack.push(30);
       stack.push(40);
       
       stack2.push(20);
       stack2.push(20);
       stack2.push(40);
       stack2.push(40);
       
       
       
        System.out.println(stack.size());
       
       
       
//       for (int i=0;i<4;i++){
//       if((stack.peek()).equals(stack2.peek())){
//           System.out.println("true");
//        } else {
//           System.out.println("false");
//        }
//       System.out.println(stack.pop());
//       System.out.println(stack2.pop());
//       
//       
//       }
       
       
    }
    
}
