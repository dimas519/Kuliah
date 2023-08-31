/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacklltester;

/**
 *
 * @author Dimas
 */
public class StackLLTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList stack =new MyLinkedList();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
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
    private int count;
    
    public MyLinkedList(){
        head=null;
        count=0;
    }
    
public void push(Object info){  // mengunakan add first namun dipersingkat menjadi add saja || mengunakan add first karena tidak perlu loop mencari akhirnya dimana
         Mynode newNode=new Mynode(info) ;
         if (head==null){
             head=newNode;
         } else {
             newNode.setNext(head);  // sambungin dahulu yg baru ke alaamat lama
            head = newNode;
             
             
         }
     }

 public Object pop(){ // mengukanan remove first karena tidak perlu loop dan menyesuaikan dengan stack dimana yg masuk terkahir keluar duluan
        if(head==null){
           return null;
        } else {
            count--;
            Mynode removeNode= head;
            head=head.getNext();
            return removeNode.getInfo();
        }
    }
 
 public boolean isEmpty(){  // dapat juga menggunakan size( di tester di cek apakah size==0
     if(head==null){
         return true;
     } else {
         return false;
     }
 }
public int size (){  //ukuran 
    Mynode cur=head;
    int i=0;
        while (cur !=null){
            i++;
            cur=cur.getNext();
        }
        return i;
}




}