/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.kuispq2;

/**
 *
 * @author Dimas Kurniawan
 */



import java.util.Scanner;


        
public class DAAKuispq2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        MinHeap h=new MinHeap(1000000);
        while (1==1){
            String kata=sc.next(); //ambil kata secara full
            if(kata.equals("#")){ //jika ketemu titik hentikan loop forever
                break; //untuk berenti
            }
            
            int tahun =sc.nextInt();
            int detik=sc.nextInt();
            
            h.Insert(tahun, detik);

        }
        
        int jumlah=sc.nextInt();
        
        for(int i=0;i<jumlah;i++){
            int arr[]= h.extractMin();
            System.out.println(arr[0]);
            h.Insert(arr[0], arr[1]+arr[1]);
        }
        
        
        
        
    }
    
}


class MinHeap {
    private Data Heap[];
    private int position[];
    public int heapsize;
    private int length;

    
        private class Data{ //objek untuk tipe data
        int id;
        int key;
        
        Data(int id,int key){
            this.id=id;
            this.key=key;
        }
    }
    


    public MinHeap(int length) {
        this.heapsize = 0;
        this.length = length;
        this.Heap = new Data[length + 1];
        this.position=new int[length+1];
    }

   

    private int getLeft(int i) { //untuk mengali dengan 2 dengan binarynya digeser 1
        return i << 1;
    }

    private int getRight(int i) { //untuk mengali dengan 2 dengan binarynya digeser 1 dan terakhir ditambah 1
        return (i << 1) | 1;
    }

    private int getParent(int i) {// untuk mengambil parentnya dengan cara membagi 2 dengan menggeser binarrynya
        return i >> 1;
    }

    public void swap(int kiri, int kanan) {// agoritma untuk melakukan sorting 
        Data temp = this.Heap[kiri]; //temp dulu data yang terkandung didalam heap
        this.Heap[kiri] = this.Heap[kanan]; //tukar yang dikiri dengan dikanan
        this.Heap[kanan] = temp; //masukan yng kanan dengan yg kiri
        
        int id1=this.Heap[kiri].id;//ambil data id kiri
        int id2=this.Heap[kanan].id;//ambil brp id kanan yg baru
        
        int temp2=this.position[id1]; // tukar posisi sesuai dengan idnya dengan cara menggunakan temp
        this.position[id1]=this.position[id2];
        this.position[id2]=temp2;
    }
    
    public void decreaseKey(int id,int newKey){ //untuk mencari berapa key terkecil yang ada diarray
        int curr=this.position[id]; //menngambil indexnya
        if(curr ==0){  return;    //jika 0 maka tidak mungkin akrena tidak ada yg 0 (tidak dipakai)
        }
            if(this.Heap[curr].key>newKey){ // jika key didaalam position lebih kecil maka keybaru maka
                this.Heap[id].key=newKey; //replace keynya secara langsung
                while (id>1 &&Heap[getParent(id)].key >Heap[id].key){ //lakukan looping untuk me-re-sort array
                    swap(getParent(id),id);//dengan swap (parent i dan i
                    id=getParent(id); // terus sampai keatas (root)
                }
            }
        
    }
    
    public boolean Insert(int id,int key) { //memasukan angka kekey ters
        if(this.heapsize==this.length){ //jika ukurannya sama false karena indexing array harus-1 dari ukuran karena hitungan dari 0 seangkan jumlah 1
            return false;
        }else if (id<=0 || id>this.length){ //jika lebih kecil jg tidak mungkin karena array dalam harus lebih besar dari 0 sampai dengan length-1
            return false;
        }else if (this.position[id]!=0){ //begitu pula untuk array posititon
            return false;
        }else{ //jika berhasil melewati syarat diatas maka
            heapsize++; //tambahkaan sizenya
        //jika masih ada space
            Heap[this.heapsize] = new Data(id,Integer.MAX_VALUE); //maka set yg terakhir ke min tak hingga //masukan pertama id dan keynya max agar nanti di decrase(penjelasan)
            this.position[id]=this.heapsize; //jangan lopa masukan id ke brp dengan heap sizenya
            decreaseKey(id, key); //saat melakukan decrease key max bisa ditukar karena anggapannya tak hingga
            return true; //kembalikan sukses
        
        }
    }
    
    public void minHeapify(int i) {
        int left = getLeft(i); //ambil anak kiri
        int right = getRight(i);//ambil anak kanan
        int largest = i;
        if (left <= this.heapsize  && Heap[left].key < Heap[largest].key) { //jika anak yg dikiri lebih besar maka terbesar di anak kiri
            largest = left;
        }
        
        if (right <= this.heapsize && Heap[right].key < Heap[largest].key) { //jika anak dikanan lebih besar maka set sementara anak terbesar dikanan
            largest = right;
        }

        if (largest != i) { //jika diubah terebsarnya maka ada yg terbesar
            this.swap(i, largest); //lakukan pertukaran 
            minHeapify(largest); //ulangi langkah dengn yg terbesar

        }
    }
    
    public int[] extractMin(){
        if (this.heapsize==0){ //jika size 0 jg tidak mungkin karena data belum distore dan array 0 tidak terpakai untuk implementasi heap
            return null;
        }
        
        this.swap(1, this.heapsize); //lakukan algoritma sorting 1 dengan yg paling belakang agar terurut
        Data d=this.Heap[this.heapsize];//ambil sebuah data paling belakang
        this.position[d.id]=0;//jadikan idnya 0 (utnuk menghapus)
        this.heapsize--;//kemudian kurangi 1 karena sudah diambil
        this.minHeapify(1); ///lakukan sorting lagi
        
        int result[]=new int[2];//mengatur output agar bisa 2 buah int
        result[0]=d.id;
        result[1]=d.key;
        return result;

    }
}