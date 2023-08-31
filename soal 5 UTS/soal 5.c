/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
Nama: Dimas Kurniawna
NPM:  6181901019
Problem: <Rational Arithmetic>
Status: <AC>
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*
 * 
 */


long long int gcd (long long int atas,long long int bawah){
    

    
    
    if(atas==0){
        return bawah;
    } else {
        return gcd(bawah%atas,atas);
    }
    
    
    
}






int main(int argc, char** argv) {
    
    int x=0;
    int ulang=0;
    scanf("%d",&ulang);
    
    for(x=0;x<ulang;x++){
        
        
        
        
    
    
    
    
    
    long long  a,b,c,d;
    char operasi;
    
    scanf("%lld %lld %c %lld %lld",&a,&b,&operasi,&c,&d);
    
    
    
    


    
    
    long long atas=0;
    long long bawah=0;
    
    if(a==0 &&b ==0 && c==0 &&d==0){
        atas=0;
        bawah=0;
    } else  if(operasi=='+'){
        
        
        atas=(a*d)+(b*c);
        bawah=(b*d);
        
        
        
    } else if (operasi=='-'){
        
        
        atas=(a*d)-(b*c);
        bawah=(b*d);

    } else if (operasi=='*'){
        atas=a*c;
        bawah=b*d;
        
    } else {
        atas=a*d;
        bawah=b*c;
    
    }
    
    
    
    
    
    if(bawah<0){
        bawah=bawah*-1;
        atas=atas*-1;
    
    }
    
      if ( atas < 0){
        long long  b=-atas;
        long long Fpb=gcd(b,bawah);
        atas=atas/Fpb;
        bawah=bawah/Fpb;
    
    } else {

        long long Fpb=gcd(atas,bawah);
        atas=atas/Fpb;
        bawah=bawah/Fpb;
        
        
        
        
    }
    
    
    
    printf("%lld / %lld\n",atas,bawah);
    
    
    }
    
    
    return 0;
}

