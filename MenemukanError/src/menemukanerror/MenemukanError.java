/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menemukanerror;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class MenemukanError {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        MyLinkedList stack = new MyLinkedList();
        int i=0;
        int logic=0;
                String masukan=sc.next();
                int panjang=masukan.length();
                
                while (i<panjang){
                char tanda=masukan.charAt(i);
                
                if(tanda=='[' || tanda=='('|| tanda=='{'){
                    stack.push(tanda);
                } else if (tanda==']' || tanda==')' || tanda=='}'){
                    char keluar=stack.pop();
                    if(tanda==']'&& keluar !='['){
                        System.out.print(tanda);
                        System.out.println(" "+i);
                        logic=1;
                        break;
                    } else if (tanda==')'  && keluar!='('  ) {
                        System.out.print(tanda);
                        System.out.println(" "+i);
                        logic=1;
                        break;
                    } else if (tanda=='}' && keluar !='{'){
                        System.out.print(tanda);
                        System.out.println(" "+i);
                        logic=1;
                        break;
                    }
                    
                }
                i++;
                }          
                     if (logic==0){
                    System.out.println("tidak ada kesalahan delimiter");
                }
        
    }
    
}


class Mynode{
    private char info;
    private Mynode next;
    
    public void setNext(Mynode next){   // untuk alamat selanjutnya
    this. next=next;
     }
    public Mynode getNext(){   // petunjuk alamat  berikutnya
    return next;
    }
    public char getInfo(){ // untuk mengeluarkan nilai alamat
    return info;
    }
    public void setinfo(char info){  //untuk menerima info
    this. info=info;
    }
    public Mynode(char info){
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
    
public void push(char info){  // mengunakan add first namun dipersingkat menjadi add saja || mengunakan add first karena tidak perlu loop mencari akhirnya dimana
         Mynode newNode=new Mynode(info) ;
         if (head==null){
             head=newNode;
         } else {
             newNode.setNext(head);  // sambungin dahulu yg baru ke alaamat lama
            head = newNode;
             
             
         }
     }

 public char pop(){ // mengukanan remove first karena tidak perlu loop dan menyesuaikan dengan stack dimana yg masuk terkahir keluar duluan
        if(head==null){
           return '0';
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