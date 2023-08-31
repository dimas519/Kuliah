/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adtlist;

/**
 *
 * @author Dimas
 */
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
    
     public void addLast (Object info){

         Mynode newNode=new Mynode(info) ;
    
            if(head==null){
                head=newNode;
            } else {
            Mynode cur=head;   // seperti index 
            while (cur.getNext() !=null){
            cur=cur.getNext() ;
            }
        cur.setNext (newNode) ;
    }
        count=count+1;
}
     
     
     public void addFirst(Object info){
         Mynode newNode=new Mynode(info) ;
         if (head==null){
             head=newNode;
         } else {
             newNode.setNext(head);  // sambungin dahulu yg baru ke alaamat lama
            head = newNode;
             
             
         }
     }

     
     public void addAfter(Mynode prevNode, Object info){
         Mynode newNode=new Mynode(info);
         
         newNode.setNext(prevNode.getNext());
         prevNode.setNext(newNode);
         
     }
     
     
     
     
     
    public void printAllInfo(){
        Mynode cur=head;
        while (cur!=null){
            System.out.print(cur.getInfo().toString()+"");
            cur=cur.getNext();
        }
        
    }
    
    public Object removeFirst(){
        if(head==null){
           return null;
        } else {
            count--;
            Mynode removeNode= head;
            head=head.getNext();
            return removeNode.getInfo();
        }
    }
    
    
    
    
    
    
  
    
    
    
    
    
    
    
    public Object removeLast(){
          if(head==null){
            return null;
        }
        else{
            count--;
            Mynode removedNode = head;
            for(int i=0;i<count-1;i++){
                removedNode=removedNode.getNext();
            }
            removedNode.setNext(null);
            return removedNode.getInfo();
          }
    }
    public Object get(int x){   // untuk mendapatkan nilai ke -x
        Mynode cur=head;
        int i=0;
        while (i<x){
            cur=cur.getNext();
            i++;
        } 

        return(cur.getInfo());
        
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
    
    
    public Mynode getAlamat(int x){  // untuk mendapatkan alamat ke-x
        Mynode cur=head;
        int i=0;
        while (i<x){
            cur=cur.getNext();
                    i++;
        }
        return(cur);
        
    }
        
        
        
    public void insertion (){
     
     int temp=0;
     int panjang=size();
     
     int i=1;
     while (i<panjang){
         
         int u=i;
         int kiri=get(u-1);
         int kanan=get(u);
         temp=0;
        while (u>0 &&kiri < kanan ){
            temp=kiri;
            kiri=kanan;
            kanan=temp;
            
            
            Mynode nKiri=getAlamat(u-1);
            Mynode nKanan=getAlamat(u);
            
            nKiri.setInfo(kiri);
            nKanan.setInfo(kanan);
            u--;
            kiri=get(u-1);
            kanan=get(u);
            
            
        }
        i++;

     }

 }
    
    
    
    
    
    
    
}


public class Tester {
    public static void main (String args[]){
    MyLinkedList ll=new MyLinkedList();
    ll.addLast(new Integer(5));
    ll.addLast(new Integer(6));
    ll.addLast(new Integer(10));
    ll.removeLast();
    ll.addFirst(new Integer(1));
    
   
        System.out.println(ll.removeFirst());
    ll.printAllInfo();
    }
}
