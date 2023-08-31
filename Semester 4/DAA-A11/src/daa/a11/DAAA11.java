/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a11;

/**
 * 
 * MULTIPLICANT HASH
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;

public class DAAA11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModularHashInteger<String> hash=new ModularHashInteger<String>(100,0.618);
        int jumlah=sc.nextInt();
        
        for(int i=0;i<jumlah;i++){
            char fungsi=sc.next().charAt(0);
            int isi=sc.nextInt();
            
            
            if(fungsi=='i'){
                String value=sc.next();
              int masuk=hash.insert(isi,value);
               if(masuk==-1){
                   System.out.println("Data tidak dapat disimpan.");
               }else {
                   System.out.println("Data disimpan di dalam tabel indeks ke-"+masuk+".");
               }
            }else if(fungsi=='s'){
                String out=hash.Search(isi);
                if(out==null){
                    System.out.println("Data tidak ditemukan.");
                }else{
                    System.out.println("Data ditemukan, value = "+out+".");
                }
            }else if (fungsi=='d'){
                String out=hash.delete(isi);
                if(out==null){
                    System.out.println("Gagal menghapus data, data tidak ditemukan.");
                }else{
                    System.out.println("Data "+out+" berhasil dihapus.");
                }
            }
        }
        
        
        
        
    }
    
}

abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;
    protected Data tombStone= new Data(null,null);
    
    private class Data{ //untuk mengimpan dalam bentuk data jadi ada idx setelah dihash(?) dan juga valuenya
        K key;
        V value;
        
        Data(K key, V value){ // sebagai sebuah tipe data yg akan menyimpan k dan v dalam array nantinya
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable (int capacity){ //sebuah konsturktor sebagia insialisasi ukuran dan arraynya
        this.capacity=capacity;
        this.table= (Data[]) new HashTable.Data[capacity];
    }
    
    
    abstract protected int HashFunction (K key); //sebagai pengisi nantinya akan dipakai hash function yg mana
    
    public V Search(K key){ //methods untuk mencari sebuah bilangan yang sudah dihash terlebih dahulu
        int idx=this.HashFunction(key);//pertama kita cari dahulu brp hash yang dihasilkan
        V result=null;
            if(this.table[idx]==null){ //jika ketemu null maka kembalikan null karena sudah terloop atau terjadi pengulangan
                return result;
            } else if(this.table[idx]!=this.tombStone &&this.table[idx].key.equals(key)){ //jika sudah ketemu yang  nilainya sma dengan key pada data sma dengan key paramete nya maka
                result=this.table[idx].value; //maka kembalikan value pada data yang ada data(tipe data)
                return result;
            }
            return result;
    }
    
    public int insert(K key, V value){ // methods insert atau masuk yang akan mengisi array setelah idx di hash
        int idx=this.HashFunction(key); // cari brp nilai setelah hash dilakukan
//        System.out.println(idx);
//        System.out.println(key+" "+idx); // untuk debug melihat brp hasil hashing dari 16
        if(this.table[idx]==null || this.table[idx]==this.tombStone){ // jika masih kosong maka kita dapat memasukannya dengan cara
            Data in =new Data(key,value); //pertama dibuat dulu apa yang akan dimasukan
            this.table[idx]=in; //setelah itu masukan kedalam array dan return true
            return idx;
        }else { // dan jika ternyata array sudah ada yg mengisi maka return false
            return -1;
        }
    }
    
    public V delete(K key){ //methods untuk menghapus isi dari sebuah array
        int idx=this.HashFunction(key); // dengan cara cari dahulu brp nilai setelah di hash
//        System.out.println(idx);
               V Result=null;
            if(this.table[idx]==null){
                return Result;
            } else if(this.table[idx]!=this.tombStone &&this.table[idx].key.equals(key)){ //jika nilai keynya pas dengan nilai key dan juga bukan bagian yg pernah dihapus maka
                Result=this.table[idx].value; //ambil dahulu berapa nilainya untuk pada akhirnya akan dikembalikan
                this.table[idx]=this.tombStone; //buat idx yang tadi menjadi null namun dengan ditandai sebagai yg sudah pernah dihaspus
                return Result;
            }
            return Result;
    }
    
}


class ModularHashInteger <V> extends HashTable <Integer,V>{ //modular hash integer digunakan untuk memnghase secara multiplicative
    double ratio;

    public ModularHashInteger (int Capacity,double ratio){ //konstuktornya yg parameter ukuran dari aray;
        super(Capacity);
        this.ratio=ratio;

    }
    @Override
    protected int HashFunction(Integer key){
        return (int)(this.capacity*((ratio*key%1)));
    }
}
























//class HashMulti {
//    protected int ukuran;
//    protected double a;
//    String arr[];
//    public HashMulti(int ukuran,double a){
//    this.ukuran=ukuran;
//    this.a=a;
//    this.arr=new String[ukuran];
//    }
//    
//    private int hashing(int pos){ //untuk mendapatkan alamat hashnya
//        int hasil=(int)(100*Math.floor((pos*a)%1));
//        System.out.println(hasil);
//        return hasil;
//        
//    }
//    
//    public int input(int pos,String kata){
//        int posisi=hashing(pos);
//        if(arr[posisi]==null){
//            arr[posisi]=kata;
//            return posisi;
//        }else {
//            return -1;
//        }
//    }
//    
//        public String delete(int pos){
//        int posisi=hashing(pos);
//        if(arr[posisi]!=null){
//            String temp=arr[posisi];
//            arr[posisi]=null;
//            return temp;
//        }else {
//            return null;
//        }
//    }
//        
//    public String find(int pos){
//        int posisi=hashing(pos);
//        return arr[posisi];       
//    }
//}



