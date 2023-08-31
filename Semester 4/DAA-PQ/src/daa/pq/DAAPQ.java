/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.pq;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAPQ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("PQ modul");
        PriorityQueue pq = new PriorityQueue(10);
        System.out.println(pq.insert(20));
        System.out.println(pq.insert(30));
        System.out.println(pq.extractMax());
        System.out.println(pq.insert(10));
        System.out.println(pq.insert(8));
        System.out.println(pq.max());

        System.out.println("PQ LinkedList Latihan");
        PQwithLL pqll = new PQwithLL();
        pqll.insert(20);
        pqll.insert(30);
        System.out.println(pqll.extractMax());
        pqll.insert(10);
        pqll.insert(8);
        System.out.println(pqll.max());

    }

}

class PriorityQueue {

    private Integer array[];
    private int size;
    private int length;

    PriorityQueue(int length) {
        this.length = length;
        this.size = 0;
        this.array = new Integer[length];
    }

    public boolean insert(Integer x) { //insert pertamanya sesuai dengan urutan masuknya saja
        if (size < length) { // jika masih ada space
            array[size] = x; //maka masukan parameter / input kedalam array
            size++; // dan tambahkan x agar menggeser kesamping
            return true; //dam kembalikan true sebagai tanda bahwa masih ada space dan behasil diinput
        } else {
            return false; //jika tidak ada maka cukup kembalikan nilai false yg tandanya sudah penuh
        }

    }

    public Integer max() { //methods yang mengeluarkan nilai terbesar dalam array tanpa mengeluarkan atau menghapus 
        int i, max;
        if (this.size == 0) { //jika size nol maka tidak ada yg max langsung saja kembalikan null
            return null;
        } else { //jika ada isinya maka
            max = this.array[0]; //gunakan algoritma untuk mencari yang terbesar
            for (i = 1; i < this.size; i++) {
                if (this.array[i] > max) {
                    max = this.array[i];
                }
            }
            return max; //setelah dapat langsung keluarkan
        }
    }

    public Integer extractMax() { //sama seperti max namun yang ini dihilangkan atau dihapus
        int i, max, temp;

        if (this.size == 0) { //sama seperti diatas jika kosong maka langsung kembalikan null karena tidak ada isinya
            return null;
        } else { // jika ada isinya maka
            max = 0; //gunakan algoritma untuk mencari max dan
            for (i = 1; i < this.size; i++) {
                if (this.array[i] > this.array[max]) {
                    max = i;
                }
            }
            temp = this.array[max]; //simpan dahulu temp sebagai nanti untuk output
            this.array[max] = this.array[size - 1]; //digunakan untuk mengahpus nilainya
            size--; //kurangi sizenya
            return temp; //kembalikannilainya
        }
    }

    public void increaseKey(int i, int key) { //untuk menganti indeks ke i dengan nilai key
        this.array[i] = key;
    }

}

class PQwithLL { //Priority Queue yang menggunakan linkedlist

    MyLinkedList ll = new MyLinkedList(); //insialisasi linkedlist dahulu
    int size = 0; // size awalnya 0

    public void insert(int data) { //karena linkedlist maka pasti selalu masuk
        ll.addFirst(data); //lakukan add first (bebas mau add last jg boleh karena nanti akan disorting)
        ll.insertion(); //lakukan sorting dengan algoritma apa saja (kalau saya menggunakan insertion)
        size++; //tambahkan sizenya
    }

    public int max() { //untuk mengintip nilai max 
        int temp = ll.removeFirst(); //dapat dengan cara remove dahulu yg paling besar(dalam hal ini didepan)
        insert(temp); // kemduian masukan kembali nilainya
        return temp; //terakhir tinggal keluarkan
    }

    public int extractMax() {
        int res = ll.removeFirst(); // untuk mengeluarkan dang menghapus cukup dengan remove depan (yg paling besar saja)
        return res; //kemudian kembalikan
    }

}

class Mynode {

    private int info;
    private Mynode next;

    public void setNext(Mynode next) {   // untuk alamat selanjutnya
        this.next = next;
    }

    public Mynode getNext() {   // petunjuk alamat  berikutnya
        return next;
    }

    public int getInfo() { // untuk mengeluarkan nilai alamat
        return info;
    }

    public void setInfo(int info) {  //untuk menerima info
        this.info = info;
    }

    public Mynode(int info) {
        this.info = info;
        this.next = null;
    }
}

class MyLinkedList {

    private Mynode head;
    private int count;

    public MyLinkedList() {
        head = null;
        count = 0;
    }

    public void addFirst(int info) {
        Mynode newNode = new Mynode(info);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);  // sambungin dahulu yg baru ke alaamat lama
            head = newNode;

        }
    }

    public int removeFirst() {
        if (head == null) {
            return -1;
        } else {
            count--;
            Mynode removeNode = head;
            head = head.getNext();
            return removeNode.getInfo();
        }
    }

    public int size() {  //ukuran
        Mynode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.getNext();
        }
        return i;
    }

    public Mynode getAlamat(int x) {  // untuk mendapatkan alamat ke-x
        Mynode cur = head;
        int i = 0;
        while (i < x) {
            cur = cur.getNext();
            i++;
        }
        return (cur);

    }

    public int get(int x) {   // untuk mendapatkan nilai ke -x
        Mynode cur = head;
        int i = 0;
        while (i < x) {
            cur = cur.getNext();
            i++;
        }
        return (cur.getInfo());

    }

    public void insertion() {
        int temp = 0;
        int panjang = size();
        int i = 1;
        while (i < panjang) {
            int u = i;
            int kiri = get(u - 1);
            int kanan = get(u);
            temp = 0;
            while (u > 0 && kiri < kanan) {
                temp = kiri;
                kiri = kanan;
                kanan = temp;

                Mynode nKiri = getAlamat(u - 1);
                Mynode nKanan = getAlamat(u);

                nKiri.setInfo(kiri);
                nKanan.setInfo(kanan);
                u--;
                kiri = get(u - 1);
                kanan = get(u);

            }
            i++;
        }

    }

}
