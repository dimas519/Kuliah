/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueue;

/**
 *
 * @author Dimas
 */
public class PriorityQueueTester{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue queue =new PriorityQueue(5);
        System.out.println("kosong "+queue.isEmpty());
        
        queue.push(5);
        queue.push(7);
        queue.push(0);
        queue.push(1);
        queue.push(52);
        
        System.out.println("kosong "+queue.isEmpty());
        
        
        
        for (int i=0;i<5;i++){
            System.out.println(queue.pop());
        }
        System.out.println("kosong "+queue.isEmpty());
        
        
    }
    
}


class PriorityQueue{
    
    protected Object[] arrObject;
    protected int head;

public PriorityQueue(int size){
    arrObject=new Object[size];
    head=-1;
}
public boolean isEmpty(){
     if (head==-1){
         return true;
     } else {
         return false;
     }   
}
public Object pop(){
     if(isEmpty()==false){
         Object  result=arrObject[head];
         arrObject[head]=null;
         head--;
         return result;
     }
     else{
         return null;
     }
 }
public boolean push(Object obj){
    if(head==arrObject.length-1){
        return false;
    } else {
        Comparable as=(Comparable)obj;
        int i=head;
        while ( (i>=0)&& (as.compareTo(arrObject[i])>0)){
            arrObject[i+1]=arrObject[i];
            i--;
        }
        arrObject[i+1]=obj;
        this.head=this.head+1;
        return true;
    }
}
 public Object peek(){
     if(isEmpty()==false){
         return arrObject[head];
     } else {
         return null;
     }
 }

 public int size(){
     return head++;
 }

}