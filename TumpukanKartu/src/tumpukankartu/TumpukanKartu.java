/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package tumpukankartu;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class TumpukanKartu {
    public static void main(String[] args) {
        MyLinkedList stack=new MyLinkedList();
        Scanner sc =new Scanner (System.in);
        int banyak=sc.nextInt();
        for(int i=0;i<banyak;i++){
            String perintah=sc.next();
            if(perintah.equalsIgnoreCase("Tumpuk")){
                String objek=sc.next();
                stack.push(objek);
            } else if(perintah.equalsIgnoreCase("Buang")){
                stack.pop();
            } else if (perintah.equalsIgnoreCase("Lihat")){
                Object intip=stack.peek();
                System.out.println(intip);
            }
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
 
public Object peek(){
    Mynode Node= head;
    return Node.getInfo();  
}
}