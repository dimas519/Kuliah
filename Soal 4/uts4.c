/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 Nama:  Dimas Kurniawan 
NPM:    6181901019
Problem: <Pyramid Construction>
Status: <AC>
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int h,n,m,besar=0,kecil=0;
    
    scanf("%d %d %d",&h,&n,&m);
    
    
    
    
    int butuh =0;
    
    butuh = 1 + ((4 * (h-1)*h)/2) -n - (m*2);
    
    if(butuh<0){
        
        if(n<1){

            kecil=1;
        } 
    
     } else {
            
            besar=butuh/2;
            kecil=butuh%2;
     }
        
        
        
        
        
        
   
    
    
    printf("%d %d\n",kecil,besar);
    
}

