interface DosenInterface {
    void tambahKelas(int newValue);

    void tambahPerwalian(int newValue);
}

class InDosen implements DosenInterface {

    int kelas = 0;
    int perwalian = 0;

   public void tambahKelas(int newValue) {
         kelas += newValue;
    }

    
    public void printStates() {
         System.out.println("Jumlah kelas yang diajar:" +
             kelas +" jumlah mahasiswa:"+perwalian );
    }

class Dosen2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InDosen Dosen1 = new InDosen();
        InDosen Dosen2 = new InDosen();
        
        Dosen1.tambahKelas(6);
        Dosen1.tambahPerwalian(43);
        Dosen1.printStates();

        Dosen2.tambahKelas(1354);
        Dosen2.tambahPerwalian(343);
        Dosen2.printStates();
    }
    
}