/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.e02;

import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAE02 {

    /**
     * 
     * standart saja lakukan bfs mulai dari start(yang akan diinput) jika
     * ada yg tidak terkunjungi maka ia tidak dpt dikunjugi karena tidak ada in dari start yg bisa kesana
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex=sc.nextInt();
        int edges=sc.nextInt();
        vertex++; //karena mulai dari 1
        Graph g=new Graph(vertex);
        
        for(int i=0;i<edges;i++){
            int dari=sc.nextInt();
            int ke=sc.nextInt();
            
            g.AddEdge(dari, ke);
        }
        
        int start=sc.nextInt();
        DFS dfs=new DFS(vertex,g);
        dfs.telusuriDFS(start);
        
        
        int print =0; //untuk keperluan format yang menyesuaikan dengna soal
        for(int i=1;i<vertex;i++){
            if(!dfs.kunjunganDFS[i]){
                if(print!=0){
                    System.out.print(" ");
                }
                print++;
                System.out.print(i);
            }
        }
        
        System.out.println();
        
    }
    
}


class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    protected int N;  // sebagai variable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
    
    public Graph(int N){
    this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
    this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
    }
    
    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
    }
    
}


class DFS   { // class
    Stack<Integer> stack =new Stack<Integer>(); // digunakan untuk menstack siapa parentnya
    int vertex; 
    boolean[] kunjunganDFS;
    int ctr=0;
    int order[];
    int parent[];
    int adjMatriks[][];
    
    public  DFS(int N ,Graph matriks) { //konstruktor class dfs
        this.vertex=N; // memasukan nilai vertex dengan variable parameter konstruktor
        this.adjMatriks=matriks.adjMatriks; //
        this.kunjunganDFS=new boolean[N];
        this.order=new int[N]; //array yang berisi urutan jalannya graph dengan dfs
        this.parent=new int[N]; // array yg berisi parent dari urutan ordernya
    }
    
    public int telusuriDFS (int start){
        
        if(ctr==0){ //jika belum ada yng mulai maka
            order[this.ctr]=start;// untuk start dilakukan dari 0;
            parent[this.ctr]=-1;  // dan parent==-1 sebagai penanda bahwa dia paling awal
            this.ctr++;
        }
        
        kunjunganDFS[start]=true; // dan sudah pernah dikunjungi karena jelas dia sebagai titik mulainya
        
        for (int i=0;i<vertex;i++){ //loop dari i sampai vertex untuk mencari siapa saja yg bertetangga
            
            if(adjMatriks[start][i]==1 && kunjunganDFS[i]==false ){ // jika bertetangga adj==1 dan belum pernah dikunjungi maka kunjungi
                parent[this.ctr]=start;
                order[this.ctr]=i;
                this.ctr+=1;
                kunjunganDFS[i]=true;
                
                stack.push(start);   //masukan kestack sebagai penanda jalannya
                stack.push(i);      //masukan kestack sebagai penanda jalannya untuk jika salah/ sudah ujung bisa tau kembali lagi lewat mana
                return telusuriDFS (i);
                
            }           
        }  
        
        
        if(stack.empty()){ // jika stack sudah kosong maka kembalikan -1 sebagai penanda bahwa bfs sudah habis
            return -1;
        }else {
            int temp=stack.pop(); // jika belum kosong maka keluarkan yg terakhir masuk sebagai pendanda untuk mengecek/ kembali lagi
            parent[ctr]=temp;
                    
       return telusuriDFS (temp);
        } 
    }
}