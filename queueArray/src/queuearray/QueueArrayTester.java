/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuearray;

/**
 *
 * @author Dimas
 */
public class QueueArrayTester {

    public static void main(String[] args) {
        QueueArray queue=new QueueArray(5);
        
        int i=0;
        
        
        
        System.out.println(queue.push(10));
        System.out.println(queue.pop());
        System.out.println(queue.push(20));
        System.out.println(queue.push(30));
        System.out.println(queue.push(40));
        System.out.println(queue.push(50));
        System.out.println(queue.push(60));
         System.out.println(queue.push(70));
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        
        
    }
    
}


class QueueArray{
    protected Object[] arrObject;
    protected int tail;
    protected int head;
    protected int size;

public QueueArray(int size){
    arrObject=new Object[size];
    tail=0;
    head=0;
    this.size=size;
    
}
 public boolean isEmpty(){
     if (tail==0){
         return true;
     } else {
         return false;
     }   
}
 public boolean push(Object newObj){
     if(arrObject[tail]==null){
     arrObject[tail]=newObj;
     tail++;
     if(tail==size){
         tail=0;
     }
     return true;      
    } else {
         return false;
     }
 }
 
 public Object pop(){
     if(arrObject[head]!=null){
         Object result=arrObject[head];
        arrObject[head]=null;
         head++;
        
         
         if(head==size){
             head=0;
         }
         return result;
     }
     else{
         return null;
     }
 }
 
 
 public Object peek(){
     if(isEmpty()==false){
         return arrObject[0];
     } else {
         return null;
     }
 }
 
 
 public int size(){
     return tail;
 }
 
 
 
 
 
 
 
}
