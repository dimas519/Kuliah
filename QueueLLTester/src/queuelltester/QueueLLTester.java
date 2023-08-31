/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuelltester;

/**
 *
 * @author Dimas
 */
public class QueueLLTester {

    
    public static void main(String[] args) {
        MyLinkedList queue =new MyLinkedList();
        
        int i=0;
        
        for (i=0;i<5;i++){
            queue.addLast(i);
        }
        
        for (i=0;i<5;i++){
            System.out.println(queue.removeFirst());
        }
        
        
    }
    
}


class Mynode{
    private Object info;
    private Mynode next;
    
    public void setNext(Mynode next){   // untuk alamat selanjutnya
    this. next=next;
     }
    public Mynode getNext(){   // petunjuk alamat  berikutnya
    return next;
    }
    public Object getInfo(){ // untuk mengeluarkan nilai alamat
    return info;
    }
    public void setinfo(Object info){  //untuk menerima info
    this. info=info;
    }
    public Mynode(Object info){
    this. info=info;
    this. next=null;
    } 
}




class MyLinkedList {
    
    private Mynode head;
    private Mynode tail;
    private int count;
    
    public MyLinkedList(){
        head=null;
        count=0;
    }
    
    
    
    
    public void addLast (Object info){

         Mynode newNode=new Mynode(info) ;
    
            if(head==null){
                head=newNode;
                tail=newNode;
            } else {
            tail.setNext(newNode);
            tail=newNode;
    }
        count=count+1;
}
    
    public Object removeFirst(){
        if(head==null){
           return null;
        } else {
            count--;
            Mynode removeNode= head;
            head=head.getNext();
            if(head==null){
                tail=null;
            }
            return removeNode.getInfo();
        }
    }

}