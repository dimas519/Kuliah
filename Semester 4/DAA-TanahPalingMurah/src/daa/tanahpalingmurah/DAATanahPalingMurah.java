/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.tanahpalingmurah;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
public class DAATanahPalingMurah {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baris=sc.nextInt();
        int kolom=sc.nextInt();
        
//        Graph g=new Graph (baris,kolom);

        int jsumur=sc.nextInt();
        int xSumur[]=new int[jsumur];
        int ySumur[]=new int[jsumur];
        
        for(int i=0;i<jsumur;i++){
            int kolom1=sc.nextInt();
            int baris1=sc.nextInt();
            xSumur[i]=baris1;
            ySumur[i]=kolom1;
            
            
//            g.AddEdge(kolom1,baris1);
            }
        
        perhitungan p=new perhitungan(xSumur,ySumur,baris,kolom,jsumur);
        
        p.count();
        
    }
    
}

/*logika yang digunakan adalah dengan mencari apakah semua  jaraknya (dari sumur ke titik )sama jika sama maka
kemungkinan itu yang paling jauh sehingga menggunakan array boolean


*/
class perhitungan{
    int baris;
    int kolom;
    int xsumur[];
    int ysumur[];
    int banyak;
    int arr[][];
    boolean kemungkinan[][];
    public perhitungan(int xsumur[],int ysumur[],int baris,int kolom,int banyak){
        this.baris=baris;
        this.kolom=kolom;
        this.xsumur=xsumur;
        this.ysumur=ysumur;
        this.banyak=banyak;
        this.arr=new int[baris][kolom];
        this.kemungkinan=new boolean[baris][kolom];
    }
    public void count() {
        int posX=xsumur[0];
        int posy=ysumur[0];
        
        for(int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){
                arr[i][j]=Math.abs(posX-i)+Math.abs(posy-j);
            }
        }
        
        
        
    for (int c=1;c<banyak;c++){
        posX=xsumur[c];
        posy=ysumur[c];
        
        for(int i=0;i<baris;i++){
            for(int j=0;j<kolom;j++){

                int jarak=Math.abs(posX-i)+Math.abs(posy-j);
                if(jarak!=arr[i][j]){
                    kemungkinan[i][j]=true;
                }
            }
        }
    }
    
    
    for(int i=0;i<baris;i++){
        for (int j=0;j<kolom;j++){
            System.out.print(kemungkinan[i][j]);
        }
        System.out.println();
    }
    
    
    
    }

}






//
//class Graph  {  //class graph dengan masukan dipastikan sebuah angka khsusunya integer
//    protected int baris;
//    protected int kolom;
//    protected int[][] adjMatriks; // adjecency matriks ketetanggaan
//    
//    public Graph(int Baris,int Kolom){
//    this.baris=Baris; // memasukan nilai ke variable yang sudah dibuat di world
//    this.kolom=Kolom;
//    this.adjMatriks=new int[Baris][Kolom]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
//    }
//    
//    
//    public void AddEdge (int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
//        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan
//    }
//    
//
//}

