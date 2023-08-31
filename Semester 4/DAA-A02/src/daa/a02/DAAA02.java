/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a02;


/**
 *
 * @author Dimas Kurniawan
 */
import java.util.LinkedList;
import java.util.Scanner;
public class DAAA02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> node = new LinkedList<Integer>();
        
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst=new BinarySearchTree();
        int p=0;
        while (p<19){
            bst.insert(sc.nextInt());
            p++;
        }
        int ukuran=node.size();
        int arr[]=new int[ukuran];
        for(int i=0;i<ukuran;i++){
            arr[i]=node.pollFirst();
        }
        
        
        System.out.println(bst.max);
    }
    
}


class BinarySearchTree <T extends Comparable<T>>{
    private Node root;
    public int max=Integer.MIN_VALUE;

    private class Node{ //innerclass untuk tipe data yang seakan linkedlist dengan 3 buah yaitu alamat anak kiri, anak kanan, orang tuanya dan nilai dia sendiri
        int info; // yang menyimpan nilai dari sebuah blocknya
        Node left,right, parent;  //digunakan untuk menyimpan ke alamat lainnya
        
        Node(int info){ //class konstruktor untuk menyimpan nilai dia sendiri
            this.info=info;
        }
    }
    
    Node curr=this.root; //sebagai temp untuk tau dimana rootnya
    
    
    
     public void insert (int data){ //methods yang akan digunakan untuk masukan sebuah T (generics) ke dalam pohon
        Node newNode = new Node (data); //membuat 1 buah kotak yang berisikan 3 alamat dan 1 info
        
        Node parent=null; //awalnya set parent sebagai null karena belum tahu apakah ada parentnya atau dia rootnya
        
        if(this.root==null){ //jika masih awal( belum ada yg masuk maka
            this.root=newNode; //masukan yang input sebagai awalnya
        }else{ // jika sudah ada yang masuk sebelumnya maka
            while(curr!=null){  // loop terus menerus sampai ke leaf
                parent=curr; // set parent sebagai curr sebelum kita next
                if(data<0){ // digunakan untuk mengarahkan posisi kekanan atau kiri sesuai dengan input apakah besar atau kecil
                    curr=curr.left; //arah kan kekiri kalau lebih kecil
                }else{
                    curr=curr.right; // jika lebih besar maka arah kan kekanan
                }
            }
            
            newNode.parent=parent; 
                    if(data<0){
                        System.out.println("kiri");
                        parent.left=newNode; 
                    }else {
                        curr=curr.parent;
                        System.out.println("kanan");
                    }
                    
        }

    }
    
    private int counter(Node x){
        int total=0;
        while(x!=null){
            System.out.println("info"+x.info);
            total+=x.info;
            x=x.parent;
        }
        return total;
    }
    
    


}

