import java.util.Scanner;
public class DodoTetirah {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //scanner
        int kasus=sc.nextInt(); // input berapa test case yang akan dicoba
        
        
        
        for(int i=0;i<kasus;i++){ // loop sebanyak kasus
            int jKota=sc.nextInt(); // tiap kasus masukan jumlah kota
            int jJalan=sc.nextInt(); // tiap kasus masukan jumlah jalan
            Graph g = new Graph(jKota); // bikin sebuah graph dengan besar jkota
        
        for (int u=0;u<jJalan;u++){ //loopsebanyak jumlah jalan untuk digunakan sebagai input
            int kotaA=sc.nextInt(); //input dari kota maka
            int kotaB=sc.nextInt(); // tersambung dengan kota mana
            g.AddEdge(kotaA, kotaB);//berikan adj matriks kota yang terhubung
        }     
        g.process(); //proses kota mana saja yang dpt dijadikan tempat peristirahatan
        }
    }
    
}
 
class Graph{
     int N;   // jumlah kota yang ada
     int[][] adjMatriks; // adjecency matriks ketetanggaan
     boolean [] kemungkinan; // berisi boolean yang jika true maka termasuk dalam metropolitan( membentuk segitiga)
     
     public Graph(int N){
        this.N=N; // memasukan nilai ke variable yang sudah dibuat di world
        this.adjMatriks=new int[N][N]; // membuat array sebuah dengan baris dan kolom sebesar vertexnya
        this.kemungkinan=new boolean[N];
    }
     
     public void AddEdge(int v1,int v2){  //methods yang digunakan untuk menandakan ketetanggaan v1(vertex 1) dan v2(vertex 2)
        this.adjMatriks[v1][v2]=1;  // mengubah nilai menjadi 1 sebagai perwakilan dari true( ada ketetangaan)
        this.adjMatriks[v2][v1]=1; // karena 1 tegangga dengan 2 maka sudah pasti 2 tetangga juga dengan 1
    }
    
    public void process(){ //sebuah methods yang akan mengecek 1 per satu kota apakah ia termasuk dalam metropilitan apa tidak
        for(int i=0;i<N;i++){  //me looping semua kota yang ada
            int tetangga[]=new int[N]; //sebuah array yang akan berisi tetangga-tetangganya si kota-I
            int jumlahTetangga=cariTetangga(i,tetangga); //methods yang akan mengisi array tetangga dengan siapa saja tetangganya sekaigus mengembalikan jumlah tetangganya
            boolean logika=checker(jumlahTetangga,tetangga); // mengecek satu persatu tetangga apakah mereka juga terhubung satu dengan yang lain dengan parameter jumlah tetangga, dan arraynya tentunnya kemudian mengembalikan boolean sebagai penanda apakah ia jg metropolitan
            if(logika==true){ // jika metropolitan
                kemungkinan[i]=true; //maka set menjadi true sebagai pendanda bahwa metropolitan
            }
            
        }   
        print(); // panggil methods print untuk mengeluarkan output jika sudah semua kota di loop
    }
    
    private boolean checker(int x,int [] tetangga){ //
        boolean temp=false;  //set kota patokan sebagai false dahuli
        
        for(int i=0;i<x;i++){ //loop semua kota satu persatu apakah ada yang bertetangga
            for(int j=i+1;j<x;j++){
                int kiri=tetangga[i]; // masukan yang kiri ke variable untuk nantinya dicek
                int kanan=tetangga[j]; //masukan yabg kanan ke variable untuk parameter 
                
                
                if(adjMatriks[kiri][kanan]==1){ // cek apakah nilai array [kiri][kanan] == 1 yang menandakan bahwa mereka terhubung
                    temp=true; // jika terhubung maka kota asal juga metropolitan karena membentuk sebuah segitga
                    kemungkinan[kiri]=true; // kota kiri juga metropolitan 
                    kemungkinan[kanan]=true;   // kota kanan juga metropolitan
                }
            }
            
        }
    return temp; //kembalikan apakah kota asal termasuk metropolitan
    }
    
    private int cariTetangga(int kota,int [] tetangga){ //methods yang mencari siapa saja tetangga dari sebuah kota
        int o=0;
    for(int i=0;i<N;i++){ //looping semua kota secara kolom/ kesamping
        if(adjMatriks[kota][i]==1){ // jika adj bernilai 1 maka ia adalah tetangganya
            tetangga[o]=i; //jika if terpenuhi maka masukan kota tersebut dalam list(array)
            o++;
        }
    }
    return o; //kembalikan jumlah tetangganya
}
     
    private void print(){ // methods yang mengeprint 
        int jumlah=0; //jumlah print diset awalnya sebagai 0
        for(int i=0;i<N;i++){ //loop semua kemungkinan
            if(kemungkinan[i]==false){ // jika bernilai false maka ia bkn termasuk kota metropolitan sehingga dapat menjadi tempat istirahat
                if(jumlah!=0){ // jika sudah pernah ada jumlah output maka
                    System.out.print(" "); //print space(" ") sebagai pemisah
                }
                jumlah++; // tambahkan jumlah output
                System.out.print(i); //print siapa kota yang bisa dijadikan tempat istirahat
            
            }  
        }
        if(jumlah==0){ // jika tidak ada yang yang tidak metropolitan 
            System.out.print("Poor Dodo"); //maka print dodo
        }
        System.out.println(); // sebagai pemisah antar kasus
        
    }
    
}