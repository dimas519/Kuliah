
/**
 *
 * @author Dimas-MSI
 *
 */

public class PencarianKecamatan {
    public static void main(String[] args) {
        KotaBandung kecamatan= new KotaBandung();
        Tools tools=new Tools();
        int[] ketetanggaan = kecamatan.getMatriksJumlahKetetanggaan();
        int[] ketetanggaancpy=kecamatan.getMatriksJumlahKetetanggaan();
        int[] idx=tools.getIdx(kecamatan.getJumlahKecamatan());
        tools.insertion(ketetanggaan,idx,kecamatan.getJumlahKecamatan());
        ColorGraph pewarnaan=new ColorGraph(kecamatan.getJumlahKecamatan());
        boolean loop=true;
        int i=0;
        int idxMax=Integer.MIN_VALUE;
        int Max=Integer.MIN_VALUE;
        int maxPenduduk=Integer.MIN_VALUE;
        while (loop){
            System.out.println(pewarnaan.getColor(i)+" :");  
            int kelompok[]=pewarnaan.getKelompokWarna(idx);
            int jumlah=pewarnaan.jumlahTerpakai;
            for (int j=0;j<jumlah;j++){
                System.out.println(kecamatan.getNamaKecamatan(kelompok[j]));
            }
            loop=pewarnaan.getLogic();

            // UNTUK PERBANDINGAN JUMLAH PENDUDUK
            int banding[]=new int[2];
            if(Max <= jumlah){  // CHECK
                int arrVertex[]=new int[jumlah];
                for(int j=0;j<jumlah;j++){
                    arrVertex[j]=ketetanggaancpy[kelompok[j]];
                }
                tools.insertion(arrVertex,kelompok, jumlah);
                Max=jumlah;
                banding=tools.getMax(arrVertex,kelompok,kecamatan.getPenduduk(),jumlah);
            } 
            if(maxPenduduk<banding[1]){    
                idxMax=banding[0];
                maxPenduduk=banding[1];
            }
            System.out.println();
            i++;
        }

        System.out.print("Penduduk terbesar dari kelompok terbesar dan tetangga terbanyak adalah : ");
        System.out.println(kecamatan.getNamaKecamatan(idxMax));      
    }  
}

class ColorGraph{
    int [] vertexTerpakai;  
    int jumlahVertex;
    int jumlahTerpakai=0;
    public ColorGraph(int banyak){
        vertexTerpakai=new int[banyak];
        jumlahVertex=banyak;
    }
    private String color(int idx){
        String warna[]={"Merah","Jingga","Biru","Hijau","Hitam","Kuning","Putih","Ungu","Abu-Abu","Merah Muda","Coklat","Hijau Tua"};
        return warna[idx];
    }
    private int[] pengelompokan(int idx[]) {
        KotaBandung kecamatan=new KotaBandung();
        int [] grupWarna=new int[100]; 
        int idxTemp=0;       
        for(int p=0;p<jumlahVertex;p++){
            if(vertexTerpakai[idx[p]]==0){
                grupWarna[idxTemp]=idx[p];
                vertexTerpakai[idx[p]]=1;
                idxTemp++;
                break;
            }
        }
        for (int i=0;i<jumlahVertex;i++){
            int next=i;
            if(vertexTerpakai[i]==1){
                continue;
            }
            boolean LogicMasuk=true;
            if(idxTemp!=0){
                for (int j=0;j<idxTemp;j++){
                    int dalam=grupWarna[j];
                    if(kecamatan.getBertetangga(dalam, next)){
                    } 
                    else {
                        LogicMasuk=false;
                        break;
                    }
                }
            }
            if(LogicMasuk){
                grupWarna[idxTemp]=next;
                vertexTerpakai[next]=1;
                idxTemp++;
            }
        }
        this.jumlahTerpakai=idxTemp;
        return grupWarna;
    }
    private boolean checkAll(){
        boolean check=false;
        for(int idx: vertexTerpakai){
            if (idx==0){
                return true;
            }
        }
        return check;
    }    
    public String getColor(int idx){
        return color(idx);
    }
    public int[] getKelompokWarna(int idx[]){
        return pengelompokan(idx);
    }
    public int getJumlahAnggota(){
        return this.jumlahTerpakai;
    }
    public boolean getLogic(){
        return checkAll();
    }
}

class KotaBandung {
    /**
     * Daftar Kecamatan Kota Bandung
     * Andir = 0
     * Antapani = 1         
     * Arcamanik  = 2
     * Astanaanyar = 3
     * Babakan Ciparay = 4
     * Bandung Kidul = 5
     * Bandung Kulon = 6
     * Bandung Wetan = 7
     * Batununggal = 8
     * Bojongloa Kaler = 9
     * Bojongloa Kidul = 10
     * Buahbatu = 11
     * Cibeunying Kaler = 12
     * Cibeunying Kidul = 13
     * Cibiru = 14
     * Cicendo = 15
     * Cidadap = 16
     * Cinambo = 17
     * Coblong = 18
     * Gedebage = 19
     * Kiaracondong = 20
     * Lengkong = 21
     * Mandalajati = 22    
     * Panyileukan = 23    
     * Rancasari = 24 
     * Regol = 25    
     * Sukajadi = 26
     * Sukasari = 27
     * Sumurbandung = 28
     * Ujungberung = 29
     */
    private int jumlahKecamatan=30;
    private int[][] AdjacencyMatriksKecamatan(){ 
        int matriksAdjacencyKecamatan[][]={ 
                {0,0,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0},//0
                {0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0},//1
                {0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1},//2
                {1,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//3
                {1,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//4
                {0,0,0,1,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0},//5
                {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//6
                {0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,1,0},//7
                {0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0},//8
                {1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//9
                {0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//10
                {0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},//1
                {0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//12
                {0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},//13
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},//14
                {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0},//15
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0},//16
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},//17
                {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},//18
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0},//19
                {0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},//20
                {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},//21
                {0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},//22
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1},//23
                {0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//24
                {1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},//25
                {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,1,0,0},//26
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},//27
                {1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0},//28
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0}//29
            };                          
        return matriksAdjacencyKecamatan;
    } 
    private  String namaKecamatan(int idx){
        String Kecamatan[]={"Andir","Antapani","Arcamanik","Astana anyar","Babakan Ciparay","Bandung Kidul","Bandung Kulon",
                "Bandung Wetan","Batununggal","Bojongloa Kaler","Bojongloa Kidul","Buah Batu","Cibeunying Kaler","Cibeunying Kidul",
                "Cibiru","Cicendo","Cidadap","Cinambo","Coblong","Gedebage","Kiaracondong","Lengkong","Mandalajati","Panyileukan",
                "Rancasari","Regol","Sukajadi","Sukasari","Sumur Bandung","Ujungberung"};
        return Kecamatan[idx];
    }
    private int[] Penduduk(){
        int dataPenduduk[]={99378,78817,76913,74049,139374,60129,133275,29019,121324,123569,86004,101426,69917,113110,73114,
                96413,53960,25266,114665,40398,130347,71448,71403,39634,83904,80515,101740,77284,37187,86804};
        return dataPenduduk;
    }
    private int[] matriksJumlahKetetanggaan(){   // untuk grouping bedasarkan jumlah ketetanggaan
        Tools Tools=new Tools();
        int[] matriksKetetanggaan=Tools.tetanggaan(AdjacencyMatriksKecamatan(),jumlahKecamatan);
        return matriksKetetanggaan;
    }
    private boolean bertetangga (int a,int b){  // untuk mengecek apakah a dan b bertetangga
        int adj[][]=AdjacencyMatriksKecamatan();

        if(adj[a][b]==1 || adj[b][a]==1){
            return false;
        }else {
            return true;
        }  
    }
    public int[] getPenduduk(){
        return Penduduk();
    }
    public int getPendudukIdx(int idx){
        int[] arr=Penduduk();
        return arr[idx];
    }
    public boolean getBertetangga(int kecamatanSatu,int kecamatanDua){
        return bertetangga(kecamatanSatu,kecamatanDua);
    }
    public int getJumlahKecamatan(){
        return jumlahKecamatan;
    }
    public int[] getMatriksJumlahKetetanggaan(){
        return matriksJumlahKetetanggaan();

    }
    public String getNamaKecamatan(int index){
        return namaKecamatan(index);
    }
    public int[][] getAdj(){
        return  AdjacencyMatriksKecamatan();
    }
}

class Tools {
    public int[] getMax(int arrVertex[],int kelompok[],int arrPenduduk[],int jumlah){  //CHECK
        int max=arrVertex[0];
        int posisi=kelompok[0];
        int maxPenduduk=arrPenduduk[posisi];
        int j=0;
        int hasil[]=new int[2];
        while (j<jumlah && max==arrVertex[j] ){
            int tempPosisi=kelompok[j];
            if(maxPenduduk < arrPenduduk[tempPosisi]){
                maxPenduduk=arrPenduduk[tempPosisi];
                posisi=tempPosisi;
            }
            j++;
        }
        hasil[0]=posisi;
        hasil[1]=maxPenduduk;     
        return hasil;
    }
    public int[] getIdx(int jumlahKecamatan){
        int idx[]=new int[jumlahKecamatan];
        for (int i=0;i<jumlahKecamatan;i++){
            idx[i]=i;
        }
        return idx;
    }
    public int[] tetanggaan(int [][]arr,int jumlahKecamatan){
        int tetangga[] =new int[jumlahKecamatan];
        int banyak=0;
        for (int i=0;i<jumlahKecamatan;i++){
            banyak=0;
            for (int j=0;j<jumlahKecamatan;j++){
                banyak+=arr[i][j];
            }
            tetangga[i]=banyak;
        }
        return tetangga;
    }
    public  void insertion (int[] array,int[] idx,int panjang){
        int i=0;
        int temp;
        while (i<panjang){
            int u=i;
            while((u>0)&&(array [u-1] <array[u])){
                temp=array[u-1];
                array[u-1]=array[u];
                array[u]=temp;
                temp=idx[u-1];
                idx[u-1]=idx[u];
                idx[u]=temp;      
                u--;               
            }
            i++;
        }
    }
}

