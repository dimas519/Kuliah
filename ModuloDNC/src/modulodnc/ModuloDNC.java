/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package modulodnc;

/**
 *
 * @author USER
 */
import java.util.Scanner;
public class ModuloDNC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kasus=sc.nextInt();
        
        for(int i=0;i<kasus;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
       
        modulo modulo =new modulo();
        
        int hasil=(int)modulo.rekursif(a,b);
        System.out.println(hasil);
        
        }
    }  
}

class modulo{
    int a;
    int b;
    public double rekursif(int a, int b){
       
     if(a==1){
         return (4%b);
     } else {
         double temp=rekursif(a-1,b);
         return (temp*temp) %b;
     }

    }

}
