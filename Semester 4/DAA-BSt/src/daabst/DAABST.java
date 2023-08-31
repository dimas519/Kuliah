/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daabst;

/**
 *
 * @author Kurni
 */
public class DAABST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst =new BinarySearchTree<Integer>();
//        bst.insert(5);
//        bst.insert(14);
//        bst.insert(8);
//        bst.insert(3);
//        bst.insert(11);
//        bst.insert(10);
//        System.out.println(bst);
//        
//        
//        System.out.println(bst.search(10));
//        System.out.println(bst.search(3));
//        System.out.println(bst.search(12));
//        
//        System.out.println("min"+ bst.min());
//        System.out.println("max"+bst.max());
//        
//        System.out.println("succ"+bst.Successor(8));
//        System.out.println("pred"+bst.predecessor(8));
//        
//        System.out.println(bst.delete(5));
//        System.out.println(bst);

    bst.insert(50);
    bst.insert(75);
    bst.insert(60);
    bst.insert(25);
    bst.insert(40);
    
    bst.insert(35);
    bst.insert(10);
    bst.insert(90);
    bst.insert(70);
    bst.insert(37);
    
    bst.delete(50);
    
        System.out.println(bst);



       
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
    
    @Override
    public String toString(){ // methods overloading untuk mengeluarkan bst secara inorder
        return inorder(this.root);
    }
    
    private String inorder(Node x){//methods untuk meng outputkan secara inorder
        if(x==null){ //jika kosong maka kembalikan string kosong
            return "";
        }
        if(x.left==null && x.right==null){ //jika kiri kosong dan kanan kosong maka kembalikan untuk rekursif atau pengulangan di tingkat bawhnya
            return x.toString();
        }else{
            return inorder(x.left)+x.toString()+inorder(x.right); //jika tidak maka keluarkan yg anak plg kiri dahulu baru anak kanan
        }
    }
    
    public T search (T data) { //digunakan methods untuk mencari sebuah nilai apakah ada
        Node result=search(data, this.root); //search ada dinode atau alamat mana
        if(result==null){ //jika tidak ada maka 
            return null; //kembalikan null
        }else {
            return result.info; //jika ada maka kembalikan nilainya
        }
        
    }
    
    private Node search(T data, Node curr){ //search
        if(curr==null){ //jika tidak ada pohonnya dengan root kosong maka kembalikan null
            return null;
        }else if(curr.info.compareTo(data)==0){ //jika sudah sama maka cukup kembalikan posisi alamatnya
            return curr;
        }else if(curr.info.compareTo(data)<0){ //jika lebih kecil maka gerak dulu kekanan
            return search(data,curr.right);
        }else{
            return search(data,curr.left); //jika lebih besar maka gerak kekkri
        }
    }
   
    public T min(){ //mthods yang dapat diakses untuk mencari min

        Node result=min(this.root); //loop mulai dari root
          return result.info;//kembalikan nilainya
    }
    
    private Node min(Node curr){ //methods logika untuk mencari min dengan cara loop kekiri terus menerussampai null kemudian kembalikan
            Node temp=null;
        while (curr!=null){
            temp=curr;
            curr=curr.left;
        }
        return temp;
        
    }
    
    public T max(){ //methods yang digunakan untuk mencari max
        Node result=max(this.root);    //mulai dari root atau akarnya
          return result.info; //kembalikan nilai terbesar
    }
    
    private Node max(Node curr){ //methods logika untuk mencari max dengan cara loop terus menerus kekanan sampai null kemudian kembalikan nodenya
            Node temp=null;
        while (curr!=null){
            temp=curr;
            curr=curr.right;
        }
        return temp;
    }
    
    public T predecessor(T data){ //methods mencari nilai terbesar dari sebuah subtree
        Node result=search(data,this.root); //cari node dimana subtree mulai 
        T hasil=predecessor(result); // kemudian buat seakan-akan subtree sebagai akarnya kemudian ambil nilai terkecilnya
        return hasil;
    }
    
    private T predecessor(Node curr){ //methods yang digunakan untuk mencari nilai terbesar dengan menggunakan methods max
        Node terbesar=max(curr);
        return terbesar.info;
    }
    
    public T Successor (T data){ //sama seperti predecessor
        Node result=search(data,this.root);
        T hasil=successor(result);
        return hasil;
    }
    
    private T successor(Node curr){ //methods yang digunakan untuk mencari nilai terkecil dari sebuah subtre dengan methods min
        Node terkecil=min(curr);
        return terkecil.info;
    }
    
    public boolean delete(T data){// methods dapat diakses untuk mendelete sebuah node 
        Node del=search(data,this.root); // pertama cari dahulu dimana alamat node tersebut
        if(del==null){  //jika tidak ada node tersebut maka kembalikan true
            return false;
        }else{ //jika berhasil maka lakukan delete dan return true
            delete(del,data);
            return true;
        }
    }

    private Node delete(Node del,T data){
       if (del.left==null && del.right==null){  //kalau dia kosong langsung hilangkan saja
           del=null;
       } else if (del.right!=null){ //kalau kanannya tidak kosong maka isi kanan nya dengan yang terkecil
               del.info=successor(del.right);
               del.right=delete(del.right,del.info);
       }else {
          del.info=predecessor(del.left);  // kebalikan kalau dia dikanan berarti isi dengan yg kanan
           del.left=delete(del.left,del.info);
       }
       
       return del;
}
    
}