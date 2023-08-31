/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d16;

/**
 *
 * menggunakan class graph dan class lainnay sebagai pembantu
 * class pembantu ini berfugnsi untuk mencari siapa saja teman Wimo
 * jika 1 teman saja ketemu maka semuanya teman wimo langsung diambil sebagai 
 * kenalan dan temannya diset sebagai kode dari teman.
 * 
 * jika adj/ ketetangaan terkoneksi dengan wimo maka ia teman.
 * dan jika ia termasuk dari teman nya teman wimo maka ia kenalan
 * 
 * 
 * 
 *  
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Stack;
public class DAAD16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wombat=sc.nextInt();
        int relasi=sc.nextInt();
        Graph g=new Graph(wombat);
        
        for(int i=0;i<relasi;i++){
            int satu=sc.nextInt();
            int dua=sc.nextInt();
           
            g.AddEdge(satu, dua);
        }
        
      kenalan k=new kenalan(g);
      k.penandaan();
      
        System.out.println("0 Wimo"); // dipastikan wimo sendiri
      for(int i=1;i<wombat;i++){
          if(g.adjMatriks[0][i]==1){
              System.out.println(i+" teman"); //jika dia 1 maka temannya wimo
          }else if(k.arrayKenal[i]){
            System.out.println(i+" kenalan"); //jika dia ada dalam list teman wimo maka dia kenalan
          }else {
              System.out.println(i+" bukan kenalan");
      }
      }
        
        
        
        
        
    }
    
}

class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    protected int N;  // sebagai variable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
    
    public Graph(int N){
    this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
    this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
    }
    
    public void AddEdge (int v1,int v2){
        setArr(v1,v2);
    }
    
    public void setArr (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
        this.adjMatriks[v2][v1]=1; // karena 1 tegangga dengan 2 maka sudah pasti 2 tetangga juga dengan 1
    }
    
}


class kenalan{
    protected int banyak;
    boolean arrayKenal[];
    int adjMatriks[][];
    
    public kenalan(Graph matriks){
        this.banyak=matriks.N;
        this.arrayKenal=new boolean[banyak];
        this.adjMatriks=matriks.adjMatriks;
    }
    
    
    public void penandaan(){
        for(int i=0;i<banyak;i++){ //lakukan loop semua orang terhadap wimo
            if(adjMatriks[0][i]==1){ //jika ada yg menjadi teman wimo
                for(int j=0;j<banyak;j++){ //maka ambil semua yang menjadi teman wimo
                    if(adjMatriks[i][j]==1){
                        arrayKenal[j]=true;
                    }
                }
            }
        }        
    }
}

