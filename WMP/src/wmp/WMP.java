/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package wmp;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;

public class WMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        
        MyLinkedList ll=new MyLinkedList();
        
         int angka=sc.nextInt();
        while(angka!=0){

        ll.addLast(angka);
        angka=sc.nextInt();
        }
        
        ll.insertion();
     
        int i=0;
        int panjang=ll.size();
        for(i=0;i<panjang;i++){
            if(i!=0){
                System.out.print(" ");
            }
            System.out.print(ll.get(i));

        }
        System.out.println();
        
    } 
    }
    




class Mynode{
    private int info;
    private Mynode next;
    public void setNext(Mynode next){
    this. next=next;
     }
    public Mynode getNext(){
    return next;
    }
    public int getInfo(){
    return info;
    }
    public void setInfo(int info){
    this. info=info;
    }
    public Mynode(int info){
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
    
public int get(int x){
        Mynode cur=head;
        int i=0;
        while (i<x){
            cur=cur.getNext();
            i++;
        } 

        return(cur.getInfo());
        
    }

public void addLast (int info){

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
 
public int size (){  //ukuran 
    Mynode cur=head;
    int i=0;
        while (cur !=null){
            i++;
            cur=cur.getNext();
        }
        return i;
}
    
 public Mynode getAlamat(int x){
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