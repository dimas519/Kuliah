/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.LinkedList; 
import java.util.Queue;


public class MazeBFS_DFS {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int vertex=sc.nextInt();
//        int  edges=sc.nextInt();
        

        
//        for (int i=0;i<edges;i++){
//            int a=sc.nextInt();
//            int b=sc.nextInt();
            
         bfs bfs =new bfs(12);
        
        bfs.setArr(0,1);
        bfs.setArr(1,2);
        bfs.setArr(1,4);
        
        bfs.setArr(2,3);
        bfs.setArr(2,5);
        bfs.setArr(2,7);
        bfs.setArr(2,8);
        
        
        bfs.setArr(3,4);
        bfs.setArr(3,9);
        bfs.setArr(3,10);
        
        bfs.setArr(5,6);
        bfs.setArr(5,7);
        bfs.setArr(5,8);
        
        bfs.setArr(7,8);
            
//        }
        
        
        
        int start=0;
        
        bfs.queue.add(start);
        bfs.check[start]=true;
        
        //1,2,4,5,7,8,3,6,9,10
        
        
        while (bfs.queue.size()>0 || bfs.getchecker())  {
            
            bfs.proses();
            
        }
        
        
    }
    
}



class bfs{
    MyLinkedList queue=new MyLinkedList();
   int vertex;
   int arr[][];
   boolean check[];
   
   public bfs(int vertex){
       this.vertex=vertex;
       arr=new int [vertex][vertex];
       check=new boolean [vertex];
       check[0]=true;
   }
    
   
   public void setArr(int a,int b){
       arr[a][b]=1;
       arr[b][a]=1;
   }
   
   
   
   public void proses(){
       
       if (queue.size()>0){
       int pos =queue.remove();
       System.out.print(pos);
       
       
       for (int i=1;i < vertex;i++){
           if(arr[pos][i]==1 && check[i]==false){
               queue.add(i);
               check[i]=true;
           }
       }
       }
       
   }

   
   public boolean getchecker(){
    for (boolean temp: check ){
        if(temp){
            
        } else {
            return true;
        }
    }
    
    return false;
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
    
    
    
     public void add (int info){

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
     
     
     
     
         public int remove(){
        if(head==null){
           return -3;
        } else {
            count--;
            Mynode removeNode= head;
            head=head.getNext();
            return removeNode.getInfo();
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