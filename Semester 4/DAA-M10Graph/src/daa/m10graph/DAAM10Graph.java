/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.m10graph;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAAM10Graph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int rumah=sc.nextInt(); //masukan rumah pertama
        int terowongan=sc.nextInt(); // masukan jumlah terowongan
        
        Prim p=new Prim(rumah+1);
        int graph[][]=new int[rumah+1][rumah+1];
        for(int i=1;i<=terowongan ;i++){
            int x=sc.nextInt()-1;
            int y=sc.nextInt()-1;
            int bobot=sc.nextInt();
            
            graph[x][y]=bobot;
            graph[y][x]=bobot;
        }
        
        int x=p.primAlgo(graph);
        System.out.println(x);
        
       
    }
    
}
class Prim {
    int Vertex;
    public Prim(int Vertex){
        this.Vertex=Vertex;
    }
    
    public int findmin(int[] value,boolean[] terhubung){
              

            return idx;
    }


  
    public int primAlgo(int [][] graph){
        boolean terhubung[]=new boolean[Vertex];
        int parent[]=new int[Vertex];
        int value[] = new int[Vertex]; // sebagai penanda dia itu parentnya siapa dan nilai nya berapa prim baris 0 sebagai orang tua dan 1 sebagai nilai
        

        for (int i = 0; i < Vertex; i++) {
            value[i] = Integer.MAX_VALUE; //set dahulu semuanya ketakhingga
            terhubung[i]=false;
        }
        value[0]=0;
        parent[0]=-1; //karena diawal maka set sebagai -1

        for (int j= 0; j < Vertex-1; j++) { //loop semua edgesnya  

              int min=Integer.MAX_VALUE;//set max dan min untuk pencarian
                int idx=-1;
            for (int b = 0; b < Vertex; b++){ //loop semua dan cari yg terkecil di pq kalaau kelas)

                if (terhubung[b]==false && value[b]<min) {//cari yg paling kecil untuk diambil
                    min = value[b];
                    idx=b;                    
                }
           }
            
                  terhubung[idx] = true; //lalu ambil dengan dia 
                for (int x=0;x<Vertex;x++){ //dan lakukan loop kepada semua yg berhubungan dengan dia yg belum diambil dan lebih kecil dari yg sudah pernah ada
                    if (graph[idx][x] != 0 && terhubung[x] == false && graph[idx][x] < value[x]) {
                        parent[x] = idx; //set diapa parentnya
                        value[x] = graph[idx][x]; //set brp nilainya
                    }
                }
        }
           int total=0; //set sebagai 0
            for (int i = 1; i < Vertex; i++){ //jika loop semua mulai dari 1 karena 0 tidak dihitung
                total=total+graph[i][parent[i]]; //ambil semua yg ada dibaris 1 sampai akhir dengan colom sesuai perentnya
            }
            return total; //output total
    }


}