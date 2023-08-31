/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.tugmap;

import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAATUGMap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        MaxHeap h = new MaxHeap(n + 11);

        int day = sc.nextInt();
        double total = 0.0;
        for (int i = 1; i <= day; i++) {
            int bobot = sc.nextInt();
            h.InsertKey(bobot);
            if (i >= n) {
                if (i > n) {
//                    System.out.println("buang"+ h.extractMax());
                    h.extractMax();
                }
                double res = h.print();
                double hasil = res / i;
                System.out.printf("%.3f\n", hasil);
                total += hasil;
//                   System.out.println("Test"+res);
            }
        }
        System.out.printf("%.3f\n", total);
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
        if (right <= this.heapsize && maxHeap[right] > maxHeap[largest]) {
            largest = right;
        }
        if (left <= this.heapsize && maxHeap[left] > maxHeap[largest]) {
            largest = left;
        }

        if (largest != i) {
            int temp = this.maxHeap[i];
            this.maxHeap[i] = this.maxHeap[largest];
            this.maxHeap[largest] = temp;
            maxHeapify(largest);

        }
    }

    public boolean InsertKey(int key) {
        heapsize++;
        if (this.heapsize <= length) {
            this.maxHeap[heapsize] = Integer.MIN_VALUE;
            increaseKey(this.heapsize, key);
            return true;
        } else {
            return false;
        }
    }

    public boolean increaseKey(int i, int key) {
        if (key <= this.maxHeap[i]) {
            return false;
        } else {
            maxHeap[i] = key;
            while (i > 1 && maxHeap[getParent(i)] < maxHeap[i]) {
                int temp = this.maxHeap[getParent(i)];
                this.maxHeap[getParent(i)] = this.maxHeap[i];
                this.maxHeap[i] = temp;
                i = getParent(i);
            }
            return true;
        }
    }

    public int extractMax() {
        int max = this.maxHeap[1];
        this.maxHeap[1] = maxHeap[heapsize];
        this.heapsize--;
        maxHeapify(1);
        return max;
    }

    public double print() {
        double hasil = 0;
        for (int i = 1; i <= heapsize; i++) {
//                 System.out.println("Debug"+this.maxHeap[i]);
            hasil += this.maxHeap[i];
        }
        return hasil;
    }


}
