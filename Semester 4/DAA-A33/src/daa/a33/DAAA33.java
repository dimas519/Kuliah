/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.a33;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAA33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
        
        int vertex=sc.nextInt();
        int edges=sc.nextInt();
        
        Graph g=new Graph(vertex);

        for(int i=0;i<edges;i++){
            int satu=sc.nextInt();
            int dua=sc.nextInt();
            
            g.AddEdge(satu,dua); //memasukan edges dari mana ke mana
        }

        int cari=sc.nextInt();
        
        DFS d=new DFS(vertex,g); 
        
        d.telusuriDFS(cari); //logikanya dapat ditelusuri dengan dfs dari tujuan akhir apakah ada leaf lain selain dia
        
        
        boolean check=true; 
        
        for(boolean logic: d.kunjunganDFS){ //jika adaterdapat leaf lain maka dia bukan ujung satu satunay saja
            if(!logic){
                check=logic;
            }
        }
        
        if(check){
            System.out.println("sink");
        }else {
            System.out.println("bukan sink");
        }
        
       
        
    }
    
}


class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    protected int N;  // sebagai variable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
    public int[] tetangga;
    
    public Graph(int N){
    this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
    this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
    this.tetangga=new int[N];
    }
    
    
    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        if(v1!=v2){
        this.adjMatriks[v2][v1]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
        }
    }
    
}



class DFS   {
    Stack<Integer> stack =new Stack<Integer>();
    int vertex;
    boolean[] kunjunganDFS;
    public int ctr=0;
    int order[];
    int adjMatriks[][];
    
    public  DFS(int N ,Graph matriks) { //konstruktor class dfs
        this.vertex=N; // memasukan nilai vertex dengan variable parameter konstruktor
        this.adjMatriks=matriks.adjMatriks; //
        this.kunjunganDFS=new boolean[N];
        this.order=new int[N];
    }
    
    public int telusuriDFS (int start){
        
        if(ctr==0){
            order[this.ctr]=start;// untuk start dilakukan dari 0;
            this.ctr++;
        }
        
        kunjunganDFS[start]=true;
        
        for (int i=0;i<vertex;i++){
            
            if(adjMatriks[start][i]==1 && kunjunganDFS[i]==false ){
                order[this.ctr]=i;
                this.ctr+=1;
                kunjunganDFS[i]=true;
                
                stack.push(start);
                stack.push(i);
                return telusuriDFS (i);     
            }           
        }         
        if(stack.empty()){
            return -1;
        }else {
            int temp=stack.pop();
//            System.out.println(order[ctr-1]);
//            System.out.println(temp);  
       return telusuriDFS (temp);
        } 
    }

}