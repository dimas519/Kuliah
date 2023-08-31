/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.c11;

/**
 *
 * @author Dimas Kurniawan
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAAC11 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String satu=br.readLine();
        String[]bagi=satu.split(" ");
       int banyak=Integer.parseInt(bagi[0]);
       int ranking=Integer.parseInt(bagi[1]);
//        System.out.println(banyak);
//        System.out.println(ranking);
        MaxHeap heap=new MaxHeap(banyak);
        for(int i=0;i<banyak;i++){
            heap.InsertKey(Integer.parseInt(br.readLine()));
        }
        int urutan[]=new int[ranking];
        for(int i=0;i<ranking;i++){
            urutan[i]=heap.extractMax();
        }
        
        for(int i=ranking-1;i>=0;i--){
            System.out.printf("Ranking-%d : %d\n",i+1,urutan[i]);
        }
        
        
        
        
    }
    
}

class MaxHeap {

    private int maxHeap[];
    private int heapsize;
    private int length;

    public MaxHeap(int length) {
        this.heapsize = 0;
        this.length = length;
        this.maxHeap = new int[length + 1];
    }

    public MaxHeap(int[] arr) {
        this.heapsize = arr.length;
        this.length = arr.length;
        this.maxHeap = new int[length + 1];
        System.arraycopy(arr, 0, this.maxHeap, 1, length);
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

    public void maxHeapify(int i) {
        int left = getLeft(i); //ambil anak kiri
        int right = getRight(i);//ambil anak kanan
        int largest = i;
        if (left <= this.heapsize && maxHeap[left] > maxHeap[largest]) { //jika anak yg dikiri lebih besar maka terbesar di anak kiri
            largest = left;
        }
        if (right <= this.heapsize && maxHeap[right] > maxHeap[largest]) { //jika anak dikanan lebih besar maka set sementara anak terbesar dikanan
            largest = right;
        }

        if (largest != i) { //jika diubah terebsarnya maka ada yg terbesar
            swap(i, largest); //lakukan pertukaran 
            maxHeapify(largest); //ulangi langkah dengn yg terbesar

        }
    }

    public void buildMaxHeap() { //membuat heap agar menjadi terurut dari besar
        for (int i = heapsize / 2; i > 0; i--) {
            maxHeapify(i); //lakukan maxHeapify
        }
    }

    public boolean InsertKey(int key) { //memasukan angka kekey ters
        heapsize++;
        if (this.heapsize <= length) { //jika masih ada space
            maxHeap[heapsize] = Integer.MIN_VALUE; //maka set yg terakhir ke min tak hingga
            increaseKey(heapsize, key); //masukan bilangan yg akan dimasukan
            return true;
        } else {
            return false;
        }
    }

    public boolean increaseKey(int i, int key) { //untuk membandingkan masukan
        if (key <= maxHeap[i]) { //jika tidak ada space langsung return false
            return false;
        } else {
            maxHeap[i] = key; //untuk index ke i masukan data jika ada tempat
            while (i > 1 && maxHeap[getParent(i)] < maxHeap[i]) { //lakukan sorgint untuk menukar-nukar posisi agar menjadi tree yg max
                swap(getParent(i), i); //jika ia maka tukar posisi parent dengan indexnya
                i = getParent(i); //agar i ikut naik keatas 
            }
            return true; //return true karena berhasil masuk
        }
    }

    public int extractMax() { //untuk membuant maximal yg terbesar didalam map
        int max = maxHeap[1]; //dengan cara membuang yg index ke 1 (yg paling depan) karena max tree (yg terbesar didepan
        maxHeap[1] = maxHeap[heapsize]; //masukan heapke 1 dengan heap terakhir(anggapannya ingin yg terkecil
        heapsize--; //kurangi indexnya
        maxHeapify(1); //lalu lakukan sorting lagi
        return max;//kembalikan nilai yg terbesar tadi
    }


    public void swap(int kiri, int kanan) {
        int temp = this.maxHeap[kiri];
        this.maxHeap[kiri] = this.maxHeap[kanan];
        this.maxHeap[kanan] = temp;
    }

    public void heapSort() { //lukan sort dengan sort dengan build maxheap 
        buildMaxHeap();
        for (int i = maxHeap.length - 1; i > 1; i--) { //loop sebanyak panjang
            swap(1, i); //swap i dengan 1 
            heapsize--; //kurangi ukuran size heap
            maxHeapify(1);//lakukan pengurutn ulang
        }

    }
    
    
      public void print() { //method untuk melihat isi heap
        for (int i = 1; i <= heapsize; i++) {
            System.out.print(maxHeap[i]+" ");
        }
          System.out.println();
    }

}
