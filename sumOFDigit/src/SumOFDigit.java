
/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class SumOFDigit {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        sum jumlahDigit=new sum();
        
        int jumlah=sc.nextInt();
        int i=0;
        while (i<jumlah){
           int angka=sc.nextInt();
             String logic=angka+"";
             int panjang=logic.length();
             int[] array=new int[panjang];
             
             int b=0;
             while (b<panjang){
                 char digit=logic.charAt(b);
                 array[b]= (int)digit-48;
  
                 b++;
             
             
           System.out.println(jumlahDigit.jumlah(array,panjang));
            i++;
        }
    }
    
}
}
class sum{
    private int jumlahRekursif(int[] array,int panjang){
    if (panjang==0){
        return array[0];
    } else {
        return array[panjang]+jumlahRekursif(array,panjang-1);
    }
    
    }
public int jumlah(int []array ,int panjang){
    return jumlahRekursif(array,panjang);

  
}

}