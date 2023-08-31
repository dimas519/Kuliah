/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a39;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        BinarySearchTree bst=new BinarySearchTree();
        for(int i=0;i<banyak;i++){
            bst.insert(sc.nextInt());
        }
        
    }
    
}



class BinarySearchTree <T extends Comparable<T>>{
    private Node root;  //yang menyimpan dimana letak root atau paling atasnya
    public int InsertCounter=0;
    private class Node{ //innerclass untuk tipe data yang seakan linkedlist dengan 3 buah yaitu alamat anak kiri, anak kanan, orang tuanya dan nilai dia sendiri
        T info; // yang menyimpan nilai dari sebuah blocknya
        Node left,right, parent;  //digunakan untuk menyimpan ke alamat lainnya
        
        Node(T info){ //class konstruktor untuk menyimpan nilai dia sendiri
            this.info=info;
        }
        
    }
    
    public void insert (T data){ //methods yang akan digunakan untuk masukan sebuah T (generics) ke dalam pohon
        Node newNode = new Node (data); //membuat 1 buah kotak yang berisikan 3 alamat dan 1 info
        Node curr=this.root; //sebagai temp untuk tau dimana rootnya
        Node parent=null; //awalnya set parent sebagai null karena belum tahu apakah ada parentnya atau dia rootnya
        
        if(this.root==null){ //jika masih awal( belum ada yg masuk maka
            this.root=newNode; //masukan yang input sebagai awalnya
            System.out.println(InsertCounter);
        }else{ // jika sudah ada yang masuk sebelumnya maka
            while(curr!=null){  // loop terus menerus sampai ke leaf
                parent=curr; // set parent sebagai curr sebelum kita next
                if(data.compareTo(curr.info)<0){ // digunakan untuk mengarahkan posisi kekanan atau kiri sesuai dengan input apakah besar atau kecil
                    curr=curr.left; //arah kan kekiri kalau lebih kecil
                }else{
                    curr=curr.right; // jika lebih besar maka arah kan kekanan
                }
                InsertCounter++; //tambahkan 1 setiap meloop kemana dia harus pergi 
            }
            System.out.println(InsertCounter);
            newNode.parent=parent; //digunakan untuk sesaat sebelum memasukan data( yg tadi untuk loop sampai leaf)
                    if(data.compareTo(parent.info)<0){ // untuk bandingkan apakah taruh dikanan atau dikiri
                        parent.left=newNode; // jika lebih kecil maka taruh di kiri
                    }else {
                        parent.right=newNode; // jika lebih besar maka taruh dikanan
                    }
                    
        }

    }
    

}