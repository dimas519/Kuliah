
/**
 *
 * @author Dimas
 */
public class DosenDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dosen Dosen1 = new Dosen();
        Dosen Dosen2 = new Dosen();

        
        Dosen1.changeKelas(5);
        Dosen1.changePerwalian(2);
        Dosen1.printStates();

        Dosen2.changeKelas(13);
        Dosen2.changePerwalian(33);
        Dosen2.printStates();
    }
    
}
class Dosen {

    int kelas = 0; // jumlah kelas yang diajar dosen tersebut
    int perwalian = 1;//jumlah mahasiswa wali yang sudah perwalian dengan dosen tersebut

    void changeKelas(int newValue) {
         kelas = newValue;
    }

    void changePerwalian(int newValue) {
         perwalian = newValue;
    }


    void printStates() {
         System.out.println("Jumlah kelas yang diajar:" +
             kelas +" jumlah mahasiswa:"+perwalian );
    }
}