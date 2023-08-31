/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.disjoint;

import java.util.Arrays; //hanya membantu untuk print saja

/**
 *
 * @author Dimas Kurniawan
 */

public class DAADisjoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // test case terhadap disjoint set dengan soal quiz daa disjoint set
        disjointSets dj=new disjointSets(6);
        dj.union(1, 0);
        dj.union(2, 3);
        dj.union(0, 2);
        dj.union(1, 2);
        dj.union(4, 5);
        dj.union(3, 5);
        dj.union(1, 4);
        dj.union(1, 3);
        dj.union(3, 4);
        dj.union(0, 4);
        
        
        System.out.println(Arrays.toString(dj.parents));
        System.out.println(Arrays.toString(dj.ranks));
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
        parents[element]=parents[parents[element]];//jika belum maka satukan parent-parentnya dengan path compresion
        return findSets(parents[element]); //sekaligus menelusuri orang tuanya dengan cara rekursif satu satu menuju root
    }
}

public void union(int satu, int dua){ //lakukan penyatuan antara satu dan dua
        if (satu > dua) {
        int temp=satu;
        satu=dua;
        dua=temp;
    }
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




