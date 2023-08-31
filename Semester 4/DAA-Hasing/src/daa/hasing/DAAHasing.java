/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.hasing;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAHasing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModularHashInteger<String> h=new ModularHashInteger<String>(11);
        h.insert(5, "John Smith");
        h.insert(16, "Jane Smith");
        System.out.println(h.Search(5));
        System.out.println(h.Search(16));
        System.out.println();
        
        
        ModularHashString<String> j=new ModularHashString(11);
        j.insert("ABC", "string");
        System.out.println(j.Search("ABC"));
        System.out.println(j.Search("BBB"));
        System.out.println();
        
        
        FoldingHashInteger<String> x=new FoldingHashInteger<String>(3);
        x.insert("123456","Folding");
        System.out.println(x.Search("123456"));
        System.out.println(x.Search("4524545"));
        
        MultiplicativeHashInteger<String> v=new MultiplicativeHashInteger<String>(45,0.618);
        v.insert(11, "multiplicative");
        System.out.println(v.Search(11));
        System.out.println(v.Search(22));
        
        
        
        
    }
    
}


abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;

    
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
        if(this.table[idx]!=null && this.table[idx].key.equals(key)){ //jika ada nilai hashnya maka cukup dikeluarkan dan jika tidak maka return null saja
        return this.table[idx].value;
    }else{
            return null;
        }
    }
    
    public boolean insert(K key, V value){ // methods insert atau masuk yang akan mengisi array setelah idx di hash
        int idx=this.HashFunction(key); // cari brp nilai setelah hash dilakukan
//        System.out.println(key+" "+idx); // untuk debug melihat brp hasil hashing dari 16
        if(this.table[idx]==null){ // jika masih kosong maka kita dapat memasukannya dengan cara
            Data in =new Data(key,value); //pertama dibuat dulu apa yang akan dimasukan
            this.table[idx]=in; //setelah itu masukan kedalam array dan return true
            return true;
        }else { // dan jika ternyata array sudah ada yg mengisi maka return false
            return false;
        }
    }
    
    public boolean delete(K key, V value){ //methods untuk menghapus isi dari sebuah array
        int idx=this.HashFunction(key); // dengan cara cari dahulu brp nilai setelah di hash
        if(this.table[idx]==null){ // dan jika ternyata sudah kosong maka kita tidak bisa-perlu menghapus dan kembalikan false
            return false;
        }else { // dan jika ada isinya maka set menjadi kosong(di hapus) dan kembalikan true
            this.table[idx]=null;
            return false;
        }
    }
    
    
}

class ModularHashInteger <V> extends HashTable <Integer,V>{ //modular hash integer digunakan untuk memnghase secara multiplicative
    public ModularHashInteger (int Capacity){ //konstuktornya yg parameter ukuran dari aray;
        super(Capacity);
    }
    @Override
    protected int HashFunction(Integer key){ //cukup lakukan modulo dengan besar array maka kita akan mendapatkan nilai hashnya yg dijamin tidak bertabrakan
        return key%this.capacity;
    }
}

class ModularHashString <V> extends HashTable<String, V>{ // adalah hash untuk string / karakter lainnya yg ada nilai ascii nya
    int capacity;
    public ModularHashString(int capacity){ //konstuktornya yg parameter ukuran dari aray;
    super(capacity);
    this.capacity=capacity;
    }
    @Override
protected int HashFunction(String key){  //hash function dengan melakukan perpangkatan terhadap 256 dengan pangkat dibalik dan dimulai dari 0
            char[] kode=key.toCharArray();// pertama array dipisahkan dulu masing-masing menjadi 1 block 1 karakter
            int panjang=kode.length-1; // dalam methods ini saya membalik cara kalau dippt dengan belakang dipangkat 0 namun saya ( yg ini ) depan dipangkatkan panjang -1
            int hasil=0; //sebagai output
            for(char e:kode){ //untuk setiap block dalam kode lakukan
                hasil+=((((int)e)*(Math.pow(256,panjang)))%capacity) ;// cari kode asciinya, kemudian pangkatkan 256 dengan panjang -1, kali kan keduanya dan terakhir modulo dengan ukuran array
                panjang--; //setiap loop minus 1 karena menyesuaikan dengan teknik
            }
            return hasil%capacity; //keluarkan hasilnya
    }
}

class FoldingHashInteger <V> extends HashTable<String,V>{
    int Capacity;
    public FoldingHashInteger(int Capacity){
        super(Capacity);
        this.Capacity=Capacity;
    }
    @Override
    protected int HashFunction(String key){
        int panjang=key.length();
        int baris=(panjang/Capacity);
        int kurang=0;
           if(panjang%Capacity!=0){ //untuk jika tidak pas maka perlu 1 baris yg mana depan nya ada 0* ( 0 sebanyak yang dibutuhkab)
            baris++;
            kurang=(Capacity*baris)-panjang; //menghitung berapa banyak 0 dibutuhkan untuk mengepaskan
        }
        int arr[][]=new int[baris][Capacity];  //menyimpan dengan terbalik dengan yg dikelas        
        int x=0;
        int y=0;
        while (kurang>0){ //memasukan 0 sebanyak yang dibutuhkan agar array( dan tahu dimana kita dapat mulai masukan nomor karena terbalik (dengan yg kelas))
            arr[y][x]=0;
            x++;
            kurang--;
        }      
        int i=0;
        for(y=y;y<baris;y++){ //memasukan angka yang dinput kan
            for(x=x;x<Capacity;x++){ //y=y dan x=x untuk mengantisipasi bahwa sudah ada 0 lebih dahulu didepannya sehingga baris plg atas harus melanjutkan baru setelah pindah baris di 0kan lagi
                arr[y][x]=key.charAt(i)-48;
                i++;
            }          
            x=0;
        }        
        int hasil[]=new int[Capacity];     
        for(int h=Capacity-1;h>=0;h--){  //menghitung kebawah dahulu seperti dikertas tapi tanpa carry atau diambil angka belakang saja
            int counter=0;
            for(int v=0;v<baris;v++){
                counter+=arr[v][h];
            }
            counter=counter%10;
            hasil[h]=counter;
        }   
        String gabung="";//untuk mengabungkan int yg per kolom
        for(int l:hasil){ //print semuadalam bentuk hash
            gabung+=""+l;
        }
       int output=Integer.parseInt(gabung)%Capacity; //lakukan modulo lagi untuk menghasilkan hash yang dibutuhkan karena angka dengan cara ini cukup bsear
        return output;
    }
}



class MultiplicativeHashInteger <V>  extends HashTable<Integer,V>{ //class untuk hashing dengan sebuah ratio
    double ratio;
    int Capacity;
    public MultiplicativeHashInteger(int Capacity,double ratio){ //konstruktor dengan parameter brp ukuran dari array dan brp ratio yang akan dipakai
        super(Capacity);
        this.Capacity=Capacity;
        this.ratio=ratio;
    }
    
    @Override
    protected int HashFunction(Integer key){ // hash yang akan menghasilkan sebuah nilai index baru untuk menghemat ukuran dari array  dengan metode multiplicative/pengalian
            int hasil=(int)(Capacity*((key*ratio)%1)); //cukup lakukan perkalian atara index awal dengan ratio, lalu kalikan dengan kapasitas,kemudian ambil yg dibelakang koma saja.
        return hasil;//return kembaliannya
    }
}
    







