/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rapat;

/**
 *
 * @author Dimas
 */
import java.util.Scanner;
import java.util.Arrays;
public class Rapat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        int kasus=Integer.parseInt(sc.nextLine());
                
        while (kasus!= 0){
        
            int pagi[]=new int[kasus];
            int malam[]=new int[kasus];
            int i=0;
            
            for (i=0;i<kasus;i++){
                pagi[i]=-1;
                malam[i]=-1;
            }
            
            int jumlahPagi=0;
            int jumlahMalam=0;
            
            i=0;
            while (i<kasus){
                String input=sc.nextLine();
                
                    int jam=Integer.parseInt(input.substring(0,2))*60;
                    int menit=Integer.parseInt(input.substring(3,5));
                    
                    if(jam==720){
                        jam-=720;
                    }
                
                if(input.charAt(6)=='a'){
                    
                   
                    
                    
                    pagi[i]=jam+menit;
                    jumlahPagi+=1;
                } else {
                    malam[i]=jam+menit;
                    jumlahMalam++;
                }
                i++;       
            }
            
            Arrays.sort(pagi);
            Arrays.sort(malam);
            
            
            
            
            
            for (i=0;i<kasus;i++){
            int Ljam=(int)pagi[i]/60;
            int Lmenit=pagi[i]%60;
            
            if(Ljam==0){
                Ljam+=12;
            }
            
             if(Ljam==-1|| Lmenit==-1){
               
            } else {
                 
                 
             
            String jam="";
            String menit="";
            
            if(Ljam<10){
                jam="0"+Ljam;               
            }
            else {
                jam=""+Ljam;

            }
            
            
            if (Lmenit<10){
                menit="0"+Lmenit;
            } else {
                menit=""+Lmenit;
            }
                
                
                
                
            System.out.println(jam+":"+menit+" "+"a.m.");
            
             
                    }
             
             
            }
            
            for (i=0;i<kasus;i++){
                
            int Ljam=(int)malam[i]/60;
            int Lmenit=malam[i]%60;
            
            
            if(Ljam==721){
                Ljam+=720;
            }
            
           
            
            if(Ljam==-1|| Lmenit==-1){
                
            } else {
            
            
            
            String jam="";
            String menit="";
            
            if(Ljam<10){
                jam="0"+Ljam;
            }
            else {
                jam=""+Ljam;

            }
            
            
            
            if (Lmenit<10){
                menit="0"+Lmenit;
            } else {
                menit=""+Lmenit;
            }
            
            System.out.println(jam+":"+menit+" "+"p.m.");
            
            
            }
                    }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        
            kasus=Integer.parseInt(sc.nextLine());
        }
        
        
        
        
    }
    
}
