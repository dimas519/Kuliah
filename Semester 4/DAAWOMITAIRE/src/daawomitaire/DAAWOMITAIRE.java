/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daawomitaire;

import java.util.Stack;
import java.util.Scanner;
/**
 *
 * @author Dimas Kurniawan
 */
public class DAAWOMITAIRE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex=sc.nextInt(); //banyaknya teman
        int kasus=sc.nextInt(); //banyaknya berita yang tersebar
        
        
        vertex++;
        Graph g=new Graph(vertex);
        
        for(int i=0;i<kasus;i++){
            int dari=sc.nextInt(); //berita tersebut tersebar dari 
            int ke=sc.nextInt();//berita/gosip menyebar ke
            
            
            g.AddEdge(dari, ke); //masukan atau modelkan kedalam bentuk graph
        }
        int mulai=sc.nextInt(); //awal mulanya siapa yang tahu gosip tersebut
        
        DFS d=new DFS(vertex,g); //insisalisai kelas dfs untuk mencari siapa saja yang dpt berita /gosip
        d.telusuriDFS(mulai); // lakukan prosesnya dari mulai mulut siapa yg mulai ditelusuri 1 persatu
        
        
        int print=0; // untuk membantu dalam menyesuaikan print agar sesuai dengan soal/ yg diminta
        for(int i=1;i<vertex;i++){ // cek semua orang apakah ia menerima infonya
            boolean dapat=d.kunjunganDFS[i]; //dengan cara dimasukan kesebuah variable
            
            if(!dapat){ //kemudian variable tersebut di cek jika tidak dpt maka print(sesuai dengan permintaan dari soal )
                if(print!=0){ // menyesuaikan dengan permintaan soal (tiap keluaran dipisahkan spasi tanpa kelebihan spasi
                    System.out.print(" ");
                }
                print++;
                System.out.print(i);
            }
            
            
            
        }
        System.out.println(); // sesuai dengan soal akhir selalu bikin baris baru
        
        
        
    }
    
}






class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    protected int N;  // sebagai varqqqqqqqqqqqqiable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
    public int[] tetangga;
    
    public Graph(int N){
    this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
    this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
    this.tetangga=new int[N];
    }
    
    
    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
    }
    
}



class DFS   {
    Stack<Integer> stack =new Stack<Integer>();
    int vertex;
    boolean[] kunjunganDFS;
    int ctr=0;
    int order[];
    int adjMatriks[][];
    
    public  DFS(int N ,Graph matriks) { //konstruktor class dfs
        this.vertex=N; // memasukan nilai vertex dengan variable parameter konstruktor
        this.adjMatriks=matriks.adjMatriks; //
        this.kunjunganDFS=new boolean[N];
        this.order=new int[N];
    }
     public int telusuriDFS (int start){
        if(ctr==0){ //jika belum ada yng mulai maka
            order[this.ctr]=start;// untuk start dilakukan dari 0;
            this.ctr++;
        }
        kunjunganDFS[start]=true; // dan sudah pernah dikunjungi karena jelas dia sebagai titik mulainya
        for (int i=0;i<vertex;i++){ //loop dari i sampai vertex untuk mencari siapa saja yg bertetangga
            if(adjMatriks[start][i]==1 && kunjunganDFS[i]==false ){ // jika bertetangga adj==1 dan belum pernah dikunjungi maka kunjungi
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
        return telusuriDFS (temp);
        } 
    }
    
   
    
}