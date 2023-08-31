/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//package loketbioskop;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class LoketBioskop {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        MyLinkedList queue =new MyLinkedList();
        
        String input =sc.nextLine();
        int antrian=0;
        int dilayani=1;
        
       while (input.equals("tutup")==false  && input.equals("loket tutup")==false  ) {
            if (input.equals("selesai")){
                queue.pop();
                if (queue.isEmpty()){
                    System.out.println("loket kosong");
                } else {
                     System.out.printf("nomor antrian %d silakan ke loket\n",dilayani);
                     dilayani++;
                }
            } else {
                       antrian++;
                 if (queue.isEmpty()){
                     System.out.printf("nomor antrian %d silakan ke loket\n",dilayani);
                     dilayani++;
                 } else { 
                     System.out.printf("nomor antrian %d silakan mengantri\n",antrian); 
                 }
                 queue.push(input);
            
            }
            input =sc.nextLine();
        } 
       queue.pop();
        if (queue.isEmpty()){
                System.out.println("kami selesai melayani hari ini");
                
        } else {
            System.out.println("nomor antrian berikut silakan datang kembali besok");
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
    
    
    
    
    public void push (Object info){

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
    
    public Object pop(){
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
    
    
    public boolean isEmpty(){
        if (head==null){
            return true;
        } else {
            return false;
        }
    }
    

}