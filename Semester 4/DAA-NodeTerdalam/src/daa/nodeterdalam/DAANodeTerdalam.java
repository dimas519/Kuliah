/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.nodeterdalam;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

public class DAANodeTerdalam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int jumlah=sc.nextInt();
        String arr[]=new String[jumlah];
        BinarySearchTree<String> bst=new BinarySearchTree<String>(); //menggunakan string karena input soal berupa string 
       
        for(int i=0;i<jumlah;i++){ //digunakan untuk untu menyesuaikan dengan format input yang diberikan soal
            String kata=sc.next();
            arr[i]=kata;
            bst.insert(kata);
        }
        
        int hitung[]=bst.counter(arr, jumlah); //aray untuk mendapatkan berapa masing masing posisi levelnya
        
        int max=0; //cari level terdalam tentunya level plaing sedikit itu 0
        for(int x:hitung){ //loop terus cari siapa yang paling besar
            if(x>max){
                max=x;
            }
        }
        System.out.println(max); //print max menyesuaikan dengan format soal yang diminta
         LinkedList<String> keluaran = new LinkedList<String>(); //gunakan linked list karena belum tahu ada berapa bnyak
        
        for(int i=0;i<jumlah;i++){ //for untuk memasukan linklist kata dengan index terbanyak ditambahkan kurung buka dan kurung tutup sesuai dengan permintaan soal
            if(hitung[i]==max){
               keluaran.add("["+arr[i]+"]");
            }
        }
        
        Collections.sort(keluaran); //urutkan output sesuai dengan permintaan soal
        while (keluaran.size()!=0){ //kemudian keluarkan semua yang tadi dimasukan ke linkedList
            System.out.print(keluaran.pop());
        }
        System.out.println("");//terakhir print line kosong
        
    }
    
}


class BinarySearchTree <T extends Comparable<T>>{
    private Node root;
    private class Node{
        T info;
        Node left,right, parent;
        
        Node(T info){
            this.info=info;
        }
        
        public String toString(){
            return "["+this.info.toString()+"]";
        }
    }
    
    public void insert (T data){
        Node newNode = new Node (data);
        Node curr=this.root;
        Node parent=null;
        
        if(this.root==null){
            this.root=newNode;
        }else{
            while(curr!=null){
                parent=curr;
                if(data.compareTo(curr.info)<0){
                    curr=curr.left;
                }else{
                    curr=curr.right;
                }
            }
            newNode.parent=parent;
                    if(data.compareTo(parent.info)<0){
                        parent.left=newNode;
                    }else {
                        parent.right=newNode;
                    } 
        }
    }
    
        public Node search (T data) {
        Node result=search(data, this.root);
        return result;
    }
    
    private Node search(T data, Node curr){
        if(curr==null){
            return null;
        }else if(curr.info.compareTo(data)==0){
            return curr;
        }else if(curr.info.compareTo(data)<0){
            return search(data,curr.right);
        }else{
            return search(data,curr.left);
        }
    }
    
    public int[] counter (T[] arr,int jumlah){ //methods yang digunakan untuk menghitung satu persatu ada dilevel brp
        int []hitung=new int[jumlah]; //array untuk menyimpan index ke 1 itu dilevel brp
        for(int i=0;i<jumlah;i++){ //loop mulai dari index ke1
            T kata=arr[i];
            Node cur=search(kata);//cari ada dinode ke brp
            int x=0; //digunakan untuk counter mulai dari index ke 0
            while (cur!=null){ //loop ke atas terus untuk menghitung ada berapa orang tuanya sampai null
                cur=cur.parent; //loop terus keatas(ke parentnya)
                x++; //tambahkan 1 jika ada orang tuanya
            }
            hitung[i]=x;//simpan satu persatu berapa levelnya sesuai dengan indexingnya
        }
        
        return hitung;
    }
}