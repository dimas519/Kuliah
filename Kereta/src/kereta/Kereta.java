/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kereta;

/**
 *
 * @author Dimas
 */

import java.util.Scanner;
public class Kereta {

    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        long gerbong1=sc.nextLong();
        long i=0;
        MyLinkedList kelas1 =new MyLinkedList();
        MyLinkedList penumpang1 =new MyLinkedList();
        MyLinkedList kelas2 =new MyLinkedList();
        MyLinkedList penumpang2 =new MyLinkedList();
        
        MyLinkedList kelasGabung =new MyLinkedList();
        MyLinkedList penumpangGabung =new MyLinkedList();
        
        
        for (i=0;i<gerbong1;i++){

            kelas1.add(sc.nextLong());
            penumpang1.add(sc.nextLong());
        }
            
        long gerbong2=sc.nextLong();
        for (i=0;i<gerbong2;i++){
            
            kelas2.add(sc.nextLong());
            penumpang2.add(sc.nextLong());
        }    
            
      long idx1=0;
      long idx2=0;
    
     
   while (idx1<gerbong1  || idx2< gerbong2){
       
       
       if(idx2==gerbong2 || kelas1.get(idx1) > kelas2.get(idx2)){
//           System.out.println("satu");
           System.out.print(kelas1.get(idx1));
           System.out.print(" ");
           System.out.println(penumpang1.get(idx1));
           idx1++;         
       } else if(idx1==gerbong1 || kelas1.get(idx1) < kelas2.get(idx2)){
//           System.out.println("dua");
           System.out.print(kelas2.get(idx2));
           System.out.print(" ");
           System.out.println(penumpang2.get(idx2));
           idx2++;         
       } else if(kelas1.get(idx1) == kelas2.get(idx2)){
//           System.out.println("tiga");
           System.out.print(kelas2.get(idx2));
           System.out.print(" ");
           long hasil=penumpang2.get(idx2)+penumpang1.get(idx1);
           System.out.println(hasil);
           idx2++;
           idx1++;
       }
  
   }
     
     
      
      
      
      
      
      
    }
    
}

class Mynode{
    private long info;
    private Mynode next;
    public void setNext(Mynode next){
    this. next=next;
     }
    public Mynode getNext(){
    return next;
    }
    public long getInfo(){
    return info;
    }
    public void setInfo(long info){
    this. info=info;
    }
    public Mynode(long info){
    this. info=info;
    this. next=null;
    }
}

class MyLinkedList {
    
    private Mynode head;
    private long count;
    
    public MyLinkedList(){
        head=null;
        count=0;
    }
    

public void add (long info){

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

public long get(long x){
        Mynode cur=head;
        long i=0;
        while (i<x){
            cur=cur.getNext();
            i++;
        } 

        return(cur.getInfo());
        
    }
public long size (){  //ukuran 
    Mynode cur=head;
    long i=0;
        while (cur !=null){
            i++;
            cur=cur.getNext();
        }
        return i;
}


}