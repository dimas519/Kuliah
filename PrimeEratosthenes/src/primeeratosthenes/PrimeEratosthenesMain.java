package primeeratosthenes;
 
import java.util.Arrays;
import java.util.Scanner;
 
/**
 *
 * @author Dimas
 */
public class PrimeEratosthenesMain {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
         int  batas =sc.nextInt();
         PrimeEratosthenes  Prime = new  PrimeEratosthenes();
        long start =System.currentTimeMillis();
        int[] hasil=Prime.printPrime(batas);
        long end =System.currentTimeMillis();
        long waktuProses=end-start;
        int i =2;
        while (i<=batas){
            if(hasil[i]==1){
            System.out.println(i);
        }
            i++;
        }
        System.out.println(waktuProses);
    }
    
}
class PrimeEratosthenes {
    public int[] printPrime(int n){
    int[] logicArray =new int[n+2];
    int i=0;
    while (i<=n){
            logicArray[i]=1;
            i++;
        }
    i=2;
    while (i<=n){
    int j = 2;
    boolean isPrime =true;
        while ( (isPrime == true) && ( j <= (int)Math.sqrt(i)) ) {
         if (i % j == 0){
                isPrime = false;
            }
                else {
                j = j + 1;
                }
         if (isPrime==false){
             logicArray[i]=0;
         }
         else {
             logicArray[i]=1;
         }
         }
       i++;
       while ( (logicArray[i]==1) && (i!=2 ) && (i!=3) ){
           i++;
       }
       
    }
    return logicArray;
    }
}