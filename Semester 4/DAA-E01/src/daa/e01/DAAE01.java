//package daa.e01;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
 
 
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAE01 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int node=sc.nextInt(); // ada berapa banyak node
        disjointSets ds=new disjointSets(node+1); //insisalisasi disjoint sets mengenai ada berapa node
 
        
        int hub=sc.nextInt();
        for(int i=0;i<hub;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            ds.union(a, b); //masukan keterhubungan keduanya
        }
        
        boolean check[]=new boolean[node+1];
        
        for(int i=0;i<node+1;i++){ //menghitung dengan cara root nya saja yang diganti setiap root yg beda menandakan dia beda pohon
            int x=ds.findSets(i);
//            System.out.println(x);
            check[x]=true;
        }
            int counter=0;
        for(boolean j:check){ //untuk setiap jenis dicek ada berapa yg beda tambahkan terus setiap beda
            if(j){
                counter++;
            }
        }
       
//        System.out.println();
        System.out.println(counter-1); //kurangi 1 karena tidak ada index1
 
    
    }
}
 
 
class disjointSets { //class disjoin yang memiliki atribut parents,ranks ,numOfelement
int [] parents; //yang menyimpan siapa parentnya jika dia loop maka dia yg "tertua"
int [] ranks; //ranks menyimpan upperbound dari tinggi"
int numOfElements; //yang menyatakan ada berapa vertex / node
 
disjointSets(int numOfElements){ // construktor disjoint set dengan path Compresion
    this.numOfElements=numOfElements;
    this.parents=new int[numOfElements];
    this.ranks=new int[numOfElements];
    for(int i=0;i<numOfElements;i++){
        this.parents[i]=i;
        this.ranks[i]=0;
    }
}
    
public int findSets(int element){ // yang akan mengembalikan
    if(parents[element]==element){ // jika sudah diroot ditandai dengan parent dari element maka element itu sendiri maka tandanya sudah tertua
        return element;
    }else {
        //parents[element]=parents[parents[element]];//jika belum maka satukan parent-parentnya dengan path compresion
        return findSets(parents[element]); //sekaligus menelusuri orang tuanya dengan cara rekursif satu satu menuju root
    }
}
 
public void union(int satu, int dua){ //lakukan penyatuan antara satu dan dua
    int p1 =findSets(satu); //lakukan penelusuran mencari 'tertua' di satu
    int p2 =findSets(dua); //lakukan penelusuran mencari 'tertua' di dua
    if (p1!=p2){ //jika mereka beda orang tua maka bisa disatukan
            if(ranks[p1]>=ranks[p2]){ //cari rank yang paling sedikit
                parents[p2]=p1; //satukan orang tuanya dengan cara pohon paling sedikit dijadikan anak dari pohon yang banyak
                ranks[p1]++; //tambahkan rank yg banyak dengan 1 karena ketambahan anak 1
            }else{ //begitu pula sebaliknya
                parents[p1]=p2;
                ranks[p2]++;
            }
        //System.out.println("berhasil");
        //System.out.println(Arrays.toString(parents));
 
    }else{
//        System.out.println("sama"); //dapat dipergunakan untuk menghitung ada berapa banyak yang membuat loops
    }
 }
}