/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.c29;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAC29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}

class BinarySearchTree <T extends Comparable<T>>{
    private Node root;  //yang menyimpan dimana letak root atau paling atasnya
    private class Node{ //innerclass untuk tipe data yang seakan linkedlist dengan 3 buah yaitu alamat anak kiri, anak kanan, orang tuanya dan nilai dia sendiri
        T info; // yang menyimpan nilai dari sebuah blocknya
        Node left,right, parent;  //digunakan untuk menyimpan ke alamat lainnya
        
        Node(T info){ //class konstruktor untuk menyimpan nilai dia sendiri
            this.info=info;
        }
        
        public String toString(){ //overloading yang digunakan untuk output print
            return "["+this.info.toString()+"]";
        }
    }
    
    public void insert (T data){ //methods yang akan digunakan untuk masukan sebuah T (generics) ke dalam pohon
        Node newNode = new Node (data); //membuat 1 buah kotak yang berisikan 3 alamat dan 1 info
        Node curr=this.root; //sebagai temp untuk tau dimana rootnya
        Node parent=null; //awalnya set parent sebagai null karena belum tahu apakah ada parentnya atau dia rootnya
        
        if(this.root==null){ //jika masih awal( belum ada yg masuk maka
            this.root=newNode; //masukan yang input sebagai awalnya
        }else{ // jika sudah ada yang masuk sebelumnya maka
            while(curr!=null){  // loop terus menerus sampai ke leaf
                parent=curr; // set parent sebagai curr sebelum kita next
                if(data.compareTo(curr.info)<0){ // digunakan untuk mengarahkan posisi kekanan atau kiri sesuai dengan input apakah besar atau kecil
                    curr=curr.left; //arah kan kekiri kalau lebih kecil
                }else{
                    curr=curr.right; // jika lebih besar maka arah kan kekanan
                }
            }
            
            newNode.parent=parent; //digunakan untuk sesaat sebelum memasukan data( yg tadi untuk loop sampai leaf)
                    if(data.compareTo(parent.info)<0){ // untuk bandingkan apakah taruh dikanan atau dikiri
                        parent.left=newNode; // jika lebih kecil maka taruh di kiri
                    }else {
                        parent.right=newNode; // jika lebih besar maka taruh dikanan
                    }
                    
        }

    }
    

