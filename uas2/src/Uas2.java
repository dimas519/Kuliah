/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package uas2;

/**
 *
 * @author Dimas Kurniawan
 */
import java.util.Scanner;
import java.util.Stack;
public class Uas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a=sc.nextInt();
        
        int k=1;
        while (a!=0){
            Stack <String> tumpuk=new Stack<>();
            String arr[]=new String[a];
            
            for(int i=0;i<a;i++){
                arr[i]=sc.next();
            }
            
            System.out.println("SET"+" "+k);
            
            for(int i=0;i<a;i++){
                if(i%2==0){
                    System.out.println(arr[i]);
                }else {
                    tumpuk.push(arr[i]);
                }
                
                
            }
            
            while (!tumpuk.isEmpty()){
                System.out.println(tumpuk.pop());
            }
            
            
            
        
            
            
            k++;
            a=sc.nextInt();
        }
        
        
                
    }
    
}
