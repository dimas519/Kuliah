/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.bfs;

import java.util.Stack;
import java.util.LinkedList;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAABFSBFS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Graph g =new Graph(6); //menginsialisai sebuah graph dengan vertex 6
        
        dfs dfs=new dfs(12);
        
        //untuk 21-29 digunakan untuk masukan sebagai input parameter untuk mengisi adj matriks
        dfs.setArr(0,1);
        dfs.setArr(1,2);
        dfs.setArr(1,4);
        
        dfs.setArr(2,3);
        dfs.setArr(2,5);
        dfs.setArr(2,7);
        dfs.setArr(2,8);
        
        
        dfs.setArr(3,4);
        dfs.setArr(3,9);
        dfs.setArr(3,10);
        
        dfs.setArr(5,6);
        dfs.setArr(5,7);
        dfs.setArr(5,8);
        
        dfs.setArr(7,8);
        
        int start =0;
        
        System.out.println(start);
        dfs.telusuriDFS(start);
     
        
    }
    
}


class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    int N;  // sebagai variable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    int[][] adjMatriks; // adjecency matriks ketetanggaan
    
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
    
//    public void AddEdge(int v1,int v2,int bobot){  //methods yang digunakan untuk menandakan ketetanggan namun kali ini setiap edges memiliki bobotnya masing masing
//        this.adjMatriks[v1][v2]=bobot; // mengubah array matriks menjadi nilai bobot sebagai penanda bawah ada nilai (tidak 0 ) maka ada tetangga
//        this.adjMatriks[v2][v1]=bobot;  // sama seperti line 46, namun harusnya jaraknya/ bobotnya sama karena ketetanggannya sama
//    }
//    
//    public void removeEdge(int v1,int v2){  // methods yang digunakan untuk menghapus ketetanggaan v1(vertex1) dan v2(vertex2)
//        this.adjMatriks[v1][v2]=0;   //mengubah nilai array menjadi 0 karena ketetanggaannya sudah dihapus (0 sebagai perwakilan dari false)
//        this.adjMatriks[v2][v1]=0; // sama seperti sebelumnya, jika kita mau menghapus maka wajib untuk menghapus keduanya tidak boleh salah satu saja.
//    }
//    
//    public int isEdgeExist(int v1,int v2){ // methods yang mengecek apakah edges tersebut ada dengan kembalian berupa nilai dari array jika 0 maka tidak bertetangga sedangkan jika != 0 maka ada ketetanggaan
//        return this.adjMatriks[v1][v2];  //mereturn sesuai dengan methods
//    }
}

class dfs extends Graph{
    Stack<Integer> stack =new Stack<Integer>();
    int arrDFS[][];
    int vertex;
    boolean[] kunjunganDFS;
    int ctr=0;
    int order[];
    int parent[];
    
    
    public  dfs (int N) {
        super(N);
        this.vertex=N;
        this.kunjunganDFS=new boolean[N];
        this.arrDFS=adjMatriks;
        this.order=new int[N];
        this.parent=new int[N];
    }
    
    
    public int telusuriDFS (int start){
        kunjunganDFS[start]=true;
        for (int i=0;i<vertex;i++){
            
            if(arrDFS[start][i]==1 && kunjunganDFS[i]==false ){
                order[this.ctr]=i;
                this.ctr+=1;
                System.out.println(i);
                kunjunganDFS[i]=true;
                
                arrDFS[start][i]=0;
                arrDFS[i][start]=0;
                stack.push(start);
                stack.push(i);
                return telusuriDFS (i);
            }           
        }      
        if(stack.empty()){
            return 0;
        }else {
            int temp=stack.peek();         
       return telusuriDFS (stack.pop());
        } 
    }
    

   
    
        
        
        
        
        

    
    
    
}