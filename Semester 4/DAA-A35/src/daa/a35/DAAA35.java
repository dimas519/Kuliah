/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.a35;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAA35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex=sc.nextInt();
        int edges=sc.nextInt();
        
        Graph g=new Graph(vertex);
        
        for(int i=0;i<edges;i++){
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            
            g.AddEdge(v1,v2);
                    
        }
        
        for(int i=0;i<vertex;i++){
            int spasi=0;
            for(int j=0;j<vertex;j++){
                if(spasi!=0){
                    System.out.print(" ");
                }
                if(g.adjMatriks[i][j]==1){
                    System.out.print("T");
                }else {
                    System.out.print("F");
                }
                spasi++;
                
            }
            System.out.println("");
        }
        
        System.out.println();
         for(int i=0;i<vertex;i++){
            int spasi=0;
            for(int j=0;j<vertex;j++){
                if(spasi!=0){
                    System.out.print(" ");
                }
                if(g.adjMatriks[j][i]==1){
                    System.out.print("T");
                }else {
                    System.out.print("F");
                }
                spasi++;
                
            }
            System.out.println("");
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
    
    
    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
    }
    
    
    
    
    
    
}
    
