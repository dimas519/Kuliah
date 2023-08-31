/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.dodo.boardgame;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAADODOBoardGame {

    /**
     * catatan untuk masukan baris harap dikonversi dahulu menjadi ABCD
     * a=0
     * b=1
     * c=2
     * d=3
     * 
     * 
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        n=4;
        
        String perintah=sc.next();
        ModularHashInteger<String> hash=new ModularHashInteger<String>(n);
        
        while (!perintah.equalsIgnoreCase("end")){

            
            if(perintah.equalsIgnoreCase("insert")){
                int iDodo=sc.nextInt();
                
                for(int i=0;i<iDodo;i++){
                    String pos=sc.next();
                    String hasil=hash.insert(pos, "dodo");
                    if(hasil==null){
                        System.out.println("full");
                    }else{
                        System.out.println(hasil);
                    }
                }
                int jWombat=sc.nextInt();;
                for(int i=0;i<jWombat;i++){
                    String pos=sc.next();
                    String hasil=hash.insert(pos, "wombat");
                    if(hasil==null){
                        System.out.println("full");
                    }else{
                        System.out.println(hasil);
                    }
                }
            } else if(perintah.equalsIgnoreCase("search")){ //karena cuma 2 maka dipastikan release
                 int iDodo=sc.nextInt();
                for(int i=0;i<iDodo;i++){
                    String pos=sc.next();
                    String Hasil=hash.search(pos);
                    if(Hasil!=null){
                        System.out.println(Hasil);
                    }else{
                        System.out.println("not found");
                    }
                }
                int jWombat=sc.nextInt();;
                for(int i=0;i<jWombat;i++){
                    String pos=sc.next();
                    String Hasil=hash.search(pos);
                    if(Hasil!=null){
                        System.out.println(Hasil);
                    }else{
                        System.out.println("not found");
                    }
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
    
    private class Data{ //untuk mengimpan dalam bentuk data jadi ada idx setelah dihash(?) dan juga valuenya
        K key;
        V value;
        
        Data(K key, V value){ // sebagai sebuah tipe data yg akan menyimpan k dan v dalam array nantinya
            this.key=key;
            this.value=value;
        }
    }
    
    public HashTable (int capacity){ //sebuah konsturktor sebagia insialisasi ukuran dan arraynya
        this.size=size;
        this.table= (Data[]) new HashTable.Data[size];
    }
    
    
    abstract protected int HashFunction (K key,int i); //sebagai pengisi nantinya akan dipakai hash function yg mana
    
      public String insert (K Key, V value){ //methods yang memasukan value ke idx key dan jika sudah ada maka akan diquadratic probing sampai ketemu kosong atau samapai sudah terloop semua
        Data newData= new Data (Key ,value); //bikin dahulu tipe data dengan isinya keynya dan valuenya untuk dpt dimasukan ke array tipe tsb
        int idx=0;
        String hasil=null;
        
        for(int i=0;i<this.size;i++){ //lakukan pencarian idx menggunakan quadraticProbing sampai ketemu yang kosong
            idx=HashFunction(Key,i);
            if(this.table[idx]==null ||this.table[idx]==this.tombStone){ // jika sudah kosong
                this.table[idx]=newData;
                hasil= idx+" ("+(i+1)+")";
                return hasil;
            }
        }
        return hasil;// return false penanda jika dia tidak berhasil masuk dan sudah diloop pencarian quadratic sebanyak kapasitas dari arraynya
    }
      
      public String search(K pos){

        int idx=0;
        String hasil=null;
        for(int i=0;i<size;i++){
            idx=HashFunction(pos,i);
            if(this.table[idx]==null){
                return hasil;
            }else if(this.table[idx] != this.tombStone && this.table[idx].key.equals(pos)){
                hasil=idx+" ("+(i+1)+")";
                return hasil;
            }
        }        
        return hasil;
    }
    
    
}

class ModularHashInteger<V> extends HashTable<String,V>{

    public ModularHashInteger(int size) {
        super(size);
    }
    
    
    @Override
    protected int HashFunction(String pos,int i){ //untuk mendapatkan alamat hashnya
        int lantai=(int)Math.pow((int)pos.charAt(0),2);
        int kolom=(int)pos.charAt(1)-48;
        int hasil=(lantai+kolom+i)%16;//karena banyak kotak 16
    return hasil;
        
    }
    








}
    
    
    
    
    
    
    

