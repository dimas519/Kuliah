/**
 *
 * @author Dimas
 */
import java.util.Scanner;
public class Parentheses {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner sc=new Scanner (System.in);
      parentheses1 par =new parentheses1();
      
      String Sjumlah=sc.nextLine();
      int jumlah=Integer.parseInt(Sjumlah);
      int i=0;
      
      while(i<jumlah){
            String masukan=sc.nextLine();
            int panjang =masukan.length();
            String hasil="";
            hasil=par.output(masukan,panjang-1,hasil);
            int len=hasil.length();
            len--;
            String balik="";
            while (len>=0){
                balik+=hasil.charAt(len)+"";
                        len--;
            }
            
            
            System.out.println(balik);
          
          i++;
      }
    }
    
}
 
class parentheses1 {
    public String output(String input, int panjang, String hasil ){
        char karakter=input.charAt(panjang);
        
        
         if (karakter=='('){
                hasil="(";
                return hasil;
            
        }else if (karakter==')') {
            hasil=")";
            return hasil+output(input,panjang-1,hasil);
            
        } else if (hasil.equals("")==false){
            hasil=karakter+"";
            return hasil+output(input,panjang-1,hasil);
        } else {
            return output(input,panjang-1,hasil);
        }
       
        
       
        
    }
    
}