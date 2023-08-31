/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//package prime;
import java.util.Scanner;
/**
 *
 * @author Kurni
 */
public class PRIME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // TODO code application logic here
        TesterNaive tn =new TesterNaive();
        TesterEratosthenes te=new TesterEratosthenes();
        int number=sc.nextInt();
        tn.test(number);
        te.test(number);
    }
    
    }
    class TesterNaive{
        public void test(int n){
            PrimeNaive pn=new PrimeNaive();
            long start= System.currentTimeMillis();
            System.out.println(pn.PrintPrime(n));
            long end= System.currentTimeMillis();
            long proses=end-start;
            System.out.println(proses);
        }
    }
    
    
    class PrimeNaive{
        public String PrintPrime(int n){
            String res="";
            boolean isPrime;
            int j;
            for (int i=2;i<=n;i++){
                isPrime=true;
                j=2;
                while(j<=Math.sqrt(i)&&isPrime){
                    if (i %j ==0){
                        isPrime=false;
                    }else{
                        j++;
                    }
                }
                
                if(isPrime){
                    res+=i+" ";
                }
            }
            return res;
        }
        
        
        
        
    }


class TesterEratosthenes{
    public void test(int n){
        PrimeEratosthenes pe=new PrimeEratosthenes();
            long start= System.currentTimeMillis();
            System.out.println(pe.PrintPrime(n));
            long end= System.currentTimeMillis();
            long proses=(end-start);
            System.out.println(proses);
    }
}

class PrimeEratosthenes{
    public String PrintPrime(int n){
        boolean notPrime[]=new boolean[n+1];
        int curr;
        for(int i=2;i<=n;i++){
            curr=2;
            while(i*curr<=n){
                
                notPrime[i*curr]=true;
                curr++;
            }
        }
        String res="";
        for(int i=2;i<=n;i++){
            if(!notPrime[i]){
                res+=i+" ";
            }2
        }
        return res;
        
    }

}
    
    
    
    
    
    

