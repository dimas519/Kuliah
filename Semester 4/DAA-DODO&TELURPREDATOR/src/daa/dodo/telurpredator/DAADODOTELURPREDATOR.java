/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.dodo.telurpredator;

/**
 *
 * @author Dimas Kurniawan
 */
import
import java.util.Scanner;
public class DAADODOTELURPREDATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        int size=sc.nextInt();
        ModularHashInteger<String> hash=new ModularHashInteger<String>(size);
        String perintah=sc.next();
        while (!perintah.equalsIgnoreCase("end")){
            if(perintah.equalsIgnoreCase("capture")){
                int pos=sc.nextInt();
                
                String jenis=sc.next();
                String output=hash.insert(pos, jenis);
                if(output!=null){
                    System.out.println("cell "+output);
                }else {
                    System.out.println("the camp is full");
                }
            }else if(perintah.equalsIgnoreCase("search")){
                int pos=sc.nextInt();
                String output=hash.search(pos);
                if(output!=null){
                    System.out.println("cell "+output);
                }else {
                    System.out.println("predator is not in the camp");
                }   
                
                
            }else if(perintah.equalsIgnoreCase("release")){
                int pos=sc.nextInt();
                String output=hash.delete(pos);
                if(output!=null){
                    System.out.println("predator is released from cell "+output);
                }else {
                    System.out.println("predator is not in the camp");
                }  
            }  
            
            
            
            perintah=sc.next();
        }
        System.out.println();
    }
}
   
abstract class HashTable<K,V>{
    protected Data[] table;
    protected int size;
    protected Data tombStone= new Data(null,null);
    double goldenRatio=0.61803398874989484820458683436564;

    
    private class Data{ //untuk mengimpan dalam bentuk data jadi ada idx setelah dihash(?) dan juga valuenya
        K key;
        V value;
        
        Data(K key, V value){ // sebagai sebuah tipe data yg akan menyimpan k dan v dalam array nantinya
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable (int size){ //sebuah konsturktor sebagia insialisasi ukuran dan arraynya
        this.size=size;
        this.table= (Data[]) new HashTable.Data[size];

    }

    abstract protected int hashing (K key);
    abstract protected int hash2 (K key);
    abstract protected int doubleHashing (int key ,int x ,int x2);
     
    public String insert (K Key, V value){ //methods yang memasukan value ke idx key dan jika sudah ada maka akan diquadratic probing sampai ketemu kosong atau samapai sudah terloop semua
        Data newData= new Data (Key ,value); //bikin dahulu tipe data dengan isinya keynya dan valuenya untuk dpt dimasukan ke array tipe tsb
        int hasilHash=hashing(Key);
        int hasilHash2=hash2(Key);
        int idx=0;
        String hasil=null;
        
        for(int i=0;i<size;i++){ //lakukan pencarian idx menggunakan quadraticProbing sampai ketemu yang kosong
            idx=doubleHashing(hasilHash,i,hasilHash2);
            if(this.table[idx]==null ||this.table[idx]==this.tombStone){ // jika sudah kosong
                this.table[idx]=newData;
                hasil= idx+" ("+(i+1)+")";
                return hasil;
            }
        }
        return hasil;// return false penanda jika dia tidak berhasil masuk dan sudah diloop pencarian quadratic sebanyak kapasitas dari arraynya
    }
    
    public String search(K pos){
        int hasilHash=hashing(pos);
        int hasilHash2=hash2(pos);
        int idx=0;
        String hasil=null;
        for(int i=0;i<size;i++){
            idx=doubleHashing(hasilHash,i,hasilHash2);
            if(this.table[idx]==null){
                return hasil;
            }else if(this.table[idx] != this.tombStone && this.table[idx].key.equals(pos)){
                hasil=idx+" ("+(i+1)+") <"+table[idx].value+">";
                return hasil;
            }
        }        
        return hasil;
    }

    public String delete (K pos){
        
        int hasilHash=hashing(pos);
        int hasilHash2=hash2(pos);
        int idx=0;
        String hasil=null;
         for(int i=0;i<size;i++){
             idx=doubleHashing(hasilHash,i,hasilHash2);
             if(this.table[idx]==null){
                 return hasil;
             }else if(this.table[idx]!=this.tombStone && this.table[idx].key.equals(pos)){ //jika nilai keynya pas dengan nilai key dan juga bukan bagian yg pernah dihapus maka
                hasil= idx+" ("+(i+1)+")";
                table[idx]=this.tombStone;
                return hasil; //kembalikan nilai yg tadi sudah diambil
            }
         }
        return hasil;
    }
    
    
 
}

class ModularHashInteger<V> extends HashTable<Integer,V>{

    public ModularHashInteger(int size) {
        super(size);
    }
    
    
    @Override
    protected int hashing(Integer pos){ //untuk mendapatkan alamat hashnya
        int hasil=(int)(this.size*((pos*this.goldenRatio)%1));
    return hasil;
        
    }
    
    @Override
    protected int hash2(Integer pos){
        int hasil= this.size-(pos%this.size);
        return hasil;
    }


    @Override
    protected int doubleHashing(int pos,int i,int h2){
        return (pos+(i*h2))%this.size;
    }






}







