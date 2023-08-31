/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
/*
Nama: Dimas Kurniawan
NPM: 61819019judul soal>
Problem: <Reversed Binary Numbers>
Status: <AC>
*/
 

#include <stdio.h>
#include <stdlib.h>
#include <math.h>


/*
 * 
 */

int rek (int angka, int* bin,int i){
    if(angka==1){
        bin[i]=1;
        return i+1;
    } 
    else {
    
        bin[i]=angka%2;
        angka/=2;
        return rek(angka,bin,i+1);
    }
    
    
    
    
    
}




int main() {
    int angka,i=0;
    scanf("%d",&angka);
    int bin[65];
    
    int hasil=rek(angka,bin,i);
    int balik = 0;
    int pengali=0;

    for (i=hasil-1;i>=0;i--){
        if (bin[i]==1){
            
            balik=balik+pow(2,pengali);
        }
        pengali++;
    }
        
        printf("%d",balik);
        
        
        
        
        
        
        
        
        
    return 0;
    
}




