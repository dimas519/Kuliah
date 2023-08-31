/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daa.modnumber;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dimas Kurniawan
 */
public class DAAMODnumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Eulid(1990019019,23));
        long c[]=extendedeuclid(60,80);
        System.out.println(c[0]);
        System.out.println(c[1]);
        System.out.println(c[2]);
    }
    
    public static long Eulid(long a,long b){
        if(b==0){
            return a;
        }else{
            return Eulid(b,a%b);
        }
    }
    
    public static long[] extendedeuclid(long a, long b) {
        if(b==0){
            long x[]={a,1,0};
            return x;
        }else{
            long c[]= extendedeuclid(b, a%b);  
            long temp=c[1];
            long temp2=c[2];
            c[1]=c[2];
            c[2]=temp-(a/b)*temp2;
            return c;
            
        }
    }
    
    public static long LCM(long a, long b) {
        return (a*b)/ Eulid(a,b);
    }
    
    public static List intfactorization(long x) {
       List l=new ArrayList();
        long c =x;
        while (c %2 ==0){
            l.add(2);
            c/=2;
        }
        int i=3;
        while (i<= Math.pow(c,0.5)+1){
            if(i %c==0){
                l.add(i);
                c=c/i;
            }else{
                i+=2;
            }
        }
        
        if(c>1){
            l.add(c);
        }
        
        return l;
    }
    
    public static List mlesolver(long a, long b, long n){
        List l=new ArrayList();
        long x[]=extendedeuclid(a,n);
        if(x[1]%b==0){
            long g=((x[1]*(b/x[1]))%n);
            for(int i=0;i<x[1];i++){
                l.add(g+(i*(n/x[1]))%n);
            }
        }
        return l;
    }
    
public long abmodc(long a, long b, long c) {
        if(a==0){
            return 0;
        }
        
        
        if(b==0){
            return 1;
        }
         long hasil;
        if(b==1){
            return a%c;
        }else {
            long mod=a%c;
            hasil=abmodc(mod,b/2,c);
            long res=(hasil*hasil) %c;
            
            
            
            if(b %2==1){

               res=(res*mod)%c;
               
            }
            return res;
        }
        
        
    }
    
    
    
    
    
    
    
    
    
    
}
