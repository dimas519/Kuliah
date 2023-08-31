/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daawomwanted2;
 
/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAWomWanted2 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        int fakta=sc.nextInt();
        
        Graph g=new Graph(banyak);
        
        for(int i=0;i<fakta;i++){
            int dari=sc.nextInt();
            int ke=sc.nextInt();
            
            g.AddEdge(dari, ke);
        }
        
        g.loop();
        int cari=sc.nextInt();
        boolean logic=true;
        
        for(int i=0;i<banyak;i++){  
            System.out.println(g.kemungkinan[i]);
        if(g.kemungkinan[i]==1){    
            
            if(i!=cari){
            logic=false;
            }
        }
        
        }
        
        
        
        if(logic){
            System.out.println("wanted");
        }else {
            System.out.println("intermediary");
        }
        
        
    }
    
}
 
 
class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
    protected int N;  // sebagai varqqqqqqqqqqqqiable world yang kemudian akan diisi dikonstruktor berapa jumlah vertexnya
    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
    public int[] tetangga;
    public int[] in;
    public int[] out;
    
    public int[] kemungkinan;
    
    public Graph(int N){
    this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
    this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
    this.tetangga=new int[N];
    this.in=new int[N];
    this.out=new int[N]; 
    this.kemungkinan=new int[N];
    }
    
    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
        in[v2]++;
        out[v1]++;  
    }
    
    public void loop(){
        for(int x=0;x<N;x++){
                logic(x);
        }
    
    }
    
    //kalau 3 berarti kemungkinan start nya
    //kalau 2 berarti kemungkinan terpisah
    public void logic(int x){
        if (in[x]==0 && out[x]==0){
            kemungkinan[x]=2;
        } else if(in[x]==0){
            kemungkinan[x]=3;
        }else if(out[x]==0){
            kemungkinan[x]=1;
        }
        
        
        
        
        
        
    }
    
    
    
    
    
    
}