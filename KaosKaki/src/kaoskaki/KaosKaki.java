/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaoskaki;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class KaosKaki {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        MyLinkedList asal=new MyLinkedList();
        MyLinkedList sementara=new MyLinkedList();
        int banyak=sc.nextInt();
        int i=0;
        while (i<banyak){
            int satu=sc.nextInt();
            int dua=sc.nextInt();
            
            asal.push(satu);
            sementara.push(dua);     
            
            i++;
        }
        
        int count=0;
              
        i=0;
        while (i<banyak){
            int satu=asal.pop();
            int dua=sementara.pop();
            
            if(satu==dua){
                count++;
            }
        i++;            
        }
        
        System.out.println(count*2);
        
    }
    
}


class Mynode{
    private int info;
    private Mynode next;
    
    public void setNext(Mynode next){   // untuk alamat selanjutnya
    this. next=next;
     }
    public Mynode getNext(){   // petunjuk alamat  berikutnya
    return next;
    }
    public int getInfo(){ // untuk mengeluarkan nilai alamat
    return info;
    }
    public void setinfo(int info){  //untuk menerima info
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
    
public void push(int info){  // mengunakan add first namun dipersingkat menjadi add saja || mengunakan add first karena tidak perlu loop mencari akhirnya dimana
         Mynode newNode=new Mynode(info) ;
         if (head==null){
             head=newNode;
         } else {
             newNode.setNext(head);  // sambungin dahulu yg baru ke alaamat lama
            head = newNode;
             
             
         }
     }

 public int pop(){ // mengukanan remove first karena tidak perlu loop dan menyesuaikan dengan stack dimana yg masuk terkahir keluar duluan
        if(head==null){
           return '0';
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
}