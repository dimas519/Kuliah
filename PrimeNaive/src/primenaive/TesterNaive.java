package primenaive;
 
/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class TesterNaive {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
         int  batas =sc.nextInt();
         long start;
         long end;
         long waktuProses;
         PrimeNaive  Prime = new  PrimeNaive();
        start =System.currentTimeMillis();
        String hasil=Prime.printPrime(batas);
        end =System.currentTimeMillis();
        waktuProses=end-start;
        System.out.println(hasil);
        System.out.println(waktuProses);
    }
    
}
class PrimeNaive {
    public String printPrime(int n){
    String  result = "";
    int i =2;
while(i  < n) {
 boolean isPrime = true ;
 int j = 2;
        while ( (isPrime == true) && ( j <= (int)Math.sqrt(i)) ) {
            if (i % j == 0){
                isPrime = false;
            }
                else {
                j = j + 1;
                }
        }
             if (isPrime == true){
                result = result + i +" ";
                }           
    i++;
    }
return result;
        
        
    }
    
}