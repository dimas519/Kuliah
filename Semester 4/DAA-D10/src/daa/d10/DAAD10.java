/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package daa.d10;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Stack;
public class DAAD10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        
        int arr[][]=new int[banyak][banyak];
        
        for(int i=0;i<banyak;i++){
            for(int j=0;j<banyak;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        
        boolean pernah[]=new boolean[banyak]; 
        
        boolean loop=true;
        
        while (loop){
            int start=0;
            for(int i=0;i<banyak;i++){
                if(!pernah[i]){
                    start=i;
                     break;
                }
            }
            
        DFS dfs=new DFS(banyak,arr);
        dfs.telusuriDFS(start);
        dfs.printing();
        
        for(int x:dfs.order){
            pernah[x]=true;
        }
            boolean semua=true;
        for(boolean y:pernah){
            if(!y){
                semua=false;
                break;
            }
        }
        
        if(semua){
            loop=false;
        }else{
            System.out.print(" ");
        }
        
        
        }
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
    
    public  DFS(int N ,int[][] matriks) { //konstruktor class dfs
        this.vertex=N; // memasukan nilai vertex dengan variable parameter konstruktor
        this.adjMatriks=matriks; //
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
                    
       return telusuriDFS (temp);
        } 
    }
    public void printing(){ // methods untuk melihat apa saja hasil dair dfs dan diprint

        for(int i=0;i<ctr;i++){
            System.out.print(parent[i]+ " ");
        }
        
        
    }
    
}


