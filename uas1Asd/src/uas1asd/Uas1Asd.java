/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas1asd;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.LinkedList;
public class Uas1Asd {

    public static void main(String[] args) {
        LinkedList <String> ll=new LinkedList<>();
        
        
        Scanner sc = new Scanner(System.in);
        int banyak=sc.nextInt();
        int berita=sc.nextInt();
        
        
        for (int pasukan=1;pasukan<=banyak;pasukan++){
            ll.addLast(pasukan+"");
        }
        
        
        for(int i=0;i<berita;i++){
            int dari=sc.nextInt();
            int sampai=sc.nextInt();
        
        
  
            
            int temp=dari;
            sampai++;
            do{
                ll.remove(dari+"");
            dari++;
            }while (dari<sampai); 
           
            
        if(ll.size()==0){
            System.out.println("* *");
        } else if((temp+"").equals(ll.getFirst())){
            System.out.print("*");
            System.out.println(" "+ll.get(dari));
                
        }else if ((dari+"").equals(ll.getLast())){
            System.out.println(ll.get(temp)+" *");
        }
            
        
        
    }
    

}



}
 


