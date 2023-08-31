/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package mengetik;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class Mengetik {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        
        
        while (sc.hasNextLine()){
            String input=sc.nextLine();
          //untuk yg normal
        MyLinkedList ll1=new MyLinkedList();  //untuk yg first dan terbalik
        MyLinkedList ll2=new MyLinkedList();
       
        int panjang=input.length();
 
        
        
        String potong="";
        int i=0;
        while(i<panjang && input.charAt(i)!=']' && input.charAt(i)!='['){
        i++;
        }
        potong=input.substring(0,i);
        ll2.addLast(potong);   // untuk menambahkan dahulu sbelum masuk
        potong="";

        while (i<panjang){
            int temp=0; 

           if(input.charAt(i)=='['){
                i++;
                temp=i;
                while(i<panjang && input.charAt(i)!=']' && input.charAt(i)!='['){
                    i++;
                 }
                potong=input.substring(temp,i);
                i--;
               ll1.addFirst(potong);
            } else if(input.charAt(i)==']'){
               i++;
               temp=i;
                 while(i<panjang && input.charAt(i)!=']' && input.charAt(i)!='['){
                    i++;
                 }
                 potong=input.substring(temp,i);
                 i--;
                ll2.addLast(potong);
            }
           
            
            
            
            
            
            
    i++;
            
            }

        ll1.printAllInfo();
         ll2.printAllInfo();
         System.out.println();
        }
        
    }
}
class Mynode{
    private Object info;
    private Mynode next;
    public void setNext(Mynode next){
    this. next=next;
     }
    public Mynode getNext(){
    return next;
    }
    public Object getInfo(){
    return info;
    }
    public void setlnfo(Object info){
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
    public void addFirst(Object info){
         Mynode newNode=new Mynode(info) ;
         if (head==null){
             head=newNode;
         } else {
             newNode.setNext(head);
            head = newNode;
             
             
         }
     }
    public void addLast (Object info){

    Mynode newNode=new Mynode(info) ;
    
    if(head==null){
        head=newNode;
    }
    else {
        Mynode cur=head;
        while (cur.getNext() !=null){
        cur=cur.getNext() ;
        }
    cur.setNext (newNode) ;
    }
    count=count+1;
}
    public void printAllInfo(){
        Mynode cur=head;
        while (cur!=null){
            System.out.print(cur.getInfo().toString()+"");
            cur=cur.getNext();
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
    
}
    