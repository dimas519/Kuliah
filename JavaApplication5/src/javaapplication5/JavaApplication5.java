/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Kurni
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        PseudoRandom pr=new PseudoRandom(10,33,220000,1);
//        for(int i=0;i<50;i++){
//        int rand=pr.getRandom();
//        System.out.println(rand%7);
//        pr.setZ(rand);
//        }
//        Random ran=new Random(9606978);
//        for(int i=0;i<100;i++){
//            System.out.println(ran.nextInt(7));
//    }

//
//        int a=500000;
//        Locale Locale_IDR;
//       
//        NumberFormat fp=NumberFormat.getCurrencyInstance(new Locale("IN","ID"));
//        System.out.println(fp.format(a));
//       
//        System.out.println(getData());
//        MinHeap heap = new MinHeap(20);
//        heap.insert(999);
//        heap.insert(11); //5
//        heap.insert(1);
//        heap.insert(10);
//        heap.insert(50); //3
//        
//        heap.insert(-1);
//        heap.insert(-4);
//        heap.insert(99); //1
//        heap.insert(20); //4
//        heap.insert(88); //2
//        
//        heap.insert(14);
//        heap.insert(-8);
//        heap.insert(99);
//        heap.insert(71);
//        heap.insert(0);
//        
//        heap.insert(12);
//        heap.insert(43);
//        heap.insert(33);
//        heap.insert(1);
//        heap.insert(42);
//        
//        heap.insert(82);
//        heap.insert(53);
//        heap.insert(93);
//        heap.insert(100);
//        heap.insert(422);
        
        
        int hasil=LevenshteinDistance.counter("andii", "andi");
        int hasil2=LevenshteinDistance.counter("andi", "edi");
        System.out.println(hasil);
        
//        int res=LCS.counter("ndi", "andi");
//        System.out.println(res);
        
//        
//        int res=LCS.counter("ndi", "andii");
//        System.out.println(res);

    }

}

class LCS{
    public static int counter(String kataSatu,String kataDua){
        
        if(kataSatu.length()<kataDua.length()){ //memastikan dua lebih pendek
            String temp=kataSatu;
            kataSatu=kataDua;
            kataDua=temp;
        }
        
        int LCSSuffix=suffix(kataSatu,kataDua);
        int LCSPrefix=prefix(kataSatu,kataDua);
        System.out.println(LCSSuffix);
        System.out.println(LCSPrefix);
        if(LCSSuffix<LCSPrefix){
            return LCSPrefix;
        }else{
            return LCSSuffix;
        }
        
        
        
        
    }
    
    
    public static int prefix(String kataSatu,String kataDua){//dipastikan dahulu 2 yang lebih pendek
        int jumlahKarakter=0;
        for (int i=0;i<=kataDua.length();i++){ //maks sepanjang yang pendek
            String dua=kataDua.substring(0,i); // panjang dari 0 sampai semua
            for(int j=0;j<=kataSatu.length()-i;j++){
                String satu=kataSatu.substring(j,j+i);
                if(satu.equals(dua)){
                    jumlahKarakter=i;
                    break;
                }
            }   
        } 
       return jumlahKarakter;
    }
    
    public static int suffix(String kataSatu,String kataDua){
        int lenDua=kataDua.length();
        int lenSatu=kataSatu.length();
        int jumlahKarakter=0;
        
        for (int i=lenDua;i>=0;i--){
             String dua=kataDua.substring(i,lenDua);
             for(int j=lenSatu;j>=0;j--){
                 String satu=kataSatu.substring(j,lenSatu);
                 if(satu.equals(dua)){
                    jumlahKarakter=i;
                    break;
                }
             }
        }
        return jumlahKarakter;
    }
    
    
}




class LevenshteinDistance {
    public static int counter(String kataSatu,String kataDua){
        
        kataSatu="-"+kataSatu;
        kataDua="-"+kataDua;
        int baris,kolom;
        String kataAtas,kataSamping;
        if(kataSatu.length() <= kataDua.length()){
            baris=kataSatu.length();
            kolom=kataDua.length();
            kataAtas=kataSatu;
            kataSamping=kataDua;
            
            
        }else{
            baris=kataDua.length();
            kolom=kataSatu.length();
            kataAtas=kataDua;
            kataSamping=kataSatu;
            
          
            
        }
        
        
        
        
        
        
        int arr[][]=new int[baris][kolom];
        
        
        
        //bikin  Atas dulu
        for (int i=0;i<kolom;i++){
            arr[0][i]=i;
        }
        
        //bikin  samping kiri
        for (int i=0;i<baris;i++){
            arr[i][0]=i;
        }
        
        
        for(int i=1;i<baris;i++){
            char currAtas=kataAtas.charAt(i);
            for (int k=1;k<kolom;k++){
                
                int terkecil=Math.min(Math.min(arr[i][k-1], arr[i-1][k]),arr[i-1][k-1]);
                
                char currSamping=kataSamping.charAt(k);
                if(currAtas==currSamping && i==k){
                    
                }else{
                    terkecil++;
                }
                
                arr[i][k]=terkecil;
            }
        }
        
        System.out.println();
        System.out.println(kataAtas+" "+baris);
        System.out.println(kataSamping+" "+kolom);
        for(int i=0;i<baris;i++){
            for (int k=0;k<kolom;k++){
                System.out.print(arr[i][k]);
            }
            System.out.println();
        }
        
        
        
        
        return arr[baris-1][kolom-1];
        
    }
  
    
    
    
    
    
}



























class MinHeap {

    private int[] heap;
    private int size;
    private int curr;

    public MinHeap(int size) {
        this.size = size;
        this.heap = new int[size + 2];  // 1 mau dibuang diawal untuk speed getleft/right 
        this.curr = 1;
    }

    private int getRight(int curr) {
        return curr << 1;
    }

    private int getLeft(int curr) {
        return getRight(curr) + 1;
    }

    private int getParrent(int curr) {
        return (int) curr >> 1;
    }

    public int insert(int x) {
        if(this.curr<=size){
            this.heap[this.curr]=x;
            insertSort(this.curr);
            this.curr++;
        }else{
            //remove dulu baru add dibelakang
            this.heap[this.curr]=x;
            
            removeRoot();
            
        }
        
        return this.heap[1];
        }

    private void insertSort(int curr) { //loop ke atas saat pengisian
        int currValue=this.heap[curr];
        int parrentPos=getParrent(curr);
        if(parrentPos!=0){
            int parrValue=this.heap[parrentPos];
            if(currValue<parrValue){
                swap(curr,parrentPos);
                insertSort(parrentPos);
            }
        }
    }
    
    
    private int removeRoot(){
        
         if(this.heap[1]<this.heap[this.curr]){
             
            swap(this.curr,1);
            
            sort(1);
            return this.heap[curr];
         }
         return this.heap[1];
    }
    
    private void sort(int curr){
        int left=getLeft(curr);
        int right=getRight(curr);
        int currValue=this.heap[curr];
        
        
        if(left <= this.size && right <= this.size){
            
            
            int anakKiriValue=this.heap[left];
            int anakKananValue=this.heap[right];
            
            
            if(anakKananValue<= anakKiriValue){
                if(currValue>anakKananValue){
                    swap(curr,right);
                    sort(right);
                }
                
                
            }else if(anakKananValue > anakKiriValue){
                if(currValue>anakKiriValue){
                    swap(curr,left);
                    sort(left);
                }
                
                
                
            } 
        } else if(left<=this.size){
            int anakKiri=this.heap[left];
            if(currValue>anakKiri){
                swap(curr,left);
                sort(left);
            }
            
            
            
        } else if(right<=this.size){
            int anakKanan=this.heap[right];
            if(currValue>anakKanan){
                swap(curr,right);
                sort(right);
            }
            
            
        }
    }
    
    
    
    
    

    private void swap(int a, int b) {
        int temp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = temp;
       
    }




    public void debug() {
        for (int x : this.heap) {
            System.out.println(x);
            
        }
    }
    
    
    public int[] getHasil(){
        int result[]=new int[this.size];
        int max=Integer.MAX_VALUE;
        debug();
        for(int i=this.size-1;i>=0;i--){
            this.heap[this.curr]=max;
            result[i]=removeRoot();
            max--;
           
            System.out.println(i+" "+result[i]);
          //  System.out.println(this.heap[i].getJudul()+" "+this.heap[i].getBobot());
        }
        
        return result;
        
    }
    
    
}













































class PseudoRandom {

    HashMap<Integer, Integer> key = new HashMap<>();
    HashMap<Integer, Integer> value = new HashMap<>();
    int z, i, m, l;

    public PseudoRandom(int z, int i, int m, int l) {
        this.i = i;
        this.z = z;
        this.m = m;
        this.l = l;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getRandom() {
        while (z != 0 || i != 0 || m != 0 || l != 0) {
            int sama = 0;
            int res = 0;
            int idx = 0;
            while (sama == 0) {
                int hit = (((z * l) + i) % m);
                this.l = hit;
                if (key.get(hit) != null && key.get(hit) == 1) {
                    sama = 1;
                    res = idx - value.get(hit);
                    return res;
                }
                value.put(hit, idx);
                key.put(hit, 1);
                idx++;
            }
        }
        return 0;

    }

}

class Trie implements converter {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(null);
    }

//    public void fill(String kata) {
//        TrieNode current = getNode(0, kata);
//        current.incValue();
//    }
    public void fill(String kata) {
        TrieNode current = root;
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = toNumber(huruf);
            TrieNode[] arr = current.getArray();

            if (arr[urut] == null) {
                arr[urut] = new TrieNode(current);
            }
            current = arr[urut];
        }
        current.incValue();
    }

    public int getValue(String kata) {
        TrieNode current = getNode(1, kata);
        if (current == null) {
            return -1;
        } else {
            return current.getValue();
        }
    }

    public TrieNode getNode(int aksi, String kata) { // aksi 0 untuk insert 1 untuk delete(?) atau getValue
        TrieNode current = root;
        int panjangKata = kata.length();
        for (int i = 0; i < panjangKata; i++) {
            char huruf = kata.charAt(i);
            int urut = toNumber(huruf);
            TrieNode[] arr = current.getArray();
            if (arr[urut] == null) {
                if (aksi == 0) {
                    arr[urut] = new TrieNode(current);
                    current = arr[urut];
                } else {
                    return null;
                }
            } else {
                current = arr[urut];
            }
        }

        return current;
    }

    public void getAllData() {
        TrieNode current = this.root;
        getAll(current, "");

    }

    private ArrayList<String> data = new ArrayList<>();

    private void getAll(TrieNode curr, String temp) {
        TrieNode arr[] = curr.getArray();
        for (int i = 0; i < 26; i++) {
            TrieNode x = arr[i];
            if (x != null) {
                getAll(x, temp + toChar(i));
                if (x.getValue() != 0) {
                    System.out.println(temp + toChar(i) + " " + x.getValue());
                }
            }
        }

    }

    @Override
    public int toNumber(char a) {
        int hasil = (int) a;
        hasil -= 65;
        return hasil;
    }

    public char toChar(int a) {
        a = a + 65;
        return (char) a;
    }

}

interface converter {

    public int toNumber(char A);

    public char toChar(int a);
}

class TrieNode {

    private int value;
    private TrieNode[] arr;

    public TrieNode(TrieNode parrent) {
        this.arr = new TrieNode[26];
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TrieNode[] getArray() {
        return this.arr;
    }

    public void setArray(TrieNode[] arr) {
        this.arr = arr;
    }

    public void incValue() {
        this.value++;
    }

}
