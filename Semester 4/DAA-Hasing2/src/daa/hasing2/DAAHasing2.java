/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.hasing2;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAHasing2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ModularHashInteger<String> hash=new ModularHashInteger<String>(11,3,2);
        hash.insert(5,"Alice");
        hash.insert(16,"Bob");
        hash.insert(27,"Charlie");
        
        hash.delete(16);
        
        System.out.println(hash.search(5));
        System.out.println(hash.search(16));
        System.out.println(hash.search(27));
        
        
    }
    
}

abstract class HashTable<K,V>{
    protected Data[] table;
    protected int capacity;
    protected double c1,c2;
    protected Data tombStone= new Data(null,null);

    
    private class Data{ //untuk mengimpan dalam bentuk data jadi ada idx setelah dihash(?) dan juga valuenya
        K key;
        V value;
        
        Data(K key, V value){ // sebagai sebuah tipe data yg akan menyimpan k dan v dalam array nantinya
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable (int capacity,double c1,double c2){ //sebuah konsturktor sebagia insialisasi ukuran dan arraynya
        this.capacity=capacity;
        this.table= (Data[]) new HashTable.Data[capacity];
        this.c1=c1;
        this.c2=c2;
    }
    
    abstract protected int HashFunction (K key); //abstract methods untuk dapat dibuat di class anaknya
    abstract protected int quadraticProbing (int k0,int i); 
    
    public boolean insert (K Key, V value){ //methods yang memasukan value ke idx key dan jika sudah ada maka akan diquadratic probing sampai ketemu kosong atau samapai sudah terloop semua
        Data newData= new Data (Key ,value); //bikin dahulu tipe data dengan isinya keynya dan valuenya untuk dpt dimasukan ke array tipe tsb
        int k0=this.HashFunction(Key); // cari berapa hashnya
        int idx=0; 
        for(int i=0;i<this.capacity;i++){ //lakukan pencarian idx menggunakan quadraticProbing sampai ketemu yang kosong
            idx=this.quadraticProbing(k0,i);
            if(this.table[idx]==null){ // jika sudah kosong
                this.table[idx]=newData; //maka langsung masukan saja datanya
                return true;// dan return true sebagai penanda bahwa dia berhasil masuk
            }
        }
        return false;// return false penanda jika dia tidak berhasil masuk dan sudah diloop pencarian quadratic sebanyak kapasitas dari arraynya
    }
    
    public V delete(K key){ // methods delte yang berfungsi mengkosongkan key dan valuenya saja tanpa menghapus pointernya
        int k0=this.HashFunction(key); //tetap lakukan hashing awal
        int idx;
        for(int i=0;i<this.capacity;i++){ // lakukan loop sebanyak yang diperlukan sampai kondisi ditemui
            idx=this.quadraticProbing(k0,i); //jika sudah menemui array yg kosong maka cukup return null saja karena sudah keluar dari index
            if(this.table[idx]==null){
                return null;
            } else if(this.table[idx].key.equals(key)){ //jika nilai keynya pas dengan nilai key dan juga bukan bagian yg pernah dihapus maka

                V Result=this.table[idx].value; //ambil dahulu berapa nilainya untuk pada akhirnya akan dikembalikan
                this.table[idx]=this.tombStone; //buat idx yang tadi menjadi null namun dengan ditandai sebagai yg sudah pernah dihaspus
                return Result; //kembalikan nilai yg tadi sudah diambil
            }
        }
            return null;    // return false penanda jika dia tidak berhasil masuk dan sudah diloop pencarian quadratic sebanyak kapasitas dari arraynya
    }
    
    public V search(K key){ //methods yang mencari apakah ada sebuah nilai yang 
         int k0=this.HashFunction(key); //cari dahulu brp hash nya
         int idx;
         for(int i=0;i<this.capacity;i++){ // lakukan loop sampai ketemu atau sampai sebanyak kapasitas
            idx=this.quadraticProbing(k0,i); //cari nilai hash quadratic jika sudah ada maka bisa langsung ditandaai dengan i=0
            if(this.table[idx]==null){ //jika ketemu null maka kembalikan null karena sudah terloop atau terjadi pengulangan
                return null;
            } else if(this.table[idx]!=this.tombStone &&this.table[idx].key.equals(key)){ //jika sudah ketemu yang  nilainya sma dengan key pada data sma dengan key paramete nya maka
                V result=this.table[idx].value; //maka kembalikan value pada data yang ada data(tipe data)
                return result;
            }
        }
    return null; //return null jika semua sudah terloop dan masih belum ditemukan
    }
}

class ModularHashInteger<V> extends HashTable<Integer,V>{
    public ModularHashInteger(int capacity, double c1, double c2){
        super(capacity,c1,c2);
    }
    

    @Override
    protected int quadraticProbing(int k0,int i){  //untuk menghitung berapa quadraticprobing yang akan digunakannya
        return ((int) (k0+this.c1*i+ this.c2*i*i)) %this.capacity;
    }

  
    protected int HashFunction(Integer key) { //untuk menghitung awal brp hasingnya
        return key%this.capacity;
    }
}

