/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daagraph;

import java.util.Stack;
import java.util.LinkedList;
/**
 *
 * @author Dimas Kurniawan
 */
public class DaaGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //        Graph g =new Graph(6); //menginsialisai sebuah graph dengan vertex 6
        
        Graph matriks =new Graph (12);
        
        //untuk 25-38 digunakan untuk masukan sebagai input parameter untuk mengisi adj matriks
        matriks.setArr(0,1);
        matriks.setArr(1,2);
        matriks.setArr(1,4);
        matriks.setArr(2,3);
        matriks.setArr(2,5);
        matriks.setArr(2,7);
        matriks.setArr(2,8);
        matriks.setArr(3,4);
        matriks.setArr(3,9);
        matriks.setArr(3,10);
        matriks.setArr(5,6);
        matriks.setArr(5,7);
        matriks.setArr(5,8);
        matriks.setArr(7,8);
        
        int start =0;  // start mulai dari-0

        
        DFS dfs=new DFS(12,matriks); //insisalisai class dfs dengan banyak vertex dan matriks ketetangaan
        dfs.telusuriDFS(start);//proses menelusuri dengan cara dfs(kedalam dahulu)
        dfs.printing(); // mengeluarkan hasil DFS
        
        BFS bfs=new BFS(12,matriks); // insisalisai class bfs dengan parameter banyak vertex dan matriks ketetanggan
        bfs.telusuriBFS(start); // mengeluarkan hasil BFs
        bfs.printing();
        
    
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
   
    public void printing(){ // methods untuk melihat apa saja hasil dair dfs dan diprint
        System.out.println("DFS: ");
        System.out.print("order: ");
        for(int i=0;i<ctr;i++){
            System.out.print(order [i]+" ");
        }
        System.out.println();
        System.out.print("parent: ");
        for(int i=0;i<ctr;i++){
            System.out.print(parent[i]+ " ");
        }
        System.out.println();
        
        
    }
}


class BFS {  //class bfs
     LinkedList<Integer> queue=new LinkedList<Integer>(); //linked list sebagai penanda jalan kalau sudah mentok maka kita kembali lagi kejalur awal
    int ctr=0;
    int order[]; //digunakan sama seperti bfs (sebagai array urutan dari node yg dikunjungi
    int parent[];// digunakan untuk mengetahui asal sebuah node
    int vertex; // jumlah vertex yg ada
    int arr[][]; // adjMatriks atau matriks ketetanggaan
    boolean check[];
    int ctrPar=0; // menentukan berapa jumlah parrentnya
    
    public BFS(int N,Graph Matriks) { //konstruktor yg digunakan seperti pada umumnya yaitu untuk mengisialisasi-inisialissi
        this.vertex=N; 
        this.arr=Matriks.adjMatriks;
        
        this.order=new int [N];
        this.parent=new int[N];
        this.check=new boolean[N];
        

    }
    
    
    public void telusuriBFS(int start){ // methods menelusuri dengan bfs apakah semua sudah pernah didatangi
        queue.add(start); // seperti pada sebelumnya penanda kalau dia pernah ke suatu tempat
        check[start]=true; //sebagai penanda kalau dia tentunya sudah pernah dikunjungi karena mulainya dari dia
        parent[ctrPar]=-1;//-1 sebagai anggapan bahwa belum punya parrent / dia rootnya
        ctrPar++;
        
        while (queue.size()>0){ //selama belum habis semua maka loop terus secara kesamping (jika digambarkan ke pohon
            prosesNode();
        }
    }
    
    
    public void prosesNode(){
       
       if (queue.size()>0){ // jika belum habis maka keluarkan lagi yg plg awal dimasukan
            int pos=queue.remove(); 
            order[ctr]=pos; //masukan ke array order sebagai tanda untuk kita dia dikunjungi pada ke brp
            ctr++;
        
            for (int i=1;i < vertex;i++){ 
                if(arr[pos][i]==1 && check[i]==false){ // jika masih punya tetangga dan belum pernah dikunjugi maka kunjugi dia (loop dengan kesamping kalau diarray
                    parent[ctrPar]=pos; // kalau masuk berarti yg sebelumnya sebagai parent
                    ctrPar++; 
                    queue.add(i); //masukan keantrian untuk antri dari dia bisa kesiapa lagi
                    check[i]=true;
                }
            }
        }   
    }
    
    
    public void printing(){ // methods  untuk melihat apa saja hasil  dari bfs dan diprint
        System.out.println("BFS: ");
        System.out.print("order: ");
        for(int i=0;i<ctr;i++){
            System.out.print(order [i]+" ");
        }
        System.out.println();
        System.out.print("parent: ");
        for(int i=0;i<ctr;i++){
            System.out.print(parent[i]+ " ");
        }
        System.out.println();
    } 
       

    
    
    
}