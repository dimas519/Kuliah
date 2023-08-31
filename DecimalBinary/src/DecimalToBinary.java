


/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        binary bin =new binary();
        
        int jumlah=sc.nextInt();
        int i=0;
        
        while(i<jumlah){
            int angka=sc.nextInt();
            if (angka==0){
                System.out.printf("%s\n","0");
            }
            else if(angka>0){
                String hasil= (bin.binRek(angka));
                int panjang=hasil.length();
                String balik="";
                while(panjang>0){
                    balik= balik+ hasil.charAt(panjang-1);
                    panjang--;
            }
            System.out.println(balik);
            }
            i++;
        }
}
}
   
class binary{
    String binRek(int angka){
        String hasil="";
        if(angka==1){
        hasil="1";
        } else {
            int pembagi=angka/2;
            int mod=angka%2;
            
            if(mod==0){
                hasil+=0;
            } else {
                hasil+=1;
            }
           

            hasil=hasil+binRek(pembagi);
    }
            return hasil;
            
            
                
                }
    
}
            
        
    
    
    
    
    
