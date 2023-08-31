//package kelurahanbandung;
/**
 *
 * @author Dimas-MSI
 */
public class PencarianKecamatan {
    public static void main(String[] args) {
        KotaBandung kotaBandung= new KotaBandung();
        Tools tools=new Tools();
        int[] ketetanggaan = kotaBandung.getMatriksJumlahKetetanggaan();
        int[] idx=tools.getIdx(kotaBandung.getJumlahKecamatan());
        tools.insertion(ketetanggaan,idx,kotaBandung.getJumlahKecamatan());
        int max=ketetanggaan[0];
        int print=0;
        System.out.println("Dapat membuat pusat perbelanjaan di:");
        for (int i=0;i<kotaBandung.getJumlahKecamatan();i++){
            if (ketetanggaan[i]==max){
                if(print!=0){
                    System.out.println("atau");
                }
                System.out.println(kotaBandung.getNamaKecamatan(idx[i]));
                print++;
            }      
        }  
    }  
}

class KotaBandung {
   private int jumlahKecamatan=30;
        private int[][] AdjacencyMatriksKecamatan(){ 
            int matriksAdjacencyKecamatan[][]={ 
            {0,0,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
            {0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
            {1,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,1,0,0,1,0,0,0,0,0,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0},
            {1,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0},
            {0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1},
            {0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
            {1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {1,0,0,1,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0}
            };                          
         return matriksAdjacencyKecamatan;
    } 
        private  String getKota(int idx){
        String kota[]={"Andir","Antapani","Arcamanik","Astana anyar","Babakan Ciparay","Bandung Kidul","Bandung Kulon",
           "Bandung Wetan","Batununggal","Bojongloa Kaler","Bojongloa Kidul","Buah Batu","Cibeunying Kaler","Cibeunying Kidul",
           "Cibiru","Cicendo","Cidadap","Cinambo","Coblong","Gedebage","Kiaracondong","Lengkong","Mandalajati","Panyileukan",
           "Rancasari","Regol","Sukajadi","Sukasari","Sumur Bandung","Ujungberung"};
        return kota[idx];
    }
        private int[] matriksJumlahKetetanggaan(){
        Tools Tools=new Tools();
        int[] matriksKetetanggaan=Tools.tetanggaan(AdjacencyMatriksKecamatan(),jumlahKecamatan);
        return matriksKetetanggaan;
        }
        public int getJumlahKecamatan(){
            return jumlahKecamatan;
        }
        public int[] getMatriksJumlahKetetanggaan(){
            return matriksJumlahKetetanggaan();

        }
        public String getNamaKecamatan(int index){
            return getKota(index);
        }
}

class Tools {
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

